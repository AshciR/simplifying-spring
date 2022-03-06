package io.richie.services;

import io.richie.domains.Doctor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * We're going to let Spring handle the instantiation of this hospital
 * and its dependencies using implicit bean discovering
 * via Component scanning.
 * <p>
 * The @Component annotation tell Springs, "Hey, if you're doing
 * automatic Component scanning, include me please."
 */
@Component
public class SpringComponentHospital implements HospitalService {

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
    public SpringComponentHospital(Doctor doctor) {
        this.doctor = doctor;
    }

    @Override
    public String operateHospital() {
        final String hospitalStatus = this.getClass().getSimpleName() + " is open. ";
        return hospitalStatus + "The " + this.doctor.practice();
    }
}
