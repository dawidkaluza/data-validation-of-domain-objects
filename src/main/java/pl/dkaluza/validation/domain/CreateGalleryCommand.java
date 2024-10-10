package pl.dkaluza.validation.domain;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;

import java.util.List;

public record CreateGalleryCommand(
    @NotBlank
    String title,

    @NotEmpty
    List<@NotBlank String> photos
) {
}
