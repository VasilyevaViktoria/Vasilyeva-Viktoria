package peacock.servlet;

import peacock.dto.CreateNewUserDto;
import peacock.service.UserService;
import peacock.util.JspPathUtil;
import peacock.util.StringUtil;
import peacock.validtor.LoginValidator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/register-new-user")
public class RegistrationUserServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext()
                .getRequestDispatcher(JspPathUtil.get("registration"))
                .forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CreateNewUserDto newUserDto = CreateNewUserDto.builder()
                .name(req.getParameter("loginreg"))
                .login(req.getParameter("email"))
                .password(req.getParameter("passreg"))
                .build();

        if (!req.getParameter("loginreg").equals("") || !req.getParameter("email").equals("") || !req.getParameter("passreg").equals("")){
            UserService.getInstance().save(newUserDto);
        }

        getServletContext()
                .getRequestDispatcher(JspPathUtil.get("login"))
                .forward(req, resp);
    }
}
