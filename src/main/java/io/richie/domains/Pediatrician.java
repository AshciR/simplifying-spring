package io.richie.domains;

import org.springframework.stereotype.Component;

@Component
public class Pediatrician implements Doctor {
    @Override
    public String practice() {
        return this.getClass().getSimpleName() + " is giving candy to a child";
    }
}
