package pl.dkaluza.validation.domain;

import java.util.List;

public record CreateGalleryCommand(String name, List<String> photos) {
}
