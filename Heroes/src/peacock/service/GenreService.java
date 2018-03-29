package peacock.service;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import peacock.dao.GenreDao;
import peacock.entity.Genre;

import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class GenreService {

    private static final GenreService INSTANCE = new GenreService();

    public List<Genre> findAll() {
        return GenreDao.getInstance().findAll();
    }

    public static GenreService getInstance() {
        return INSTANCE;
    }
}
