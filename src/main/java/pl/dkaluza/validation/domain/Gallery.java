package pl.dkaluza.validation.domain;

import java.util.List;

public class Gallery {
    private final String name;
    private final List<Photo> photos;

    public Gallery(String name, List<Photo> photos) {
        this.name = name;
        this.photos = photos;
    }

    public String getName() {
        return name;
    }

    public List<Photo> getPhotos() {
        return photos;
    }

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Gallery gallery)) return false;

        return name.equals(gallery.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    @Override
    public String toString() {
        return "Gallery{" +
               "photos=" + photos +
               ", name='" + name + '\'' +
               '}';
    }
}
