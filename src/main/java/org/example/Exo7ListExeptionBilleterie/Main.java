package org.example.Exo7ListExeptionBilleterie;

import org.example.Exo7ListExeptionBilleterie.evenement.*;
import org.example.Exo7ListExeptionBilleterie.fakeData.FakeData;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static List<Evenement> listeEvenements = FakeData.getEvenements();
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);


        // Un client fictif
        Adresse adresseClient1 = new Adresse("1 Rue de Paris", "Paris");
        Client client = new Client("Dupont", "Jean", adresseClient1, "0123456789", 30);

        while (true) {
            System.out.println("=== MENU PRINCIPAL ===");
            System.out.println("1. Vous êtes admin");
            System.out.println("2. Vous êtes client");
            System.out.println("3. Quitter");
            System.out.print("Choisissez une option : ");

            int choixPrincipal = scanner.nextInt();
            scanner.nextLine();

            switch (choixPrincipal) {
                case 1:
                    menuAdmin(scanner);
                    break;
                case 2:
                    menuClient(scanner, client);
                    break;
                default:
                    System.out.println("Choix invalide, veuillez essayer à nouveau.");
            }
        }
    }

    // ===================== MENU ADMIN =====================
    private static void menuAdmin(Scanner scanner) {
        while (true) {
            System.out.println("------------------------ Menu Admin ------------------------");
            System.out.println("1. Afficher tous les événements");
            System.out.println("2. Créer un nouvel événement");
            System.out.println("3. Supprimer un événement");
            System.out.println("4. Afficher toutes les réservations");
            System.out.println("5. Retour au menu principal");
            System.out.print("Choisissez une option : ");

            int choixAdmin = scanner.nextInt();
            scanner.nextLine(); // Consommer la nouvelle ligne

            switch (choixAdmin) {
                case 1:
                    afficherEvenements(listeEvenements);
                    break;
                case 2:
                    creerNouvelEvenement(scanner);
                    break;
//                case 3:
//                    supprimerEvenement(scanner, listeEvenements);
//                    break;
//                case 4:
//                    afficherToutesReservations(listeEvenements);
//                    break;
                case 5:
                    return;
                default:
                    System.out.println("Choix invalide, veuillez essayer à nouveau.");
            }
        }
    }


    // ===================== METHODES ADMIN =====================
    // Affichage des événements
    private static void afficherEvenements(List<Evenement> listeEvenements) {
        System.out.println("===================== Événements disponibles =====================");
        for (Evenement evenement : listeEvenements) {
            System.out.println(evenement.getNom() + " - " + evenement.getLieu().getVille());
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

    private static void creerNouvelEvenement(Scanner scanner) {
//        System.out.println("--------------- Création d'un Nouvel Événement ---------------");
//
//        System.out.print("Nom de l'événement : ");
//        String nom = scanner.nextLine();
//
//        // Demander le lieu
//        System.out.println("Choisissez le lieu de l'événement : ");
//        System.out.println("1. Stade");
//        System.out.println("2. Concert Hall");
//        System.out.println("3. Théâtre");
//        System.out.print("Choisir un lieu (1-3) : ");
//        int choixLieu = scanner.nextInt();
//        scanner.nextLine(); //
//        Lieu lieu = null;
//
//        // Associer un lieu à l'événement selon le choix de l'admin
//        switch (choixLieu) {
//            case 1:
//                lieu = new Lieu("25 Rue du Stade", "Paris", 50000);
//                break;
//            case 2:
//                lieu = new Lieu("12 Rue du Stade", "Paris", 20000);
//                break;
//            case 3:
//                lieu = new Lieu("Lieu par défaut", "Adresse par défaut", 1000);
//                break;
//            default:
//                System.out.println("Choix invalide");
//                break;
//        }
//        // la date de l'événement
//        System.out.print("Date de l'événement : ");
//        String dateStr = scanner.nextLine();
//        LocalDate date = LocalDate.parse(dateStr);
//
//        // l'heure de l'événement
//        System.out.print("Heure de l'événement : ");
//        String heure = scanner.nextLine();
//
//        // Demander le nombre de places disponibles
//        System.out.print("Nombre de places disponibles : ");
//        int nbPlaces = scanner.nextInt();
//        scanner.nextLine();

//        Evenement nouvelEvenement = new Evenement(nom, lieu, date, heure, nbPlaces );
        Evenement nouvelEvenement = new Evenement();
        listeEvenements.add(nouvelEvenement);

        System.out.println("Événement créé avec succès !");
    }


    // ===================== MENU CLIENT =====================
    private static void menuClient(Scanner scanner, Client client) {
        while (true) {
            System.out.println("------------------------ Menu Client ------------------------");
            System.out.println("1. Afficher les événements");
            System.out.println("2. Réserver un billet");
            System.out.println("3. Afficher mes réservations");
            System.out.println("4. Annuler une réservation");
            System.out.println("5. Retour au menu principal");
            System.out.print("Choisir une option : ");

            int choixClient = scanner.nextInt();
            scanner.nextLine(); // Consommer la nouvelle ligne

            switch (choixClient) {
                case 1:
                    afficherEvenementsAvecPlacesDispo(listeEvenements);
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
                    return;
                default:
                    System.out.println("Choix invalide, veuillez essayer à nouveau.");
            }
        }
    }


    // ===================== METHODES CLIENT =====================
    public static void afficherEvenementsAvecPlacesDispo(List<Evenement> listeEvenements) {
        System.out.println("===================== Liste des événements =====================");
        for (Evenement evenement : listeEvenements) {
            // Calculer les places disponibles
            int placesDispo = evenement.getNbPlaces() - evenement.getBillets().size();

            System.out.println("Événement : " + evenement.getNom());
            System.out.println("Lieu : " + evenement.getLieu());
            System.out.println("Date : " + evenement.getDate());
            System.out.println("Heure : " + evenement.getHeure());
            System.out.println("Places disponibles : " + placesDispo);
            System.out.println("------------------------------------");
        }
    }

    // Récupérer les types de places disponibles pour un événement
    private static List<TypePlace> getTypesDisponibles(Evenement evenement) {
        List<Billet> billets = evenement.getBillets();

        List<TypePlace> typePlacesDisponibles = new ArrayList<>();

        for (Billet billet : billets) {
            TypePlace typePlace = billet.getTypePlace();
            if (!typePlacesDisponibles.contains(typePlace)) {
                typePlacesDisponibles.add(typePlace);
            }
        }
        return typePlacesDisponibles;
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
            System.out.println("Lieu: " + evenement.getLieu().getVille());
            System.out.println("Date: " + evenement.getDate());

            // Obtenir les types de places disponibles
            List<TypePlace> typePlacesDisponibles = new ArrayList<>(getTypesDisponibles(evenement));  // Copie mutable

            System.out.println("Types de places disponibles : ");
            for (int i = 0; i < typePlacesDisponibles.size(); i++) {
                System.out.println((i + 1) + ". " + typePlacesDisponibles.get(i));
            }

            TypePlace typePlaceChoisi = null;
            boolean choixValide = false;

            // Forcer un choix valide
            while (!choixValide) {
                System.out.println("Choisissez le type de place (entrez le numéro) :");

                if (scanner.hasNextInt()) {
                    int choixTypePlaceInput = scanner.nextInt();
                    scanner.nextLine();  // Nettoyer la ligne après le nextInt()

                    if (choixTypePlaceInput > 0 && choixTypePlaceInput <= typePlacesDisponibles.size()) {
                        typePlaceChoisi = typePlacesDisponibles.get(choixTypePlaceInput - 1);
                        choixValide = true;
                    } else {
                        System.out.println("Numéro invalide. Veuillez choisir un numéro correct.");
                    }
                } else {
                    System.out.println("Entrée invalide. Veuillez entrer un numéro.");
                    scanner.nextLine();
                }
            }

            // Réservation
            GestionReservation.reserverBillet(client, evenement, typePlaceChoisi);
            System.out.println("Billet réservé avec succès pour " + nomEvenement + ", " + typePlaceChoisi + ".");

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
