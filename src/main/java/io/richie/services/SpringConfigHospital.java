package io.richie.services;


import io.richie.domains.Doctor;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * We're going to let Spring handle the instantiation of this hospital
 * and its dependencies via an explicit config file
 *
 * @see io.richie.configs.ExplicitHospitalConfig
 */
public class SpringConfigHospital implements HospitalService {

    private final Doctor doctor;

    // @Autowired is how we tell the Spring framework
    // "Hey, since you're managing the lives of all these objects
    // INJECT the Doctor we're using for our project."
    //
    // Note: Spring offers 3 ways to INJECT dependencies:
    // 1. Constructor based (Best)
    // 2. Setter based (Ok)
    // 3. Field based (Bad practice)
    @Autowired
    public SpringConfigHospital(Doctor doctor) {
        this.doctor = doctor;
    }

    @Override
    public String operateHospital() {
        final String hospitalStatus = this.getClass().getSimpleName() + " is open. ";
        return hospitalStatus + "The " + this.doctor.practice();
    }
}
