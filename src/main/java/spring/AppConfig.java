package spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public Cheks cheks(IntegerTaskProvider integerTaskProvider) {
        Cheks cheks = new Cheks();
        cheks.setTaskProvider(integerTaskProvider);
        return cheks;
    }

    @Bean
    public IntegerTaskProvider integerTaskProvider() {
        IntegerTaskProvider integerTaskProvider = new IntegerTaskProvider();
        integerTaskProvider.init();
        return integerTaskProvider;
    }

}
