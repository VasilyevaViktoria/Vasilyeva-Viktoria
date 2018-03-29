package peacock.service;

import peacock.dao.FilmDao;
import peacock.dto.CreateNewFilmDto;
import peacock.dto.ViewFilmBasicInfoDto;
import peacock.dto.ViewFilmBasicInfoPlusYear;
import peacock.dto.ViewFilmFullInfoDto;
import peacock.entity.Country;
import peacock.entity.Film;
import peacock.formatter.LocalDateFormat;

import java.util.List;
import java.util.stream.Collectors;

public class FilmService {

    private static final FilmService INSTANCE = new FilmService();

    public List<ViewFilmBasicInfoDto> findAll() {
        return FilmDao.getInstance().findAll().stream()
                .map(it -> new ViewFilmBasicInfoDto(it.getId(), it.getName(), it.getDescription()))
                .collect(Collectors.toList());
    }

    public ViewFilmFullInfoDto findById(Long filmId) {
        return FilmDao.getInstance().findById(filmId)
                .map(it -> ViewFilmFullInfoDto.builder()
                        .id(it.getId())
                        .name(it.getName())
                        .premiere(LocalDateFormat.format(it.getPremiere()))
                        .duration(it.getDuration())
                        .ageLimit(it.getAgeLimit())
                        .countryName(it.getCountry().getName())
                        .description(it.getDescription())
                        .build())
                .orElse(null);
    }

    public List<ViewFilmBasicInfoDto> findByName(String filmName, Long year) {
        return FilmDao.getInstance().findFilmByName(filmName, year).stream()
                .map(it -> new ViewFilmBasicInfoDto(it.getId(), it.getName(), it.getDescription()))
                .collect(Collectors.toList());
    }

    public List<ViewFilmBasicInfoPlusYear> findByYear(Long filmYear) {
        return FilmDao.getInstance().findFilmByYear(filmYear).stream()
                .map(it -> new ViewFilmBasicInfoPlusYear(it.getId(), it.getName(), LocalDateFormat.format(it.getPremiere())))
                .collect(Collectors.toList());
    }

    public ViewFilmBasicInfoDto save(CreateNewFilmDto dto) {
        Film savedFilm = FilmDao.getInstance().save(
                Film.builder()
                        .name(dto.getName())
                        .duration(dto.getDuration())
                        .premiere(LocalDateFormat.format(dto.getPremiere()))
                        .ageLimit(dto.getAgeLimit())
                        .country(Country.builder()
                                .id(dto.getCountryId())
                                .build())
                        .description(dto.getDescription())
                        .build());

        return new ViewFilmBasicInfoDto(savedFilm.getId(), savedFilm.getName(), savedFilm.getDescription());
    }

    public static FilmService getInstance() {
        return INSTANCE;
    }
}
