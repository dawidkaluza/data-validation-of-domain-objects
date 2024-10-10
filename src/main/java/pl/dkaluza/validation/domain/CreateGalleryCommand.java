package pl.dkaluza.validation.domain;

import java.util.List;

public record CreateGalleryCommand(String title, List<String> photos) {
}
