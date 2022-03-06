package io.richie.runners;

import io.richie.services.HospitalService;
import io.richie.services.TightlyCoupledHospital;

public class TightlyCoupledRunner implements Runner {

    HospitalService hospitalService;

    @Override
    public void run() {
        // Right now, we're using the tightly coupled hospital
        // We can't change the doctor who works there without
        // modifying the class.
        this.hospitalService = new TightlyCoupledHospital();
        System.out.println(this.hospitalService.operateHospital());
    }
}
