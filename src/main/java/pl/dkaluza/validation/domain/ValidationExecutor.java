package pl.dkaluza.validation.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class ValidationExecutor {
    private final List<Validator> validators;

    private ValidationExecutor(List<Validator> validators) {
        this.validators = validators;
    }

    static ValidationExecutor of(List<Validator> validators) {
        return new ValidationExecutor(validators);
    }

    static ValidationExecutor of(Validator... validators) {
        return new ValidationExecutor(Arrays.asList(validators));
    }

    List<FieldError> validate() {
        var errors = new ArrayList<FieldError>();
        for (Validator validator : validators) {
            var error = validator.validate();
            if (error != null) {
                errors.add(error);
            }
        }

        return errors;
    }
}
