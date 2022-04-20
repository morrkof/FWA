package edu.school21.cinema.servlets;

import edu.school21.cinema.services.UserService;
import org.springframework.context.ApplicationContext;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/images")
public class ImagesServlet extends HttpServlet {
    private UserService userService;
    // + imageService for select and put into user

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        ServletContext context = getServletContext();
        ApplicationContext springContext = (ApplicationContext) context.getAttribute("springContext");
        this.userService = springContext.getBean(UserService.class);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // make image main avatar
    }

    public void destroy() {
        super.destroy();
    }
}
