package pl.dkaluza.spring_validation;

import jakarta.validation.constraints.NotBlank;

record GreetingRequest(
    @NotBlank
    String name
) {
}
