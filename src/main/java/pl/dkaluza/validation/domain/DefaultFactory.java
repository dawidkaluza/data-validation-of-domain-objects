package pl.dkaluza.validation.domain;

import java.util.List;

class DefaultFactory<T> extends Factory<T> {
    private final Assembler<T> assembler;
    private final ValidationExecutor validationExecutor;

    DefaultFactory(Assembler<T> assembler, ValidationExecutor validationExecutor) {
        this.assembler = assembler;
        this.validationExecutor = validationExecutor;
    }

    @Override
    protected List<FieldError> validate() {
        return validationExecutor.validate();
    }

    @Override
    protected T assemble() {
        return assembler.assemble();
    }
}
