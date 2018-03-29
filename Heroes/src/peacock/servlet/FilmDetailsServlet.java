package peacock.servlet;

import peacock.dto.*;
import peacock.service.FilmService;
import peacock.service.ReviewService;
import peacock.service.UserService;
import peacock.util.JspPathUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/film-details")
public class FilmDetailsServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        if (id != null) {
            ViewFilmFullInfoDto filmFullInfoDto = FilmService.getInstance().findById(Long.valueOf(id));
            req.setAttribute("film", filmFullInfoDto);
            req.setAttribute("reviews", ReviewService.getInstance().showAllReviews(Long.valueOf(id)));
            req.setAttribute("rating", ReviewService.getInstance().getRating(Long.valueOf(id)));
            getServletContext()
                    .getRequestDispatcher(JspPathUtil.get("filmDetails"))
                    .forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String like = req.getParameter("Like!");

        if (like.equals("Like!")) {
            CreateNewWishDto wishDto = CreateNewWishDto.builder()
                    .filmId(Long.valueOf(req.getParameter("id")))
                    .userId(Long.valueOf(req.getParameter("userId")))
                    .wish(true)
                    .build();

            UserService.getInstance().saveLikedFilm(wishDto);
            resp.sendRedirect("ok");
        }


        CreateNewReviewDto newReviewDto = CreateNewReviewDto.builder()
                .comment(req.getParameter("reviewText"))
                .stars(Integer.valueOf(req.getParameter("reviewStars")))
                .userId(Long.valueOf(req.getParameter("userName")))
                .filmId(Long.valueOf(req.getParameter("id")))
                .build();

        ReviewService.getInstance().addReview(newReviewDto);
        resp.sendRedirect(req.getHeader("Referer"));

    }
}
