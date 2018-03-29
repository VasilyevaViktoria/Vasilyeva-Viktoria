package peacock.service;

import peacock.dao.CountryDao;
import peacock.entity.Country;

import java.util.List;

public class CountryService {

    private static final CountryService INSTANCE = new CountryService();

    public List<Country> findAll() {
        return CountryDao.getInstance().findAll();
    }

    public static CountryService getInstance() {
        return INSTANCE;
    }
}
