package org.example.ExoDAO.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class Recipe {
    private int id;
    private String name;
    private int prepTime;
    private int cookTime;
    private String difficulty;
    private List<Ingredient> ingredients;
    private Categorie category;
}
