package pl.dkaluza.validation.domain;

public interface Validator {
    FieldError validate();

    static Validator of(boolean condition, String name, String description) {
        return () -> condition ? null : new FieldError(name, description);
    }
}