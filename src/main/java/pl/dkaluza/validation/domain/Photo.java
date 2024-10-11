package pl.dkaluza.validation.domain;

public class Photo {
    private final String url;

    private Photo(String url) {
        this.url = url;
    }

    static Factory<Photo> newFactory(String url) {
        return new DefaultFactory<>(
            () -> new Photo(url),
            ValidationExecutor.of(
                Validator.of(url != null && !url.isBlank(), "url", "Url must not be blank")
            )
        );
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
