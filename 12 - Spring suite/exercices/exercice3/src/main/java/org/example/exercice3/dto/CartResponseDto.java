package org.example.exercice3.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class CartResponseDto {
    private Map<ProductResponseDto,Integer> cart;
    private double totalPrice;
}
