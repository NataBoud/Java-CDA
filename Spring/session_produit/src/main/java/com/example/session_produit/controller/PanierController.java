package com.example.session_produit.controller;


import com.example.session_produit.model.PanierItem;
import com.example.session_produit.model.Produit;
import com.example.session_produit.service.PanierService;
import com.example.session_produit.service.ProduitService;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/panier")
public class PanierController {

    private final PanierService panierService;
    private final ProduitService produitService;

    public PanierController(PanierService panierService, ProduitService produitService) {
        this.panierService = panierService;
        this.produitService = produitService;
    }

    @PostMapping("/add/{id}")
    public String  ajouterProduit(@PathVariable Long id) {
        Produit produit = produitService.findById(id);
        if (produit != null) {
            panierService.ajouterProduit(produit);
            return "Produit ajouté au panier : " + produit.getNom();
        } else {
            return "Produit introuvable avec id " + id;
        }
    }

    @DeleteMapping("/remove/{id}")
    public void retirerProduit(@PathVariable Long id) {
        panierService.retirerProduit(id);
    }

    @GetMapping
    public Map<Long, PanierItem> afficherPanier() {
        return panierService.afficherPanier();
    }

    @GetMapping("/total")
    public double validerPanier() {
        return panierService.validerPanier();
    }
}
