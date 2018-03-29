package peacock.servlet;

import peacock.service.FilmService;
import peacock.service.ParticipantService;
import peacock.util.JspPathUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/add-participant-to-film")
public class AddParticipantToFilmServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("films", FilmService.getInstance().findAll());
        req.setAttribute("participants", ParticipantService.getInstance().findAll());

        getServletContext()
                .getRequestDispatcher(JspPathUtil.get("addParticipantToFilm"))
                .forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(req.getParameterValues("dropdownChoiceParticipant").length != 0 || !req.getParameter("dropdownChoiceFilm").equals("") || !req.getParameter("career").equals("")){
            ParticipantService.getInstance().addParticipantToFilm(
                    req.getParameterValues("dropdownChoiceParticipant"),
                    Long.valueOf(req.getParameter("dropdownChoiceFilm")),
                    req.getParameter("career"));
        }


        getServletContext()
                .getRequestDispatcher(JspPathUtil.get("addParticipantToFilm"))
                .forward(req, resp);
    }
}
