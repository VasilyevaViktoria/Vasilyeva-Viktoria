package peacock.servlet;

import peacock.dto.CreateNewFilmDto;
import peacock.service.CountryService;
import peacock.service.FilmService;
import peacock.util.JspPathUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/add-new-film")
public class AddFilmServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("countries", CountryService.getInstance().findAll());
        getServletContext()
                .getRequestDispatcher(JspPathUtil.get("addNewFilm"))
                .forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CreateNewFilmDto filmDto = CreateNewFilmDto.builder()
                .name(req.getParameter("name"))
                .duration(Integer.valueOf(req.getParameter("duration")))
                .premiere(req.getParameter("releaseDate"))
                .ageLimit(Integer.valueOf(req.getParameter("ageLimit")))
                .countryId(Long.valueOf(req.getParameter("country")))
                .description(req.getParameter("description"))
                .build();

        FilmService.getInstance().save(filmDto);

        resp.sendRedirect("/add-new-film");
    }
}
