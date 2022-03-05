package io.richie.runners;

import io.richie.configs.ExplicitHospitalConfig;
import io.richie.services.HospitalService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringRunner implements Runner {
    @Override
    public void run() {

        // Spring provides 3 ways to specify configurations:
        // 1. Explicit configuration in XML (Old school)
        // 2. Explicit configuration in Java (Personal favorite)
        // 3. Implicit bean discovery and automatic wiring (Most common)
        //
        // On the line below, we're creating an application context
        // based on what we defined in the ExplicitHospitalConfig file.
        ApplicationContext ctx = new AnnotationConfigApplicationContext(ExplicitHospitalConfig.class);

        // After the application context is created, we can get any configured bean
        // with the getBean method.
        HospitalService hospitalService = ctx.getBean(HospitalService.class);

        System.out.println(hospitalService.operateHospital());
    }
}
