package org.example.ExoDAO.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RecipeIngredient {
    private int id;
    private Ingredient ingredient;
    private Recipe recipe;

}
