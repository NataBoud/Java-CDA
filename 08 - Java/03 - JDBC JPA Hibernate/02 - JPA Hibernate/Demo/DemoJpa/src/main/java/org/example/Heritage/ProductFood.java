package org.example.Heritage;


import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.Entity;
import java.time.LocalDate;

@Entity
@SuperBuilder
@NoArgsConstructor
@Data
public class ProductFood extends Product {
    private LocalDate expiryDate;
}
