package edu.school21.cinema.servlets;

import edu.school21.cinema.models.User;
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

@MultipartConfig
@WebServlet("/upload")
public class UploadServlet extends HttpServlet {

    private UserService userService;
    // not user, imageService

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        ServletContext context = getServletContext();
        ApplicationContext springContext = (ApplicationContext) context.getAttribute("springContext");
        this.userService = springContext.getBean(UserService.class);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        if (session.getAttribute("user") != null) {
            User user = (User) session.getAttribute("user");
            Path path = Files.createDirectories(Paths.get("src/main/webapp/images/" + user.getId()));
            String absolute = path.toAbsolutePath().toString();
            Part filePart = req.getPart("file");
            String fileName = filePart.getSubmittedFileName();
            String type = filePart.getContentType();
            long size = filePart.getSize();
            System.out.println(fileName + "   " + type + "  " + size + "  " + absolute);
            for (Part part : req.getParts()) { //TODO fileID
                part.write(absolute + "/" + fileName);
            }
        }

        resp.getWriter().print("The file uploaded successfully.");
    }

    public void destroy() {
        super.destroy();
    }
}
