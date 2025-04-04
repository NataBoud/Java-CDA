package org.example.ExoHibernate;

import org.example.ExoHibernate.Entity.Customer.Customer;
import org.example.ExoHibernate.Entity.Order.CustomerOrder;
import org.example.ExoHibernate.Entity.Order.CustomerOrderStatut;
import org.example.ExoHibernate.Entity.Product.Product;
import org.example.ExoHibernate.repository.CustomerRepository;
import org.example.ExoHibernate.repository.OrderRepository;
import org.example.ExoHibernate.repository.ProductRepository;

import java.time.LocalDate;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ProductRepository productRepository = new ProductRepository();
        OrderRepository orderRepository = new OrderRepository();
        CustomerRepository customerRepository = new CustomerRepository();

        //       ProductMode newProduct2 = ProductMode.builder()
//                .name("T-shirt")
//                .price(59.99f)
//                .taille("M")
//                .category(Category.FEMME)
//                .build();
//
//        productRepository.save(newProduct2);

//        ProductElectronic newProduct3 = ProductElectronic.builder()
//                .name("ecouteurs")
//                .price(59.99f)
//                .batterieDuration(24)
//                .build();
//
//        productRepository.save(newProduct3);

        Customer customer = customerRepository.findById(2);
        if (customer == null) {
            throw new RuntimeException("Client non trouvé !");
        }

        Product product1 = productRepository.findById(1);
        Product product2 = productRepository.findById(52);
        if (product1 == null || product2 == null) {
            throw new RuntimeException("Produits non trouvés !");
        }

        CustomerOrder order = CustomerOrder.builder()
                .date(LocalDate.now())
                .status(CustomerOrderStatut.EN_COURS)
                .customer(customer)
                .build();
        // Ajouter les produits à la commande
        order.setProducts(List.of(product1, product2));

        orderRepository.save(order);

//        Customer customer = Customer.builder()
//                .name("John Test ")
//                .email("john.test@example.com")
//                .build();
//        customerRepository.save(customer);

    }
}
