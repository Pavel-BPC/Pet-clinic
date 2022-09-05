package com.blinets.dependency.injection.repositories;

public class GreetingEnglishRepositoryImpl implements GreetingRepository {
    @Override
    public String getGreeting() {
        return "Hello World - EN";
    }
}
