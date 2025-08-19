package com.example.cinematheque.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RealisateurResponseDto {
    private Long id;
    private String nom;
    private String dateNaissanceStr;
    private String nationalite;
}
