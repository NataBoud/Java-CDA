package org.example.Demo2.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Commande {
    private int id;
    private float prix;
    private int quantite;
    private Plante plante;
}
