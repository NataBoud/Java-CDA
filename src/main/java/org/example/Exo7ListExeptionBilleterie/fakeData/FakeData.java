package org.example.Exo7ListExeptionBilleterie.fakeData;

import org.example.Exo7ListExeptionBilleterie.Client;
import org.example.Exo7ListExeptionBilleterie.evenement.*;

import java.time.LocalDate;
import java.util.List;

public class FakeData {
    public static List<Evenement> getEvenements() {

        // Liste inmodifiable
        // Création des adresses
        Adresse adresseClient1 = new Adresse("1 Rue de Paris", "Paris");
        Adresse adresseClient2 = new Adresse("2 Rue de Lyon", "Lyon");
        Adresse adresseClient3 = new Adresse("3 Rue de Marseille", "Marseille");

        // Création des lieux
        Lieu stade = new Lieu("25 Rue du Stade", "Paris", 50000);
        Lieu concertHall = new Lieu("12 Rue du Stade", "Paris", 20000);
        Lieu theatre = new Lieu("50 Avenue de la Musique", "Lyon", 1000);

        // Création des clients
        Client client1 = new Client("Dupont", "Jean", adresseClient1, "0123456789", 30);
        Client client2 = new Client("Martin", "Sophie", adresseClient2, "0987654321", 25);
        Client client3 = new Client("Durand", "Paul", adresseClient3, "0112233445", 40);

        // Création des événements
        Evenement matchFoot = new Evenement("Match de foot", stade, LocalDate.of(2024, 5, 10), "20:00", 50000);
        Evenement concertRock = new Evenement("Concert Rock", concertHall, LocalDate.of(2024, 6, 15), "21:00", 20000);
        Evenement pieceTheatre = new Evenement("Pièce de Théâtre", theatre, LocalDate.of(2024, 7, 20), "19:00", 1000);

        // Création des billets en associant les événements
        List<Billet> billetsFoot = List.of(
                new Billet(1, client1, matchFoot, TypePlace.STANDARD),
                new Billet(2, client2, matchFoot, TypePlace.VIP)
        );

        List<Billet> billetsConcert = List.of(
                new Billet(1, client3, concertRock, TypePlace.GOLD),
                new Billet(2, client1, concertRock, TypePlace.STANDARD)
        );

        List<Billet> billetsTheatre = List.of(
                new Billet(1, client2, pieceTheatre, TypePlace.VIP),
                new Billet(2, client3, pieceTheatre, TypePlace.GOLD)
        );

        // Mise à jour des événements avec leurs billets respectifs
        matchFoot.setBillets(billetsFoot);
        concertRock.setBillets(billetsConcert);
        pieceTheatre.setBillets(billetsTheatre);

        // Retourne la liste des événements
        return List.of(matchFoot, concertRock, pieceTheatre);
    }
}
