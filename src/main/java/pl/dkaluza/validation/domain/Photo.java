package pl.dkaluza.validation.domain;

import java.util.List;

public class Photo {
    private final String url;

    public Photo(String url) {
        if (url == null || url.isBlank()) {
            throw new ValidationException(List.of(new FieldError("url", "url must not be blank")));
        }

        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Photo photo)) return false;

        return url.equals(photo.url);
    }

    @Override
    public int hashCode() {
        return url.hashCode();
    }

    @Override
    public String toString() {
        return "Photo{" +
               "url='" + url + '\'' +
               '}';
    }
}
