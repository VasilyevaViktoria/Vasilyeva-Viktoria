package peacock.servlet;

import peacock.dto.ViewBasicUserDto;
import peacock.dto.ViewUserBasicInfoDto;
import peacock.entity.User;
import peacock.service.UserService;
import peacock.util.JspPathUtil;
import peacock.validtor.LoginValidator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext()
                .getRequestDispatcher(JspPathUtil.get("login"))
                .forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Optional<User> optionalUser = UserService.getInstance()
                .getUser(req.getParameter("login"), req.getParameter("password"));

//        List<String> validateResult = LoginValidator.getInstance().validate(new ViewBasicUserDto(req.getParameter("login"), req.getParameter("password")));
//        if (optionalUser.isPresent()) {
//            User user = optionalUser.get();
//            req.getSession().setAttribute("userLoggedIn", true);
//            req.getSession().setAttribute("userRole", optionalUser.get().getUserRole());
//            req.getSession().setAttribute("userName", optionalUser.get().getName());
//            resp.sendRedirect("/index");
//        } else {
//            req.setAttribute("errors", validateResult);
//            getServletContext()
//                    .getRequestDispatcher(JspPathUtil.get("login"))
//                    .forward(req, resp);
//        }
//        if(validateResult.size()!=0){
//            req.setAttribute("errors", validateResult);
//            getServletContext()
//                    .getRequestDispatcher(JspPathUtil.get("login"))
//                    .forward(req, resp);
//        }
//        else if(optionalUser.isPresent()){
//            User user = optionalUser.get();
//        }
//        else{
//            doGet(req,resp);
//            return;
//        }
//
//        req.getSession().setAttribute("userLoggedIn", true);
//        req.getSession().setAttribute("userRole", optionalUser.get().getUserRole());
//        req.getSession().setAttribute("userName", optionalUser.get().getName());
//        resp.sendRedirect("/index");

//        Optional<User> optionalUser = UserService.getInstance().getUser(req.getParameter("login"), req.getParameter("pass"));

        if(optionalUser.isPresent()){
            User user = optionalUser.get();
        } else {
            doGet(req, resp);
            return;
        }

        req.getSession().setAttribute("userLoggedIn", true);
        req.getSession().setAttribute("userRole", optionalUser.get().getUserRole());
        req.getSession().setAttribute("userName", optionalUser.get().getName());
        resp.sendRedirect("/index");
    }
}
