package peacock.service;

import peacock.dao.ReviewDao;
import peacock.dto.CreateNewReviewDto;
import peacock.dto.ViewReviewBasicInfoDto;
import peacock.dto.ViewReviewFullInfoDto;
import peacock.entity.Film;
import peacock.entity.Review;
import peacock.entity.User;
import java.util.List;
import java.util.stream.Collectors;

public class ReviewService {

    private static final ReviewService INSTANCE = new ReviewService();

    public List<Review> showAllReviews(Long idFilm) {
        return ReviewDao.getInstance().showAllReviews(idFilm);
    }

    public ViewReviewBasicInfoDto addReview(CreateNewReviewDto dto) {
        Review review = ReviewDao.getInstance().save(
                Review.builder()
                        .comment(String.valueOf(dto.getComment()))
                        .stars(dto.getStars())
                        .user(User.builder()
                                .id(dto.getUserId())
                                .build())
                        .film(Film.builder()
                                .id(dto.getFilmId())
                        .build())
                .build());

        return new ViewReviewBasicInfoDto(review.getComment(), review.getStars(),review.getUser().getName(),review.getFilm().getName());
    }

    public long getRating(long idFilm) {
        long raiting = 0;
        List<Review> reviews = showAllReviews(idFilm);

        if (!reviews.isEmpty()) {
            for (Review review : reviews) {
                raiting += review.getStars();
            }

            raiting = raiting / reviews.size();
        }

        return raiting;
    }

    public static ReviewService getInstance() {
        return INSTANCE;
    }
}
