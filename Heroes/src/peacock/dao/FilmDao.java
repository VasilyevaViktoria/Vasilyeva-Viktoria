package peacock.dao;

import peacock.connect.ConnectionPool;
import peacock.entity.Country;
import peacock.entity.Film;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import peacock.entity.Review;
import peacock.entity.User;

import java.sql.*;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class FilmDao {

    private static final FilmDao INSTANCE = new FilmDao();

    private static final String SAVE = "INSERT INTO films_storage.film(name, " +
            "duration, premiere, age_limit, country_id, description) VALUES (?, ?, ?, ?, ?, ?)";

    private static final String FIND_ALL =
            "SELECT" +
                    "  f.id AS film_id," +
                    "  c.id AS country_id," +
                    "  c.name AS country_name," +
                    "  f.name AS film_name," +
                    "  f.duration,f.premiere, f.age_limit, f.description" +
                    "  FROM films_storage.film f" +
                    "  LEFT JOIN films_storage.country c" +
                    "  ON f.country_id = c.id";

    private static final String GET_BY_ID =
            "SELECT f.id AS film_id, " +
                    "f.name AS film_name, " +
                    "u.id AS user_id, " +
                    "u.name AS user_name, " +
                    "review.id AS film_rating_id, " +
                    "review.comment AS film_rating_comment " +
                    "review.stars AS film_rating_stars " +
                    "FROM films_storage.film f " +
                    "INNER JOIN films_storage.film_rating review " +
                    "ON review.film_id = f.id " +
                    "INNER JOIN films_storage.user u " +
                    "ON review.user_id = u.id " +
                    "WHERE f.id = ?";

    private static final String FIND_BY_ID = FIND_ALL + " WHERE f.id = ?";

    private static final String SAVE_GENRE_FILM = "INSERT INTO films_storage.genre_film(film_id, genre_id) VALUES (?, ?);";

    private static final String FIND_FILM_BY_YEAR_OF_ISSUE =
            "SELECT id, name, duration, premiere, age_limit, country_id,description " +
                    "FROM films_storage.film " +
                    "WHERE film.premiere LIKE ?";

//    private static final String FIND_FILM_BY_NAME =
//            "SELECT id, name, duration, premiere, age_limit, country_id, description " +
//                    "FROM films_storage.film " +
//                    "WHERE name LIKE ?";

    private static final String SAVE_FILM_GENRE = "INSERT INTO films_storage.genre_film (genre_id, film_id) VALUES (?, ?)";

    public List<Film> findAll() {
        List<Film> films = new ArrayList<>();
        try (Connection connection = ConnectionPool.getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(FIND_ALL);
            while (resultSet.next()) {
                Film film = Film.builder()
                        .id(resultSet.getLong("film_id"))
                        .name(resultSet.getString("film_name"))
                        .premiere(resultSet.getDate("premiere").toLocalDate())
                        .duration(resultSet.getInt("duration"))
                        .ageLimit(resultSet.getInt("age_limit"))
                        .description(resultSet.getString("description"))
                        .country(Country.builder()
                                .id(resultSet.getLong("country_id"))
                                .name(resultSet.getString("country_name"))
                                .build())
                        .build();
                films.add(film);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return films;
    }

    private Film getFilmFromResultSet(ResultSet resultSet) throws SQLException {
        return Film.builder()
                .id(resultSet.getLong("id"))
                .name(resultSet.getString("name"))
                .premiere(resultSet.getDate("premiere").toLocalDate())
                .duration(resultSet.getInt("duration"))
                .ageLimit(resultSet.getInt("age_limit"))
                .description(resultSet.getString("description"))
                .country(Country.builder()
                        .id(resultSet.getLong("id"))
                        .name(resultSet.getString("name"))
                        .build())
                .build();
    }

    public Film save(Film film) {
        try (Connection connection = ConnectionPool.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SAVE, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, film.getName());
            preparedStatement.setInt(2, film.getDuration());
            preparedStatement.setDate(3, Date.valueOf(film.getPremiere()));
            preparedStatement.setInt(4, film.getAgeLimit());
            preparedStatement.setLong(5, film.getCountry().getId());
            preparedStatement.setString(6, film.getDescription());
            preparedStatement.executeUpdate();

            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
            if (generatedKeys.next()) {
                film.setId(generatedKeys.getLong("id"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return film;
    }

    public Optional<Film> findById(Long filmId) {
        Optional<Film> film = Optional.empty();
        try (Connection connection = ConnectionPool.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_ID)) {
            preparedStatement.setLong(1, filmId);

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                film = Optional.of(Film.builder()
                        .id(resultSet.getLong("film_id"))
                        .name(resultSet.getString("film_name"))
                        .premiere(resultSet.getDate("premiere").toLocalDate())
                        .duration(resultSet.getInt("duration"))
                        .ageLimit(resultSet.getInt("age_limit"))
                        .description(resultSet.getString("description"))
                        .country(Country.builder()
                                .id(resultSet.getLong("country_id"))
                                .name(resultSet.getString("country_name"))
                                .build())
                        .build());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return film;
    }

    private static final String FIND_FILM_BY_NAME =
            "SELECT id, name, duration, premiere, age_limit, country_id, description " +
                    "FROM films_storage.film " +
                    "WHERE (? IS NULL OR year = ?) AND (? IS NULL OR name = ?)";

    public List<Film> findFilmByName(String namePart, long year) {//, long year
        ArrayList<Film> filmsList = new ArrayList<>();
        try (Connection connection = ConnectionPool.getConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(FIND_FILM_BY_NAME)) {
                preparedStatement.setObject(1, year + "%", Types.BIGINT);
                preparedStatement.setObject(2, year + "%", Types.BIGINT);
                preparedStatement.setObject(3, "%" + namePart + "%", Types.VARCHAR);
                preparedStatement.setObject(4, "%" + namePart + "%", Types.VARCHAR);
//                preparedStatement.setString(1, "%" + namePart + "%");
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    Film film = getFilmFromResultSet(resultSet);
                    filmsList.add(film);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return filmsList;
    }

    public List<Film> findFilmByYear(long year) {
        ArrayList<Film> filmsList = new ArrayList<>();
        try (Connection connection = ConnectionPool.getConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(FIND_FILM_BY_YEAR_OF_ISSUE)) {
                preparedStatement.setString(1, year + "%");
                ResultSet resultSet = preparedStatement.executeQuery();

                while (resultSet.next()) {
                    Film film = getFilmFromResultSet(resultSet);
                    filmsList.add(film);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return filmsList;
    }


//    public Film getById(Long filmId) {
//        Film film = null;
//        try (Connection connection = ConnectionPool.getConnection();
//             PreparedStatement preparedStatement = connection.prepareStatement(GET_BY_ID)) {
//            preparedStatement.setLong(1, filmId);
//            ResultSet resultSet = preparedStatement.executeQuery();
//
//            film = new Film();
//            while (resultSet.next()) {
//                film.setId(resultSet.getLong("film_id"));
//                film.setName(resultSet.getString("film_name"));
//                film.getUsers().add(User.builder()
//                        .id(resultSet.getLong("user_id"))
//                        .name(resultSet.getString("user_name"))
//                        .build());
//                film.getReviews().add(Review.builder()
//                        .id(resultSet.getLong("review_id"))
//                        .comment(resultSet.getString("comment"))
//                        .stars(resultSet.getInt("stars"))
//                        .build());
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//        return film;
//    }

    public static FilmDao getInstance() {
        return INSTANCE;
    }
}
