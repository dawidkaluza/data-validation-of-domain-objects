package pl.dkaluza.validation.adapters;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pl.dkaluza.validation.domain.CreateGalleryCommand;
import pl.dkaluza.validation.domain.GalleryService;

@RestController
class GalleryController {
    private final GalleryService galleryService;

    public GalleryController(GalleryService galleryService) {
        this.galleryService = galleryService;
    }

    @PostMapping("/gallery")
    ResponseEntity<?> create(@RequestBody CreateGalleryCommand command) {
        galleryService.create(command);
        return ResponseEntity.ok().build();
    }
}
