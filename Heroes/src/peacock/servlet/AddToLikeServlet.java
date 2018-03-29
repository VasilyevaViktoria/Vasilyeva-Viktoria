//package peacock.servlet;
//
//import peacock.dto.ViewFilmFullInfoDto;
//import peacock.dto.WishFilmDto;
//import peacock.service.FilmService;
//import peacock.service.ParticipantService;
//import peacock.service.UserService;
//import peacock.util.JspPathUtil;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
//@WebServlet("/add-to-like")
//public class AddToLikeServlet extends HttpServlet {
//
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        getServletContext()
//                .getRequestDispatcher(JspPathUtil.get("filmDetails"))
//                .forward(req, resp);
//    }
//
//
//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String like = req.getParameter("like");
//        if(like.equals("like")){
//            WishFilmDto wishFilmDto = WishFilmDto.builder()
//                    .filmId(1L)
//                    .userId(1L)
//                    .wish(Boolean.TRUE)
//                    .build();
//
//            UserService.getInstance().saveLikedFilm(wishFilmDto);
//
//            resp.sendRedirect("/add-new-film");
//        }
//    }
//}
