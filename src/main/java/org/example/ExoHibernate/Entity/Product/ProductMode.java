package org.example.ExoHibernate.Entity.Product;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@SuperBuilder
@NoArgsConstructor
@Data

public class ProductMode extends  Product {
    private String taille;
    @Enumerated(EnumType.STRING)
    private Category category;
}
