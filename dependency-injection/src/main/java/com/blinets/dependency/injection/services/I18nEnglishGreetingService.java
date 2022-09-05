package com.blinets.dependency.injection.services;


//@Profile({"EN", "default"})
//@Service("i18nService")
public class I18nEnglishGreetingService implements GreetingService {
    @Override
    public String sayGreeting() {
        return "Hello World - EN";
    }
}

