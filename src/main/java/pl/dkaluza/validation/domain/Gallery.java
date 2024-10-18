package pl.dkaluza.validation.domain;

import java.util.List;

public class Gallery {
    private final String title;
    private final List<Photo> photos;

    public Gallery(String title, List<Photo> photos) {
        this.title = title;
        this.photos = photos;
    }

    public String getTitle() {
        return title;
    }

    public List<Photo> getPhotos() {
        return photos;
    }

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Gallery gallery)) return false;

        return title.equals(gallery.title);
    }

    @Override
    public int hashCode() {
        return title.hashCode();
    }

    @Override
    public String toString() {
        return "Gallery{" +
               "photos=" + photos +
               ", title='" + title + '\'' +
               '}';
    }
}
