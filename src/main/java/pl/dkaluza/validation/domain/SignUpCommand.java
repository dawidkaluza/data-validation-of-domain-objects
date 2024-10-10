package pl.dkaluza.validation.domain;

import jakarta.validation.constraints.NotBlank;

public record SignUpCommand(
    @NotBlank
    String name
) {
}
