package peacock.servlet;

import peacock.dto.ViewFilmBasicInfoDto;
import peacock.service.FilmService;
import peacock.util.JspPathUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/films")
public class ListFilmsServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<ViewFilmBasicInfoDto> films = FilmService.getInstance().findAll();
        req.setAttribute("films", films);
        getServletContext()
                .getRequestDispatcher(JspPathUtil.get("films"))
                .forward(req, resp);
    }
}