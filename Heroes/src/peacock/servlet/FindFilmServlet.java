package peacock.servlet;

import peacock.service.FilmService;
import peacock.util.JspPathUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/findFilm")
public class FindFilmServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("films", FilmService.getInstance().findByName(req.getParameter("namePart")));

        if (req.getParameter("year") != null){
            req.setAttribute("films", FilmService.getInstance().findByYear(Long.valueOf(req.getParameter("year"))));
        }

        getServletContext()
                .getRequestDispatcher(JspPathUtil.get("findFilm"))
                .forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext()
                .getRequestDispatcher(JspPathUtil.get("findFilm"))
                .forward(req, resp);
    }
}
