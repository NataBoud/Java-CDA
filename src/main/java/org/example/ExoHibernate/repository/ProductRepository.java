package org.example.ExoHibernate.repository;

import org.example.ExoHibernate.Entity.Product.Product;

public class ProductRepository extends BaseRepository<Product> {
    public ProductRepository() {
        super(Product.class);
    }
}
