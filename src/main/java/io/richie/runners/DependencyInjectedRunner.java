package io.richie.runners;

import io.richie.domains.Doctor;
import io.richie.domains.Surgeon;
import io.richie.services.DependencyInjectedHospital;

public class DependencyInjectedRunner implements Runner {

    @Override
    public void run() {

        // Ok, so you could argue that we're breaking
        // the Dependency injection principle here because
        // we're instantiating an object here. But it's currently
        // unavoidable, and in order for a program to run objects
        // have to be instantiated somewhere. The problem occurs
        // when objects are being instantiated all over the system
        // and tracking the dependencies become unwieldy.
        // In our case here, all our dependencies will be managed
        // by this class.
        // In some sense, we can consider this the CONTEXT for our APPLICATION.
        Doctor surgeon = new Surgeon();
        DependencyInjectedHospital hospitalService = new DependencyInjectedHospital(surgeon);

        System.out.println(hospitalService.operateHospital());
    }

}
