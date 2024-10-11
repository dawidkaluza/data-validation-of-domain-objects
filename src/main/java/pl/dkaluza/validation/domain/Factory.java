package pl.dkaluza.validation.domain;

import java.util.Collections;
import java.util.List;

public abstract class Factory<T> {
    private List<FieldError> errors;
    private boolean isReviewed;

    public Factory() {
        errors = Collections.emptyList();
        isReviewed = false;
    }

    protected abstract List<FieldError> validate();

    protected abstract T assemble();

    public List<FieldError> review() {
        if (isReviewed) {
            return errors;
        }

        this.errors = validate();
        isReviewed = true;
        return Collections.unmodifiableList(errors);
    }

    public T produce() throws ValidationException {
        if (!isReviewed) {
            review();
        }

        if (!errors.isEmpty()) {
            throw new ValidationException(errors);
        }

        return assemble();
    }
}
