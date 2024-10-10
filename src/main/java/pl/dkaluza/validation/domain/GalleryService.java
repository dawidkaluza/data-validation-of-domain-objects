package pl.dkaluza.validation.domain;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class GalleryService {
    private static final Logger logger = LoggerFactory.getLogger(GalleryService.class);

    public Gallery create(CreateGalleryCommand command) {
        var gallery = new Gallery(
            command.title(),
            command.photos()
                .stream()
                .map(Photo::new)
                .toList()
        );
        logger.info("Creating new gallery: {}", gallery);
        return gallery;
    }
}
