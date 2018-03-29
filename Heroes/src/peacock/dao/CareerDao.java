package peacock.dao;

import peacock.connect.ConnectionPool;
import peacock.entity.Career;
import peacock.entity.Participant;

import java.sql.*;
import java.util.Optional;

public class CareerDao {
    private static final CareerDao INSTANCE = new CareerDao();

    private static final String SAVE = "INSERT INTO films_storage.career(name) VALUES (?)";

    private static final String GET_ID_BY_NAME = "SELECT id, name FROM films_storage.career WHERE name = ?";


    public void save(Career career) {
        try (Connection connection = ConnectionPool.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SAVE, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, career.getName());

            preparedStatement.executeUpdate();

            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
            if (generatedKeys.next()) {
                career.setId(generatedKeys.getInt("id"));//1
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public long addRole(String career){
        try(Connection connection = ConnectionPool.getConnection()){
            try(PreparedStatement preparedStatement = connection.prepareStatement(
                    "INSERT INTO career (name) VALUES (?);", Statement.RETURN_GENERATED_KEYS)){
                preparedStatement.setString(1, career);
                preparedStatement.executeUpdate();
                ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
                while (generatedKeys.next()){
                    return generatedKeys.getInt(1);
                }
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return 0;
    }

    public long getRoleIdByName(String career){
        try(Connection connection = ConnectionPool.getConnection()){
            try(PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT id, name FROM films_storage.career WHERE name = ?")){
                preparedStatement.setString(1, career);
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()){
                    return resultSet.getInt("id");
                }
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return 0;
    }

    public Optional<Career> getCareerById(Integer careerId){
        Optional<Career> career = Optional.empty();
        try(Connection connection = ConnectionPool.getConnection()){
            try(PreparedStatement preparedStatement = connection.prepareStatement(GET_ID_BY_NAME)){
                preparedStatement.setInt(1, careerId);
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()){
                    career = Optional.of(getCareerFromResultSet(resultSet));
                }
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return career;
    }

    public long getCareerIdByName(String name){
        try(Connection connection = ConnectionPool.getConnection()){
            try(PreparedStatement preparedStatement = connection.prepareStatement(GET_ID_BY_NAME)){
                preparedStatement.setString(1, name);
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()){
                    return resultSet.getInt("id");
                }
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return 0;
    }

    private Career getCareerFromResultSet(ResultSet resultSet) throws SQLException {
        return Career.builder()
                .id(resultSet.getInt("career_id"))
                .name(resultSet.getString("career_name"))
                .build();
    }

    public static CareerDao getInstance() {
        return INSTANCE;
    }
}
