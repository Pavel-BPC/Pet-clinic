package com.blinets.dependency.injection.configuration;

import com.blinets.dependency.injection.repositories.GreetingEnglishRepositoryImpl;
import com.blinets.dependency.injection.repositories.GreetingRepository;
import com.blinets.dependency.injection.services.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

@Configuration
public class GreetingServiceConfiguration {

    @Bean
    @Primary
    PrimaryGreetingService primaryGreetingService(){
        return new PrimaryGreetingService();
    }

    @Profile({"EN", "default"})
    @Bean
    I18nEnglishGreetingService i18nService(GreetingRepository greetingRepository){
        return new I18nEnglishGreetingService(greetingRepository);
    }

    @Bean
    GreetingRepository greetingRepository(){
        return new GreetingEnglishRepositoryImpl();
    }


    @Profile("ES")
    @Bean(name = "i18nService")
    I18NSpanishService i18NSpanishService(){
        return new I18NSpanishService();
    }

    @Bean
    ConstructorGreetingService constructorGreetingService(){
        return new ConstructorGreetingService();
    }

    @Bean
    PropertyInjectedGreetingService propertyInjectedGreetingService(){
        return new PropertyInjectedGreetingService();
    }

    @Bean
    SetterInjectedGreetingService setterInjectedGreetingService(){
        return new SetterInjectedGreetingService();
    }

}
