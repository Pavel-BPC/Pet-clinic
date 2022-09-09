package com.blinets.repositories;

import com.blinets.domain.UnitOfMeasure;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.DirtiesContext;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
class UnitOfMeasureRepositoryTest {

    @Autowired
    UnitOfMeasureRepository unitOfMeasureRepository;

    @BeforeEach
    void setUp() {
    }

    @Test
    @DirtiesContext
    void findByDescription() {

        Optional<UnitOfMeasure> teaspoon = unitOfMeasureRepository.findByDescription("Teaspoon");
        assertEquals("Teaspoon",  teaspoon.get().getDescription());
    }

    @Test
    void findByDescriptionPinch() {

        Optional<UnitOfMeasure> teaspoon = unitOfMeasureRepository.findByDescription("Pinch");
        assertEquals("Pinch",  teaspoon.get().getDescription());
    }
}