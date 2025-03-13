package org.example.Exo7ListExeptionBilleterie;

import org.example.Exo7ListExeptionBilleterie.evenement.Adresse;
import org.example.Exo7ListExeptionBilleterie.evenement.Billet;
import org.example.Exo7ListExeptionBilleterie.evenement.Evenement;
import org.example.Exo7ListExeptionBilleterie.evenement.TypePlace;
import org.example.Exo7ListExeptionBilleterie.fakeData.FakeData;
import org.example.Exo7ListExeptionBilleterie.fakeData.GestionReservation;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        List<Evenement> listeEvenements = FakeData.getEvenements();

        // Un client fictif
        Adresse adresseClient1 = new Adresse("1 Rue de Paris", "Paris");
        Client client = new Client("Dupont", "Jean", adresseClient1, "0123456789", 30);

        while (true) {
            // Affichage du menu
            System.out.println("--- Menu Client ---");
            System.out.println("1. Afficher les événements");
            System.out.println("2. Réserver un billet");
            System.out.println("3. Afficher mes réservations");
            System.out.println("4. Annuler une réservation");
            System.out.println("5. Quitter");
            System.out.print("Choisir une option: ");

            int choix = scanner.nextInt();
            scanner.nextLine(); // Consommer la nouvelle ligne

            switch (choix) {
                case 1:
                    afficherEvenements(listeEvenements);
                    break;
                case 2:
                    reserverBillet(client, listeEvenements, scanner);
                    break;
                case 3:
                    afficherReservations(client);
                    break;
                case 4:
                    annulerReservation(client, listeEvenements, scanner);
                    break;
                case 5:
                    System.out.println("Au revoir !");
                    return;
                default:
                    System.out.println("Choix invalide, veuillez essayer à nouveau.");
            }
        }
    }

    // Affichage des événements
    private static void afficherEvenements(List<Evenement> listeEvenements) {
        System.out.println("Événements disponibles:");
        for (Evenement evenement : listeEvenements) {
            System.out.println("Événement: " + evenement.getNom() + " - " + evenement.getLieu().getVille());
            System.out.println("Date: " + evenement.getDate() + " à " + evenement.getHeure());
            System.out.println("Billets:");
            for (Billet billet : evenement.getBillets()) {
                System.out.println("  - Billet #" + billet.getNumeroPlace() + " - Client: "
                        + billet.getClient().getNom() + " " + billet.getClient().getPrenom()
                        + " - Type: " + billet.getTypePlace());
            }
            System.out.println();
        }
    }

    // Réserver un billet
    private static void reserverBillet(Client client, List<Evenement> listeEvenements, Scanner scanner) {
        System.out.print("Entrez le nom de l'événement pour réserver un billet: ");
        String nomEvenement = scanner.nextLine();

        Evenement evenement = null;
        for (Evenement e : listeEvenements) {
            if (e.getNom().equalsIgnoreCase(nomEvenement)) {
                evenement = e;
                break;
            }
        }

        if (evenement != null) {
            System.out.println("Événement trouvé: " + evenement.getNom());
            System.out.println("Quel type de place souhaitez-vous ? (Ex: NORMAL, VIP)");
            String typePlace = scanner.nextLine().toUpperCase();

            try {
                TypePlace type = TypePlace.valueOf(typePlace);
                GestionReservation.reserverBillet(client, evenement, type);
            } catch (IllegalArgumentException e) {
                System.out.println("Type de place invalide.");
            }
        } else {
            System.out.println("Événement non trouvé.");
        }
    }

    // Afficher les réservations du client
    private static void afficherReservations(Client client) {
        GestionReservation.afficherReservations(client);
    }

    // Annuler une réservation
    private static void annulerReservation(Client client, List<Evenement> listeEvenements, Scanner scanner) {
        System.out.print("Entrez le nom de l'événement pour annuler une réservation: ");
        String nomEvenement = scanner.nextLine();

        Evenement evenement = null;
        for (Evenement e : listeEvenements) {
            if (e.getNom().equalsIgnoreCase(nomEvenement)) {
                evenement = e;
                break;
            }
        }

        if (evenement != null) {
            GestionReservation.supprimerReservation(client, evenement);
        } else {
            System.out.println("Événement non trouvé.");
        }
    }



}
