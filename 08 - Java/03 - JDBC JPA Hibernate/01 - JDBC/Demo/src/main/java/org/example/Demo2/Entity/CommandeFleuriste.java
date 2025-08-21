package org.example.Demo2.Entity;

import lombok.Builder;
import lombok.Data;
import org.example.Demo2.Entity.Commande;

@Data
@Builder
public class CommandeFleuriste {
    private int id;
    private Commande commande;
    private Fleuriste fleuriste;
}
