package edu.school21.cinema.servlets;

import edu.school21.cinema.models.User;
import edu.school21.cinema.services.SessionService;
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

@WebServlet("/signIn")
public class SignInServlet extends HttpServlet {

    private UserService userService;
    private SessionService sessionService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        ServletContext context = getServletContext();
        ApplicationContext springContext = (ApplicationContext) context.getAttribute("springContext");
        this.userService = springContext.getBean(UserService.class);
        this.sessionService = springContext.getBean(SessionService.class);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        if (session.getAttribute("user") != null) {
            resp.sendRedirect("/profile");
        } else {
            req.getRequestDispatcher("WEB-INF/jsp/signIn.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");

        if (email != null && !email.isEmpty() && password != null && !password.isEmpty()) {
            User user = userService.authorizeUser(email, password);
            if (user != null) {
                HttpSession session = req.getSession();
                session.setAttribute("user", user);
                sessionService.saveSession(user, req.getRemoteAddr());
                resp.sendRedirect("/profile");
                return;
            }
        }
        doGet(req, resp);
    }
}
