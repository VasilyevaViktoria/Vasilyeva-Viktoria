package peacock.dao;

import peacock.connect.ConnectionPool;
import peacock.entity.Genre;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@NoArgsConstructor(access = AccessLevel.PRIVATE)

public class GenreDao {

    private static final GenreDao INSTANCE = new GenreDao();

    private static final String SAVE = "INSERT INTO films_storage.genre(name)" +
            " VALUES (?)";

    private static final String FIND_ALL = "SELECT id, name FROM films_storage.genre";


    public int save(Genre genre) {
        try {
            Connection connection = ConnectionPool.getConnection();
            PreparedStatement genreStatement = connection.prepareStatement(SAVE, Statement.RETURN_GENERATED_KEYS);

            genreStatement.setString(1, genre.getName());
            genreStatement.executeUpdate();

            ResultSet generatedKeys = genreStatement.getGeneratedKeys();
            if (generatedKeys.next()) {
                return generatedKeys.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    private static final String GET_ID_BY_GENRE = "SELECT id, name FROM films_storage.genre WHERE genre_id = ?";

    public Optional<Genre> getGenreNameById(int genreId) {
        Optional<Genre> genre = Optional.empty();
        try {
            Connection connection = ConnectionPool.getConnection();
            PreparedStatement genreStatement = connection.prepareStatement(GET_ID_BY_GENRE, Statement.RETURN_GENERATED_KEYS);
            genreStatement.setInt(1, genreId);
            ResultSet resultSet = genreStatement.executeQuery();

            if (resultSet.next()) {
                genre = Optional.of(getGenreFromResultSet(resultSet));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return genre;
    }

    private static final String GET_GENRE_BY_ID = "SELECT id, name FROM films_storage.genre WHERE name = ?";

    public int getGenreIdByName(String genreName) {
        try {
            Connection connection = ConnectionPool.getConnection();
            PreparedStatement genreStatement = connection.prepareStatement(GET_GENRE_BY_ID, Statement.RETURN_GENERATED_KEYS);
            genreStatement.setString(1, genreName);
            ResultSet resultSet = genreStatement.executeQuery();

            if (resultSet.next()) {
                return resultSet.getInt("id");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    private Genre getGenreFromResultSet(ResultSet resultSet) throws SQLException {
        return Genre.builder()
                .id(resultSet.getInt("genre_id"))
                .name(resultSet.getString("genre_name"))
                .build();
    }

    public List<Genre> findAll() {
        List<Genre> genres = new ArrayList<>();
        try (Connection connection = ConnectionPool.getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(FIND_ALL);
            while (resultSet.next()) {
                Genre genre = getGenreFromResultSet(resultSet);
                genres.add(genre);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return genres;
    }

    public static GenreDao getInstance() {
        return INSTANCE;
    }
}
