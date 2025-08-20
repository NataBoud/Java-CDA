package com.example.session_produit.service;

import com.example.session_produit.model.Produit;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProduitService {

    private Map<Long, Produit> produits = new HashMap<>();

    public ProduitService() {
        produits.put(1L, new Produit(1L, "produit1", 900.0));
        produits.put(2L, new Produit(2L, "produit2", 500.0));
        produits.put(3L, new Produit(3L, "produit3", 50.0));
    }

    public List<Produit> findAll() {
        return new ArrayList<>(produits.values());
    }

    public Produit findById(Long id) {
        return produits.get(id);
    }

}
