package io.richie.services;

import io.richie.domains.Doctor;

/**
 * This version of the HospitalService is loosely couple
 * because of Dependency Injection.
 */
public class DependencyInjectedHospital implements HospitalService {

    // A hospital needs doctors
    private final Doctor doctor;

    // Note that the difference between this constructor
    // and the one in the TightlyCoupledHospital class
    // is that Doctor DEPENDENCY is INJECTED into the class.
    // This allows the class not to care about managing
    // the lifecycle of the doctor. It's just becomes responsible
    // for using it.
    public DependencyInjectedHospital(Doctor doctor) {
        this.doctor = doctor;
    }

    @Override
    public String operateHospital() {
        final String hospitalStatus = this.getClass().getSimpleName() + " is open. ";
        return hospitalStatus + "The " + this.doctor.practice();
    }
}
