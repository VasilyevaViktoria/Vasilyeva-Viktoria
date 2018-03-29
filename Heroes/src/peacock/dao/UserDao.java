package peacock.dao;

import peacock.connect.ConnectionPool;
import peacock.entity.Film;
import peacock.entity.User;
import peacock.entity.UserRole;

import javax.jws.soap.SOAPBinding;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserDao {

    private static final UserDao INSTANCE = new UserDao();

    private static final String SAVE_USER = "INSERT INTO films_storage.user (name, login, password, userrole_id) VALUES (?, ?, ?, 2)";

    public User save(User user) {
        try (Connection connection = ConnectionPool.getConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(
                    SAVE_USER, Statement.RETURN_GENERATED_KEYS)) {
                preparedStatement.setString(1, user.getName());
                preparedStatement.setString(2, user.getLogin());
                preparedStatement.setString(3, user.getPassword());
                preparedStatement.executeUpdate();
                ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    user.setId(generatedKeys.getLong("id"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    private static final String GET_ALL_USERS = "SELECT id, name, login, password, role_id FROM films_storage.user";

    public List<User> getAllUsers() {
        List<User> usersList = new ArrayList<>();
        try (Connection connection = ConnectionPool.getConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL_USERS)) {
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    usersList.add(User.builder()
                            .id(resultSet.getLong("id"))
                            .name(resultSet.getString("name"))
                            .login(resultSet.getString("login"))
                            .password(resultSet.getString("password"))
                            .userRole(UserRole.builder()
                                    .id(resultSet.getInt("id"))
                                    .build())
                            .build());
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return usersList;
    }

    private static final String FILM_TO_LIKE = "INSERT INTO films_storage.user_film (user_id, film_id, wish) VALUES (?, ?, ?)";

    public boolean addFilmToLike(long filmId, long userId, boolean wish) {
        try (Connection connection = ConnectionPool.getConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(FILM_TO_LIKE, Statement.RETURN_GENERATED_KEYS)) {
                preparedStatement.setLong(1, userId);
                preparedStatement.setLong(2, filmId);
                preparedStatement.setBoolean(3, wish);
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

    private static String GET_USER_BY_ID = "SELECT id, name, login, password FROM films_storage.user WHERE id = ?";

    public Optional<User> getUserById(Long id) {
        Optional<User> user = Optional.empty();
        try (Connection connection = ConnectionPool.getConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(GET_USER_BY_ID)) {
                preparedStatement.setLong(1, id);
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    user = Optional.of(User.builder()
                            .id(resultSet.getInt("id"))
                            .name(resultSet.getString("name"))
                            .build());
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    private static String GET_USER_BY_NAME = "SELECT id, name, login, password FROM films_storage.user WHERE name = ?";

    public Optional<User> getUserByName(String name) {
        Optional<User> user = Optional.empty();
        try (Connection connection = ConnectionPool.getConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(GET_USER_BY_NAME)) {
                preparedStatement.setString(1, name);
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    user = Optional.of(User.builder()
                            .id(resultSet.getInt("id"))
                            .name(resultSet.getString("name"))
                            .build());
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    private static String GET_USER = "SELECT id, name, login, password FROM films_storage.user WHERE login = ? AND password = ?";

    public Optional<User> getUser(String login, String pass) {
        Optional<User> user = Optional.empty();
        try (Connection connection = ConnectionPool.getConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(GET_USER)) {
                preparedStatement.setString(1, login);
                preparedStatement.setString(2, pass);
                ResultSet resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
                    user = Optional.of(User.builder()
                            .id(resultSet.getInt("id"))
                            .login(resultSet.getString("login"))
                            .userRole(UserRole.builder()
                                    .id(resultSet.getInt("id"))
                                    .build())
                            .build());
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    private static String CHANGE_USER_ROLE = "UPDATE films_storage.user SET userrole_id = ? WHERE id = ?";

    public boolean changeUserRole(long userId, int roleId){
        try(Connection connection = ConnectionPool.getConnection()){
            try(PreparedStatement preparedStatement = connection.prepareStatement(CHANGE_USER_ROLE, Statement.RETURN_GENERATED_KEYS)){
                preparedStatement.setLong(1, roleId);
                preparedStatement.setLong(2, userId);
                preparedStatement.executeUpdate();
                ResultSet resultSet = preparedStatement.getGeneratedKeys();
                if(resultSet.next()){
                    return true;
                }
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }

    private static String GET_ROLE_BY_ID = "SELECT id, name FROM films_storage.userrole WHERE id = ?";

    public String getRoleById(int roleId){
        try(Connection connection = ConnectionPool.getConnection()){
            try(PreparedStatement preparedStatement = connection.prepareStatement(GET_ROLE_BY_ID)){
                preparedStatement.setInt(1, roleId);
                ResultSet resultSet = preparedStatement.executeQuery();
                if(resultSet.next()){
                    return resultSet.getString("name");
                }
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    private static String GET_ROLE_ID_BY_NAME = "SELECT id, name FROM films_storage.userrole WHERE name = ?";

    public long getRoleIdByName(String name){
        try(Connection connection = ConnectionPool.getConnection()){
            try(PreparedStatement preparedStatement = connection.prepareStatement(GET_ROLE_ID_BY_NAME)){
                preparedStatement.setString(1, name);
                ResultSet resultSet = preparedStatement.executeQuery();
                if(resultSet.next()){
                    return resultSet.getLong("id");
                }
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return 0;
    }

    private static String GET_ALL_ROLE= "SELECT id, name FROM films_storage.userrole";

    public Optional<List<String>> getAllRole(){
        try(Connection connection = ConnectionPool.getConnection()){
            try(PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL_ROLE)){
                ResultSet resultSet = preparedStatement.executeQuery();
                List<String> roles = new ArrayList<>();
                while(resultSet.next()){
                    roles.add(resultSet.getString("name"));
                }

                return Optional.of(roles);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return Optional.empty();
    }



//    private static final String GET_USER_BY_ID = "SELECT id, name, login, password FROM films_storage.user WHERE id = ?";
//
//    public Optional<User> getUserById(Long userId) {
//        Optional<User> user = Optional.empty();
//        try (Connection connection = ConnectionPool.getConnection()) {
//            try (PreparedStatement preparedStatement = connection.prepareStatement(GET_USER_BY_ID)) {
//                preparedStatement.setLong(1, userId);
//                ResultSet resultSet = preparedStatement.executeQuery();
//                while (resultSet.next()) {
//                    user = Optional.of(getUserFromResultSet(resultSet));
////                    return Optional.of(new User(resultSet.getLong("id"),
////                            resultSet.getString("name")));
//                }
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return user;
//    }

//    private static final String GET_USER = "SELECT * FROM films_storage.user WHERE login = ? AND password = ?";
//
//    public Optional<User> getUser(String login, String password) {
//        try (Connection connection = ConnectionPool.getConnection()) {
//            try (PreparedStatement preparedStatement = connection.prepareStatement(GET_USER)) {
//                preparedStatement.setString(1, login);
//                preparedStatement.setString(2, password);
//                ResultSet resultSet = preparedStatement.executeQuery();
//                if (resultSet.next()) {
//                    return Optional.of(new User(resultSet.getLong("id"),
//                            resultSet.getString("name"),
//                            resultSet.getString("login")));
////                            getRoleById(resultSet.getLong("role_id"))));
//                }
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return Optional.empty();
//    }

    private static final String CHANGE_ROLE = "UPDATE films_storage.user SET role_id = ? WHERE id = ?";

    public boolean changeUserRole(long userId, long roleId) {
        try (Connection connection = ConnectionPool.getConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(CHANGE_ROLE, Statement.RETURN_GENERATED_KEYS)) {
                preparedStatement.setLong(1, roleId);
                preparedStatement.setLong(2, userId);
                preparedStatement.executeUpdate();
                ResultSet resultSet = preparedStatement.getGeneratedKeys();
                if (resultSet.next()) {
                    return true;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static UserDao getInstance() {
        return INSTANCE;
    }
}
