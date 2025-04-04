package org.example.ExoHibernate.Entity.Product;

import javax.persistence.Entity;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@SuperBuilder
@NoArgsConstructor
@Data

public class ProductElectronic extends  Product {
    private int batterieDuration;
}
