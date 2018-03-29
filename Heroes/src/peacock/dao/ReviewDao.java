package peacock.dao;

import peacock.connect.ConnectionPool;
import peacock.entity.Film;
import peacock.entity.Review;
import peacock.entity.User;
import peacock.formatter.LocalDateFormat;

import java.sql.*;
import java.sql.Date;
import java.util.*;

public class ReviewDao {

    private static final ReviewDao INSTANCE = new ReviewDao();

    private static final String GET_BY_FILM_ID =
            "SELECT * FROM films_storage.film_rating WHERE film_id = ?";

    private static final String SAVE = "INSERT INTO films_storage.film_rating (user_id, film_id, stars, date, comment) VALUES (?,?,?,SELECT (CURRENT_DATE) ,?)";


    public List<Review> showAllReviews(long idFilm) {
        List<Review> reviewsList = new ArrayList<>();
        try (Connection connection = ConnectionPool.getConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(GET_BY_FILM_ID)) {
                preparedStatement.setLong(1, idFilm);
                ResultSet resultSet = preparedStatement.executeQuery();

                while (resultSet.next()) {
                    Review review = Review.builder()
                            .id(resultSet.getLong("id"))
                            .user(User.builder()
                                    .id(resultSet.getLong("id"))
                                    .build())
                            .film(Film.builder()
                                    .id(resultSet.getLong("id"))
                                    .build())
                            .stars(resultSet.getInt("stars"))
                            .date(LocalDateFormat.format(String.valueOf(resultSet.getDate("date"))))
                            .comment(resultSet.getString("comment"))
                            .build();
                    reviewsList.add(review);
//                    Review review = getReviewFromResultSet(resultSet);
//                    reviewsList.add(review);
                }

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return reviewsList;
    }

    public Set<Review> getByFilmId(Long filmId) {
        Set<Review> reviews = new HashSet<>();
        try (Connection connection = ConnectionPool.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(GET_BY_FILM_ID)) {
            preparedStatement.setLong(1, filmId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                reviews.add(Review.builder()
                        .id(resultSet.getLong("id"))
                        .comment(resultSet.getString("comment"))
                        .stars(resultSet.getInt("stars"))
                        .build());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return reviews;
    }

//    private Review getReviewFromResultSet(ResultSet resultSet) throws SQLException {
//        return Review.builder()
//                .id(resultSet.getLong("id"))
//                .user(User.builder()
//                        .id(resultSet.getLong("user_id"))
////                        .name(resultSet.getString("user_name"))
//                        .build())
//                .film(Film.builder()
//                        .id(resultSet.getLong("film_id"))
//                        .build())
//                .stars(resultSet.getInt("stars"))
//                .date(LocalDateFormat.format(String.valueOf(resultSet.getDate("date"))))
//                .comment(resultSet.getString("comment"))
//                .build();
//    }


    public Review save(Review review) {
        try (Connection connection = ConnectionPool.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SAVE, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setLong(1, review.getUser().getId());
            preparedStatement.setLong(2, review.getFilm().getId());
            preparedStatement.setLong(3, review.getStars());
            preparedStatement.setString(4, review.getComment());

            preparedStatement.executeUpdate();
            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
            if (generatedKeys.next()) {
                review.setId(generatedKeys.getLong("id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return review;
    }

    public static ReviewDao getInstance() {
        return INSTANCE;
    }

}
