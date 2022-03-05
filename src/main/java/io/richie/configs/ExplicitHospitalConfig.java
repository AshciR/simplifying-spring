package io.richie.configs;

import io.richie.domains.Doctor;
import io.richie.domains.PrimaryCareProvider;
import io.richie.domains.Surgeon;
import io.richie.services.HospitalService;
import io.richie.services.SpringHospital;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

/**
 * This class will explicitly config which
 * objects (beans) we want to use for our application.
 * The @Configuration annotation is how Spring knows
 * that this class can be used to read configs.
 *
 * @see Configuration
 */
@Configuration
public class ExplicitHospitalConfig {

    /**
     * The @Bean annotation tells Spring that this
     * method will return an object that should be in
     * the Spring Application Context.
     * <p>
     * By default, the id for the bean will be the
     * name of the method (surgeon in this case).
     *
     * @see Bean
     */
    @Bean
    public Doctor surgeon() {
        return new Surgeon();
    }

    /**
     * By default, Spring expects beans to
     * be Singleton (having only 1 instance) object.
     *
     * Note that this configuration has 2 methods
     * that returns Doctor. Because Spring will
     * inject single Doctor into the application,
     * it will get confused if it sees 2 without being
     * told what to do.
     *
     * By using the @Primary annotation, we're telling
     * Spring, "Hey, use this bean by default, unless
     * I tell you to use another one"
     */
    @Bean
    @Primary
    public Doctor primaryCareProvider() {
        return new PrimaryCareProvider();
    }

    /**
     * We know that our HospitalService requires
     * a Doctor to work. In the other examples
     * we've either manually injected a Doctor,
     * or we've used a tightly-coupled doctor.
     *
     * Because we previously declared a Doctor bean
     * Spring will automatically inject the Doctor
     * for us into the HospitalService
     *
     * @param doctor the configured doctor
     * @return the configured SpringHospital
     */
    @Bean
    public HospitalService springHospital(Doctor doctor) {
        return new SpringHospital(doctor);
    }

}
