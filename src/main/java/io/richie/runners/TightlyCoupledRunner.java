package io.richie.runners;

import io.richie.services.HospitalService;
import io.richie.services.TightlyCoupledHospital;

public class TightlyCoupledRunner implements Runner {

    HospitalService hospitalService;

    @Override
    public void run() {
        this.hospitalService = new TightlyCoupledHospital();
        System.out.println(this.hospitalService.run());
    }
}
