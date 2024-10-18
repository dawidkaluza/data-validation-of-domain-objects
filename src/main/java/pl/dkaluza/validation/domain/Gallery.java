package pl.dkaluza.validation.domain;

import java.util.ArrayList;
import java.util.List;

public class Gallery {
    private final String title;
    private final List<Photo> photos;

    public Gallery(String title, List<Photo> photos) throws ValidationException {
        var errors = new ArrayList<FieldError>();
        if (title == null || title.isBlank()) {
            errors.add(new FieldError("title", "Title must not be blank"));
        }

        if (photos == null || photos.isEmpty()) {
            errors.add(new FieldError("photos", "Photos must not be empty"));
        }

        if (!errors.isEmpty()) {
            throw new ValidationException(errors);
        }

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
