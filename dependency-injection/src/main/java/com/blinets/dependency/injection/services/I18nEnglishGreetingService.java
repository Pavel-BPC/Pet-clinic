package com.blinets.dependency.injection.services;


import com.blinets.dependency.injection.repositories.GreetingRepository;

//@Profile({"EN", "default"})
//@Service("i18nService")
public class I18nEnglishGreetingService implements GreetingService {

    private final GreetingRepository greetingRepository;

    public I18nEnglishGreetingService(GreetingRepository greetingRepository) {
        this.greetingRepository = greetingRepository;
    }

    @Override
    public String sayGreeting() {
        return greetingRepository.getGreeting();
    }
}

