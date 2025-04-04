package org.example.ExoHibernate.Entity.Product;

import javax.persistence.Entity;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import java.time.LocalDate;

@Entity
@SuperBuilder
@NoArgsConstructor
@Data

public class ProductFood  extends  Product{
    private LocalDate expiryDate;
}
