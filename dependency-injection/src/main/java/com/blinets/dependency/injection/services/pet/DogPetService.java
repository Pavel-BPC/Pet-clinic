package com.blinets.dependency.injection.services.pet;

public class DogPetService implements PetService {
    public String getPetType() {
        return "Dogs are the best!";
    }
}