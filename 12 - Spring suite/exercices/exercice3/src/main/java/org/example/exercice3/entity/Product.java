package org.example.exercice3.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.exercice3.dto.ProductResponseDto;
import org.springframework.web.bind.annotation.GetMapping;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Product {
    @Id
    @GeneratedValue
    private long id;
    private String name;
    private double price;

    public ProductResponseDto entityToDto (){
        return ProductResponseDto.builder().id(getId()).name(getName()).price(getPrice()).build();
    }
}
