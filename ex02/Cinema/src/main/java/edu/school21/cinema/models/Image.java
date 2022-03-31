package edu.school21.cinema.models;

import java.util.Objects;

public class Image {

    private Long id;
    private User userId;
    private String filename;
    private String filepath;
    private Long size;
    private String mimetype;
    private boolean isAvatar;

    public Image() {
    }

    public Image(Long id, User userId, String filename, String filepath, Long size, String mimetype, boolean isAvatar) {
        this.id = id;
        this.userId = userId;
        this.filename = filename;
        this.filepath = filepath;
        this.size = size;
        this.mimetype = mimetype;
        this.isAvatar = isAvatar;
    }

    public Image(User userId, String filename, String filepath, Long size, String mimetype, boolean isAvatar) {
        this.id = null;
        this.userId = userId;
        this.filename = filename;
        this.filepath = filepath;
        this.size = size;
        this.mimetype = mimetype;
        this.isAvatar = isAvatar;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getFilepath() {
        return filepath;
    }

    public void setFilepath(String filepath) {
        this.filepath = filepath;
    }

    public Long getSize() {
        return size;
    }

    public void setSize(Long size) {
        this.size = size;
    }

    public String getMimetype() {
        return mimetype;
    }

    public void setMimetype(String mimetype) {
        this.mimetype = mimetype;
    }

    public boolean isAvatar() {
        return isAvatar;
    }

    public void setAvatar(boolean avatar) {
        isAvatar = avatar;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Image image = (Image) o;
        return isAvatar == image.isAvatar && Objects.equals(id, image.id) && Objects.equals(userId, image.userId) && Objects.equals(filename, image.filename) && Objects.equals(filepath, image.filepath) && Objects.equals(size, image.size) && Objects.equals(mimetype, image.mimetype);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userId, filename, filepath, size, mimetype, isAvatar);
    }

    @Override
    public String toString() {
        return "Image{" +
                "id=" + id +
                ", userId=" + userId +
                ", filename='" + filename + '\'' +
                ", filepath='" + filepath + '\'' +
                ", size=" + size +
                ", mimetype='" + mimetype + '\'' +
                ", isAvatar=" + isAvatar +
                '}';
    }
}
