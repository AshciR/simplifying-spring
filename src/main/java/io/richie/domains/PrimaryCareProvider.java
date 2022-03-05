package io.richie.domains;

public class PrimaryCareProvider implements Doctor {
    @Override
    public String practice() {
        return this.getClass().getSimpleName() + " is doing a checkup";
    }
}
