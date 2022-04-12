package edu.school21.cinema.servlets;

import edu.school21.cinema.models.User;
import edu.school21.cinema.services.UserService;
import org.springframework.context.ApplicationContext;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/profile")
public class ProfileServlet extends HttpServlet {

    public ProfileServlet() {
        super();
    }

    private UserService userService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        ServletContext context = getServletContext();
        ApplicationContext springContext = (ApplicationContext) context.getAttribute("springContext");
        this.userService = springContext.getBean(UserService.class);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        HttpSession session = req.getSession();
//        req.setAttribute("user", session.getAttribute("user"));
// test test test 
//        session.setAttribute("user", userHandler.get(((Optional<User>) session.getAttribute("user")).get().getEmail()));
//        User user = ((Optional<User>) session.getAttribute("user")).get();
//        session.setAttribute("authUser", user);

//        if (session.getAttribute("user") != null) {
            req.getRequestDispatcher("/WEB-INF/jsp/profile.jsp").forward(req, resp);
//        } else {
//            req.getRequestDispatcher("WEB-INF/jsp/signIn.jsp").forward(req, resp);
//        }
    }

//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
////        String email = req.getParameter("email");
////        String password = req.getParameter("password");
////
////        User user = userService.authorizeUser(email, password);
////        if (user != null) {
////            HttpSession session = req.getSession();
////            session.setAttribute("user", user);
//            req.getRequestDispatcher("/WEB-INF/jsp/profile.jsp").forward(req, resp);
////        } else {
////            doGet(req, resp);
////        }
//    }

    public void destroy() {
        super.destroy();
    }
}
