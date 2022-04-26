package edu.school21.cinema.servlets;

import edu.school21.cinema.models.Image;
import edu.school21.cinema.models.User;
import edu.school21.cinema.services.ImageService;
import edu.school21.cinema.services.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;

@MultipartConfig
@WebServlet("/upload")
public class UploadServlet extends HttpServlet {

    private UserService userService;
    private ImageService imageService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        ServletContext context = getServletContext();
        ApplicationContext springContext = (ApplicationContext) context.getAttribute("springContext");
        this.userService = springContext.getBean(UserService.class);
        this.imageService = springContext.getBean(ImageService.class);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        if (session.getAttribute("user") != null) {
            User user = (User) session.getAttribute("user");
            Image image = imageService.saveImage(req, user.getId());
            if (image == null) {
                resp.sendRedirect("/profile");
                return;
            }
            user.setAvatar(image.getId());
            userService.updateUser(user);
            session.setAttribute("image", image);
        }
        resp.sendRedirect("/profile");
    }

    public void destroy() {
        super.destroy();
    }
}
