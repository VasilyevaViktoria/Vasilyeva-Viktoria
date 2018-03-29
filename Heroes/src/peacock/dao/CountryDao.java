package peacock.dao;

import peacock.connect.ConnectionPool;
import peacock.entity.Country;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CountryDao {

    private static final CountryDao INSTANCE = new CountryDao();

    private static final String SAVE = "INSERT INTO films_storage.country(name, population, count_cinemas)" +
            " VALUES (?, ?, ?);";

    public long save(Country country) {
        try (Connection connection = ConnectionPool.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SAVE, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, country.getName());
            preparedStatement.setInt(2, country.getPopulation());
            preparedStatement.setInt(3, country.getCountOfCinemas());

            preparedStatement.executeUpdate();

            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
            if (generatedKeys.next()) {
                return generatedKeys.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    private static final String GET_COUNTRY_BY_ID = "SELECT id, name FROM films_storage.country WHERE name = ?";

    public long getCountryIdByName(String countryName) {
        try {
            Connection connection = ConnectionPool.getConnection();
            PreparedStatement genreStatement = connection.prepareStatement(GET_COUNTRY_BY_ID, Statement.RETURN_GENERATED_KEYS);
            genreStatement.setString(1, countryName);
            ResultSet resultSet = genreStatement.executeQuery();

            if (resultSet.next()) {
                return resultSet.getInt("id");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    private static final String FIND_ALL = "SELECT id, name " +
            "FROM films_storage.country";

    public List<Country> findAll() {
        List<Country> countries = new ArrayList<>();
        try (Connection connection = ConnectionPool.getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(FIND_ALL);
            while (resultSet.next()) {
                Country country = Country.builder()
                        .id(resultSet.getLong("id"))
                        .name(resultSet.getString("name"))
//                        .population(resultSet.getInt("population"))
//                        .countOfCinemas(resultSet.getInt("count_cinemas"))
                        .build();
                countries.add(country);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return countries;
    }

    public static CountryDao getInstance() {
        return INSTANCE;
    }
}
