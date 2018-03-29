package peacock.dao;

import peacock.connect.ConnectionPool;
import peacock.entity.Wish;

import java.sql.*;

public class WishDao {

    private static final WishDao INSTANCE = new WishDao();


    private static final String FILM_TO_LIKE = "INSERT INTO films_storage.user_film (user_id, film_id, wish) VALUES (?, ?, ?)";

    private static final String GET_WISH = "SELECT wish FROM films_storage.user_film WHERE user_id = ? AND film_id = ?";

    public Wish addFilmToLike(Wish wish) {
        try (Connection connection = ConnectionPool.getConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(FILM_TO_LIKE, Statement.RETURN_GENERATED_KEYS)) {
                preparedStatement.setLong(1, wish.getUser().getId());
                preparedStatement.setLong(2, wish.getFilm().getId());
                preparedStatement.setBoolean(3, wish.isWish());
                preparedStatement.executeUpdate();

                ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    wish.setId(generatedKeys.getLong("id"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return wish;
    }

//    public boolean getWish(long filmId, long userId){
//        try(Connection connection = ConnectionPool.getConnection()){
//            try(PreparedStatement preparedStatement = connection.prepareStatement(GET_WISH)){
//                preparedStatement.setLong(1, filmId);
//                preparedStatement.setLong(2, userId);
//
//
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }

    public static WishDao getInstance() {
        return INSTANCE;
    }
}