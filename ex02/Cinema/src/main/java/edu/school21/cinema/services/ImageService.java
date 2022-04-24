package edu.school21.cinema.services;

import edu.school21.cinema.models.Image;
import edu.school21.cinema.models.User;
import edu.school21.cinema.repositories.ImageRepository;
import edu.school21.cinema.repositories.ImageRepositoryImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class ImageService {

    private final ImageRepository imageRepository;

    public ImageService(ImageRepository imageRepository) {
        this.imageRepository = imageRepository;
    }

    public List<Image> getAllUserImages(User user) {
        return imageRepository.findAllByUserid(user.getId());
    }

    public int saveImage(Image image) {
        return imageRepository.saveAndReturn(image);
    }

    public Image saveImage(HttpServletRequest req, Long userid) throws ServletException, IOException {
        Path pathProject = Files.createDirectories(Paths.get("src/main/webapp/images/" + userid));
        Path pathContainer = Files.createDirectories(Paths.get("target/cargo/configurations/tomcat9x/webapps/images/" + userid));
        Part filePart = req.getPart("file");

        String fileName = filePart.getSubmittedFileName();
        String type = filePart.getContentType();
        long size = filePart.getSize();
        String uniqueName = UUID.randomUUID() + "_" + fileName;
        if (type.equals("image/png") || type.equals("image/jpeg")) {
            for (Part part : req.getParts()) {
                part.write(pathContainer.toAbsolutePath() + "/" + uniqueName);
            }
            Path copied = Paths.get(pathProject.toAbsolutePath() + "/" + uniqueName);
            Path originalPath = Paths.get(pathContainer.toAbsolutePath() + "/" + uniqueName);
            Files.copy(originalPath, copied, StandardCopyOption.REPLACE_EXISTING);

            Image image = new Image(userid, fileName, uniqueName, pathContainer.toAbsolutePath() + "/" + uniqueName, size, type);
            int id = saveImage(image);
            image.setId((long)id);
            return image;
        }
        return null;
    }

    public Image getImageByUserId(User user) {
         Optional<Image> optionalImage = imageRepository.findById(user.getAvatar());
         if (!optionalImage.isPresent()) {
             return null;
         }
         return optionalImage.get();
    }
}
