package pl.dkaluza.validation.domain;

import java.util.ArrayList;
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

    public static Builder builder() {
        return new Builder();
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

    public static class Builder {
        private String title;
        private List<String> photos;

        public Builder() {
            photos = new ArrayList<>();
        }

        public Builder title(String title) {
            this.title = title;
            return this;
        }

        public Builder photo(String photo) {
            photos.add(photo);
            return this;
        }

        public Builder photos(List<String> photos) {
            this.photos.addAll(photos);
            return this;
        }

        public Factory<Gallery> prepare() {
            var galleryValidatingFactory = DefaultFactory.newValidatingFactory(
                ValidationExecutor.of(
                    Validator.of(title != null && !title.isBlank(), "title", "Title must not be blank"),
                    Validator.of(!photos.isEmpty(), "photos", "Photos must not be empty")
                )
            );

            var photoFactories = photos.stream().map(Photo::newFactory).toList();
            var photosListFactory = new FactoriesComposite<>(
                () -> photoFactories.stream().map(Factory::assemble).toList(),
                photoFactories
            );
            return new FactoriesComposite<>(
                () -> new Gallery(
                    title,
                    photosListFactory.assemble()
                ),
                galleryValidatingFactory, photosListFactory
            );
        }
    }
}
