package peacock.service;

import peacock.dao.UserDao;
import peacock.dao.WishDao;
import peacock.dto.*;
import peacock.entity.Film;
import peacock.entity.User;
import peacock.entity.Wish;

import java.util.List;
import java.util.Optional;

public class UserService {

    private static final UserService INSTANCE = new UserService();

    public ViewUserBasicInfoDto save(CreateNewUserDto dto) {
        User savedUser = UserDao.getInstance().save(
                User.builder()
                        .name(dto.getName())
                        .login(dto.getLogin())
                        .password(dto.getPassword())
                        .build());

        return new ViewUserBasicInfoDto(savedUser.getId(), savedUser.getName());
    }

    public Optional<User> getUserByName(String name) {
        return UserDao.getInstance().getUserByName(name);
    }

    public List<User> getAllUser() {
        return UserDao.getInstance().getAllUsers();
    }

    public Optional<User> getUserById(Long id) {
        return UserDao.getInstance().getUserById(id);
    }

    public Optional<User> getUser(String login, String pass) {
        return UserDao.getInstance().getUser(login, pass);
    }

    public boolean changeUserRole(long userId, String role) {
        return UserDao.getInstance().changeUserRole(userId, getRoleIdByName(role));
    }

    public long getRoleIdByName(String role) {
        return UserDao.getInstance().getRoleIdByName(role);
    }

    public Optional<List<String>> getAllRole() {
        return UserDao.getInstance().getAllRole();
    }

    public Wish saveLikedFilm(CreateNewWishDto dto) {
        return WishDao.getInstance().addFilmToLike(
                Wish.builder()
                        .film(Film.builder()
                                .id(dto.getFilmId())
                                .build())
                        .user(User.builder()
                                .id(dto.getFilmId())
                                .build())

                        .build()
        );
    }

    public static UserService getInstance() {
        return INSTANCE;
    }
}
