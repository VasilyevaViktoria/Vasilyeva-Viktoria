package peacock.servlet;

import peacock.service.FilmService;
import peacock.util.JspPathUtil;
import sun.security.krb5.internal.ccache.FileCredentialsCache;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/index")
public class IndexServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("films", FilmService.getInstance().findAll());
//        if(req.getSession().getAttribute("userRole").equals("admin")){
//            req.setAttribute("role", 1);
//        }
        getServletContext()
                .getRequestDispatcher(JspPathUtil.get("index"))
                .forward(req, resp);
    }
}
