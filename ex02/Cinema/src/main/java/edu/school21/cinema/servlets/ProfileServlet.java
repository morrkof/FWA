package edu.school21.cinema.servlets;

import edu.school21.cinema.models.User;
import edu.school21.cinema.services.ImageService;
import edu.school21.cinema.services.SessionService;
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

    private SessionService sessionService;
    private ImageService imageService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        ServletContext context = getServletContext();
        ApplicationContext springContext = (ApplicationContext) context.getAttribute("springContext");
        this.sessionService = springContext.getBean(SessionService.class);
        this.imageService = springContext.getBean(ImageService.class);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        HttpSession session = req.getSession();
        if (session.getAttribute("user") != null) {
            User user = (User) session.getAttribute("user");
            req.setAttribute("user", user);
            req.setAttribute("userSessions", sessionService.getAllUserSession(user));
            req.setAttribute("userImages", imageService.getAllUserImages(user));
            session.setAttribute("image", imageService.getImageByUserId(user));
            req.getRequestDispatcher("WEB-INF/jsp/profile.jsp").forward(req, resp);
        }
    }
}
