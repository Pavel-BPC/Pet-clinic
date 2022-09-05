package com.blinets.dependency.injection.services;

//@Profile("ES")
//@Service("i18nService")
public class I18NSpanishService implements GreetingService {
    @Override
    public String sayGreeting() {
        return "Hola Mundo - ES";
    }
}