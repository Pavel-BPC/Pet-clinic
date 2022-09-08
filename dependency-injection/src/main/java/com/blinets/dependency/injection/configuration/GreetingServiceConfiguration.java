package com.blinets.dependency.injection.configuration;

import com.blinets.dependency.injection.datasource.FakeDataSource;
import com.blinets.dependency.injection.repositories.GreetingEnglishRepositoryImpl;
import com.blinets.dependency.injection.repositories.GreetingRepository;
import com.blinets.dependency.injection.services.greeting.*;
import com.blinets.dependency.injection.services.pet.PetService;
import com.blinets.dependency.injection.services.pet.PetServiceFactory;
import org.springframework.context.annotation.*;

@Configuration
@ImportResource("classpath:bean-config.xml")
//@PropertySource("classpath:datasource.properties")
public class GreetingServiceConfiguration {


    //    @Bean
//    FakeDataSource fakeDataSource(@Value("${blinets.username}") String username,
//                                  @Value("${blinets.password}") String password,
//                                  @Value("${blinets.jdbcurl}") String jdbcurl) {
//
    @Bean
    FakeDataSource fakeDataSource(PropertiesBindingConfiguration propertiesBindingConfiguration) {
        FakeDataSource fakeDataSource = new FakeDataSource();
        fakeDataSource.setUsername(propertiesBindingConfiguration.getUsername());
        fakeDataSource.setPassword(propertiesBindingConfiguration.getPassword());
        fakeDataSource.setJdbcUrl(propertiesBindingConfiguration.getJdbcUrl());
        return fakeDataSource;
    }

    @Bean
    PetServiceFactory petServiceFactory() {
        return new PetServiceFactory();
    }


    @Bean
    @Profile({"dog", "default"})
    PetService dogPetService(PetServiceFactory petServiceFactory) {
        return petServiceFactory.getPetService("dog");
    }

    @Bean
    @Profile("cat")
    PetService catPetService(PetServiceFactory petServiceFactory) {
        return petServiceFactory.getPetService("cat");
    }

    @Bean
    @Primary
    PrimaryGreetingService primaryGreetingService() {
        return new PrimaryGreetingService();
    }

    @Profile({"EN", "default"})
    @Bean
    I18nEnglishGreetingService i18nService(GreetingRepository greetingRepository) {
        return new I18nEnglishGreetingService(greetingRepository);
    }

    @Bean
    GreetingRepository greetingRepository() {
        return new GreetingEnglishRepositoryImpl();
    }


    @Profile("ES")
    @Bean(name = "i18nService")
    I18NSpanishService i18NSpanishService() {
        return new I18NSpanishService();
    }

//    @Bean
//    ConstructorGreetingService constructorGreetingService() {
//        return new ConstructorGreetingService();
//    }

    @Bean
    PropertyInjectedGreetingService propertyInjectedGreetingService() {
        return new PropertyInjectedGreetingService();
    }

    @Bean
    SetterInjectedGreetingService setterInjectedGreetingService() {
        return new SetterInjectedGreetingService();
    }

}
