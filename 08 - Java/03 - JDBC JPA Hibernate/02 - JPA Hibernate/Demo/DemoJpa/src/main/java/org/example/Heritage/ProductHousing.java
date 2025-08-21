package org.example.Heritage;


import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.Entity;

@Entity
@SuperBuilder
@NoArgsConstructor
@Data
public class ProductHousing extends Product{
    private int height;
    private int width;
}
