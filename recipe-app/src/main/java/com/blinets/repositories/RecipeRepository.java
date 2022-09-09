package com.blinets.repositories;

import com.blinets.domain.Recipe;
import org.springframework.data.repository.CrudRepository;


public interface RecipeRepository extends CrudRepository<Recipe, Long> {
}
