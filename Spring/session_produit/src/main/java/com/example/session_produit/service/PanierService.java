package com.example.session_produit.service;



import com.example.session_produit.model.PanierItem;
import com.example.session_produit.model.Produit;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class PanierService {

    private final HttpSession session;

    public PanierService(HttpSession session) {
        this.session = session;
    }

    private Map<Long, PanierItem> getPanier() {
        Map<Long, PanierItem> panier = (Map<Long, PanierItem>) session.getAttribute("panier");
        if (panier == null) {
            panier = new HashMap<>();
            session.setAttribute("panier", panier);
        }
        return panier;
    }

    public void ajouterProduit(Produit produit) {
        Map<Long, PanierItem> panier = getPanier();
        PanierItem item = panier.get(produit.getId());
        if (item == null) {
            item = new PanierItem(produit, 1);
        } else {
            item.setQuantite(item.getQuantite() + 1);
        }
        panier.put(produit.getId(), item);
    }

    public void retirerProduit(Long produitId) {
        Map<Long, PanierItem> panier = getPanier();
        panier.remove(produitId);
    }

    public Map<Long, PanierItem> afficherPanier() {
        return getPanier();
    }

    public double validerPanier() {
        Map<Long, PanierItem> panier = getPanier();
        return panier.values().stream()
                .mapToDouble(item -> item.getProduit().getPrix() * item.getQuantite())
                .sum();
    }


}
