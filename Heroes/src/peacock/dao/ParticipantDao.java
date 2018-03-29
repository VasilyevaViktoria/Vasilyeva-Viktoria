package peacock.dao;

import peacock.connect.ConnectionPool;
import peacock.entity.Participant;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ParticipantDao {

    private static final ParticipantDao INSTANCE = new ParticipantDao();

    private static final String SAVE = "INSERT INTO films_storage.participant(name, date_of_birth)" +
            " VALUES (?, ?)";

    private static final String GET_PARTICIPANTS_BY_FILM_ID =
            "SELECT participant.id, participant.name, " +
                    "participant.date_of_birth, career.name FROM films_storage.participant " +
                    "LEFT JOIN films_storage.film_participant " +
                    "ON participant.id = film_participant.participant_id " +
                    "LEFT JOIN career " +
                    "ON film_participant.career_id = career.id " +
                    "WHERE film_participant.film_id = ?";

    private static final String GET_PARTICIPANT_BY_ID = "SELECT id, name, date_of_birth FROM films_storage.participant WHERE id = ? ";

    private static final String FIND_ALL = "SELECT id, name, date_of_birth FROM films_storage.participant";

    public Participant save(Participant participant) {
        try {
            Connection connection = ConnectionPool.getConnection();
            PreparedStatement genreStatement = connection.prepareStatement(SAVE, Statement.RETURN_GENERATED_KEYS);

            genreStatement.setString(1, participant.getName());
            genreStatement.setDate(2, Date.valueOf(participant.getDateOfBirth()));

            genreStatement.executeUpdate();

            ResultSet generatedKeys = genreStatement.getGeneratedKeys();
            if (generatedKeys.next()) {
                participant.setId(generatedKeys.getLong("id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return participant;
    }

    public List<Participant> findAll() {
        List<Participant> participants = new ArrayList<>();
        try (Connection connection = ConnectionPool.getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(FIND_ALL);
            while (resultSet.next()) {
                Participant participant = getParticipantFromResultSet(resultSet);
                participants.add(participant);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return participants;
    }

    private Participant getParticipantFromResultSet(ResultSet resultSet) throws SQLException {
        return Participant.builder()
                .id(resultSet.getLong("id"))
                .name(resultSet.getString("name"))
                .dateOfBirth(resultSet.getDate("date_of_birth").toLocalDate())
                .build();
    }

    public Optional<Participant> findById(Long participantId) {
        Optional<Participant> participant = Optional.empty();
        try (Connection connection = ConnectionPool.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(GET_PARTICIPANT_BY_ID)) {
            preparedStatement.setLong(1, participantId);

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                participant = Optional.of(getParticipantFromResultSet(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return participant;
    }

    private static final String PARTICIPANT_TO_FILM = "INSERT INTO films_storage.film_participant (participant_id, film_id, career_id) VALUES (?, ?, ?)";


    public boolean addParticipantToFilm(long participantId, long filmId, long careerId) {
        try (Connection connection = ConnectionPool.getConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(PARTICIPANT_TO_FILM, Statement.RETURN_GENERATED_KEYS)) {
                preparedStatement.setLong(1, participantId);
                preparedStatement.setLong(2, filmId);
                preparedStatement.setLong(3, careerId);
                preparedStatement.executeUpdate();
                ResultSet resultSet = preparedStatement.getGeneratedKeys();
                if (!resultSet.next()) {
                    return true;
                }
            }
        } catch (SQLException e) {
            return false;
        }
        return false;
    }

    public List<Participant> getParticipantsByFilmId(long filmId) {
        List<Participant> filmParticipantsList = new ArrayList<>();
        try (Connection connection = ConnectionPool.getConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(GET_PARTICIPANTS_BY_FILM_ID)) {
                preparedStatement.setLong(1, filmId);
                ResultSet resultSet = preparedStatement.executeQuery();

                while (resultSet.next()) {
                    Participant participant = Participant.builder()
                            .id(resultSet.getLong("participant_id"))
                            .name(resultSet.getString("participant_name"))
                            .dateOfBirth(resultSet.getDate("date_of_birth").toLocalDate())
                            .career(resultSet.getString("career_name"))
                            .build();
                    filmParticipantsList.add(participant);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return filmParticipantsList;
    }

    public static ParticipantDao getInstance() {
        return INSTANCE;
    }

}
