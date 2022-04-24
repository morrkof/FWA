package edu.school21.cinema.models;

import java.util.Objects;

public class Image {

    private Long id;
    private Long userId;
    private String originalName;
    private String uniqueName;
    private String filepath;
    private Long size;
    private String mimetype;
    private String normalSize;

    public Image() {
    }

    public String getNormalSize() {
        return normalSize;
    }

    public Image(Long id, Long userId, String originalName, String uniqueName, String filepath, Long size, String mimetype) {
        this.id = id;
        this.userId = userId;
        this.originalName = originalName;
        this.uniqueName = uniqueName;
        this.filepath = filepath;
        this.size = size;
        this.mimetype = mimetype;
        if (size >= 1000000) {
            this.normalSize = size/1000000 + "MB";
        } else if (size >= 1000) {
            this.normalSize = size/1000 + "KB";
        } else {
            this.normalSize = size + "B";
        }
    }

    public Image(Long userId, String originalName, String uniqueName, String filepath, Long size, String mimetype) {
        this.userId = userId;
        this.originalName = originalName;
        this.uniqueName = uniqueName;
        this.filepath = filepath;
        this.size = size;
        this.mimetype = mimetype;
        if (size >= 1048576) {
            this.normalSize = size/1048576f + "MB";
        } else if (size >= 1024) {
            this.normalSize = size/1024f + "KB";
        } else {
            this.normalSize = size + "B";
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getOriginalName() {
        return originalName;
    }

    public void setOriginalName(String originalName) {
        this.originalName = originalName;
    }

    public String getUniqueName() {
        return uniqueName;
    }

    public void setUniqueName(String uniqueName) {
        this.uniqueName = uniqueName;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Image image = (Image) o;
        return Objects.equals(id, image.id) && Objects.equals(userId, image.userId) && Objects.equals(originalName, image.originalName) && Objects.equals(uniqueName, image.uniqueName) && Objects.equals(filepath, image.filepath) && Objects.equals(size, image.size) && Objects.equals(mimetype, image.mimetype);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userId, originalName, uniqueName, filepath, size, mimetype);
    }

    @Override
    public String toString() {
        return "Image{" +
                "id=" + id +
                ", userId=" + userId +
                ", originalName='" + originalName + '\'' +
                ", uniqueName='" + uniqueName + '\'' +
                ", filepath='" + filepath + '\'' +
                ", size=" + size +
                ", mimetype='" + mimetype + '\'' +
                '}';
    }
}
