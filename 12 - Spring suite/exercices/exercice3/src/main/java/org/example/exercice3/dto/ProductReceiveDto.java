package org.example.exercice3.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.exercice3.entity.Product;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ProductReceiveDto {
    private String name;
    private double price;

    public Product dtoToEntity (){
        return Product.builder().name(getName()).price(getPrice()).build();
    }
}
