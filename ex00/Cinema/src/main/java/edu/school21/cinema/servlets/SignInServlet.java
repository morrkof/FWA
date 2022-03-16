package edu.school21.cinema.servlets;

import edu.school21.cinema.services.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/signIn")
public class SignInServlet extends HttpServlet {

    public SignInServlet() {
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
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("WEB-INF/jsp/signIn.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");

        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        System.out.println(email + "   " + password + "   " + passwordEncoder.encode(password));

        if (userService.authorizeUser(email, password)) {

            // add session and redirect to profile
            req.getRequestDispatcher("/WEB-INF/jsp/profile.jsp").forward(req, resp);
        } else {
            doGet(req, resp);
        }
    }

    public void destroy() {
        super.destroy();
    }
}
