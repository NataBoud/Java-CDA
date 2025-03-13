package org.example.Exo7ListExeptionBilleterie.fakeData;


import org.example.Exo7ListExeptionBilleterie.Client;
import org.example.Exo7ListExeptionBilleterie.evenement.Billet;
import org.example.Exo7ListExeptionBilleterie.evenement.Evenement;
import org.example.Exo7ListExeptionBilleterie.evenement.TypePlace;

import java.util.List;

public class GestionReservation {

    // Ajouter une réservation pour un client
    public static void reserverBillet(Client client, Evenement evenement, TypePlace typePlace) {
        // Vérifie s'il y a la place disponible
        if (evenement.getBillets().size() < evenement.getNbPlaces()) {
            int numeroBillet = evenement.getBillets().size() + 1; // Attribution d'un numéro unique de billet
            Billet billet = new Billet(numeroBillet, client, evenement, typePlace);
            evenement.getBillets().add(billet);
            System.out.println("Réservation effectuée pour " + client.getNom() + " " + client.getPrenom() + " à l'événement: " + evenement.getNom());
        } else {
            System.out.println("Aucune place disponible pour l'événement: " + evenement.getNom());
        }
    }

    // Afficher les réservations d'un client
    public static void afficherReservations(Client client) {
        List<Billet> billetsClient = client.getBillets();

        if (billetsClient.isEmpty()) {
            System.out.println("Aucune réservation trouvée pour le client: " + client.getNom());
        } else {
            System.out.println("Réservations de " + client.getNom() + " " + client.getPrenom() + ":");
            for (Billet billet : billetsClient) {
                System.out.println("  - Événement: " + billet.getEvenement().getNom() + " - Type: " + billet.getTypePlace());
            }
        }
    }

    // Supprimer une réservation
    public static void supprimerReservation(Client client, Evenement evenement) {
        // On parcourt les billets du client et on cherche celui à supprimer
        Billet billetASupprimer = null;
        for (Billet billet : evenement.getBillets()) {
            if (billet.getClient().equals(client)) {
                billetASupprimer = billet;
                break;
            }
        }

        // Si le billet a été trouvé, on le supprime
        if (billetASupprimer != null) {
            evenement.getBillets().remove(billetASupprimer);
            client.getBillets().remove(billetASupprimer); // Supprimer le billet de la liste du client
            System.out.println("Réservation annulée pour " + client.getNom() + " " + client.getPrenom() + " à l'événement: " + evenement.getNom());
        } else {
            System.out.println("Aucune réservation à annuler pour ce client à cet événement.");
        }
    }


}
