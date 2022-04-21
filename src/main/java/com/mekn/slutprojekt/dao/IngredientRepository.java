package com.mekn.slutprojekt.dao;

import com.mekn.slutprojekt.model.Ingredient;
import org.springframework.data.repository.CrudRepository;

public interface IngredientRepository extends CrudRepository<Ingredient, Integer> {

}
