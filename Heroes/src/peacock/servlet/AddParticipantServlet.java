package peacock.servlet;

import peacock.dto.CreateNewParticipantDto;
import peacock.service.ParticipantService;
import peacock.util.JspPathUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/add-participant")
public class AddParticipantServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext()
                .getRequestDispatcher(JspPathUtil.get("addNewParticipant"))
                .forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CreateNewParticipantDto newParticipantDto = CreateNewParticipantDto.builder()
                .name(req.getParameter("name"))
                .dateOfBirth(req.getParameter("dateOfBirth"))
                .build();

        ParticipantService.getInstance().saveParticipant(newParticipantDto);

        resp.sendRedirect("/add-participant");
    }
}
