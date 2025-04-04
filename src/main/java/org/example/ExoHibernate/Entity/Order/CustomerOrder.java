package org.example.ExoHibernate.Entity.Order;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.ExoHibernate.Entity.Customer.Customer;
import org.example.ExoHibernate.Entity.Product.Product;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "customer_order")
public class CustomerOrder {
    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private LocalDate date;

    @Enumerated(EnumType.STRING)
    private CustomerOrderStatut status;

    @ManyToMany
    @JoinTable(name = "customerorder_product",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id"))
    private List<Product> products;

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

}
