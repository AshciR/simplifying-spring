package io.richie.services;

import io.richie.domains.Doctor;
import io.richie.domains.Surgeon;

/**
 * This version of the HospitalService is tightly coupled
 * to its dependencies.
 */
public class TightlyCoupledHospital implements HospitalService {

    // A hospital needs doctors
    private final Doctor doctor;

    public TightlyCoupledHospital() {
        // This hospital can only do surgeries
        // because its doctor is tightly coupled
        // to a Surgeon.
        this.doctor = new Surgeon();
    }

    @Override
    public String run() {
        final String hospitalStatus = this.getClass().getSimpleName() + " is open. ";
        return hospitalStatus + "The " + this.doctor.practice();
    }

}
