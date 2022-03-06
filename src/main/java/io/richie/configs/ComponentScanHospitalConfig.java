package io.richie.configs;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

/**
 * This class will use Component scanning via
 * the @ComponentScan annotation. And he @Configuration
 * annotation is how Spring knows that this class
 * can be used to read configs.
 *
 * @see Configuration
 * @see org.springframework.context.annotation.ComponentScan
 */
@Configuration
// You can omit the arguments to the @ComponentScan.
// If you omit it, Spring will scan all classes in
// the same package and subpackages as the @Configuration class.
//
// In our case, we have to specify "io.richie" because this class
// is the "config" package.
//
// Also, we have to tell it to exclude our ExplicitHospitalConfig class
// because the beans we configured inside it would conflict with the
// automatic scanning.
@ComponentScan(
        basePackages = "io.richie",
        excludeFilters = @ComponentScan.Filter(
                // ASSIGNABLE_TYPE filters all classes during the component scan
                // that either extend the class or implement the interface of the specified type
                type = FilterType.ASSIGNABLE_TYPE,
                classes = ExplicitHospitalConfig.class
        )
)
public class ComponentScanHospitalConfig {
}
