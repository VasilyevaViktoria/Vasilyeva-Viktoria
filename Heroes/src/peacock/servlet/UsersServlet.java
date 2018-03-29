package peacock.servlet;

import peacock.service.UserService;
import peacock.util.JspPathUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/users")
public class UsersServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("users", UserService.getInstance().getAllUser());
        req.setAttribute("roles", UserService.getInstance().getAllRole());
        getServletContext()
                .getRequestDispatcher(JspPathUtil.get("users"))
                .forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(!req.getParameter("dropdownChoiceUser").equals("") || !req.getParameter("dropdownChoiceRole").equals("")){
//            System.out.println(req.getParameter("dropdownChoiceUser") + " " + req.getParameter("dropdownChoiceRole"));
            UserService.getInstance().changeUserRole(Long.valueOf(req.getParameter("dropdownChoiceUser")), req.getParameter("dropdownChoiceRole"));
        }

        getServletContext()
                .getRequestDispatcher(JspPathUtil.get("users"))
                .forward(req, resp);
    }
}
