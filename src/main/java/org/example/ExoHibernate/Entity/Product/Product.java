package org.example.ExoHibernate.Entity.Product;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.example.ExoHibernate.Entity.Order.CustomerOrder;

import javax.persistence.*;
import java.util.List;

@Entity
@SuperBuilder
@NoArgsConstructor
@Data
@Inheritance(strategy = InheritanceType.JOINED)

public abstract class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected int id;
    protected String name;
    protected float price;

    @ManyToMany(mappedBy = "products")
    private List<CustomerOrder> orders;
}
