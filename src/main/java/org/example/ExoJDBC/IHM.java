package org.example.ExoJDBC;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class IHM {

    // Afficher tous les étudiants
    private static void afficherTousEtudiants(Connection connection) throws SQLException {
        String query = "SELECT * FROM students";
        try (PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {

            List<Student> students = new ArrayList<>();
            while (resultSet.next()) {
                students.add(new Student(
                        resultSet.getInt("id"),
                        resultSet.getString("nom"),
                        resultSet.getString("prenom"),
                        resultSet.getString("numero_classe"),
                        resultSet.getDate("date_diplome").toLocalDate()
                ));
            }

            if (students.isEmpty()) {
                System.out.println("Aucun étudiant trouvé.");
            } else {
                System.out.println("📋 Liste des étudiants :");
                students.forEach(System.out::println);
            }
        }
    }

    // Afficher les étudiants d'une classe donnée
    private static void afficherEtudiantsParClasse(Connection connection, String numeroClasse) throws SQLException {
        String query = "SELECT * FROM students WHERE numero_classe = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, numeroClasse);
            try (ResultSet resultSet = statement.executeQuery()) {

                List<Student> students = new ArrayList<>();
                while (resultSet.next()) {
                    students.add(new Student(
                            resultSet.getInt("id"),
                            resultSet.getString("nom"),
                            resultSet.getString("prenom"),
                            resultSet.getString("numero_classe"),
                            resultSet.getDate("date_diplome").toLocalDate()
                    ));
                }

                if (students.isEmpty()) {
                    System.out.println(String.format("Aucun étudiant trouvé pour la classe %s.", numeroClasse));
                } else {
                    System.out.println(String.format("📋 Étudiants de la classe %s :", numeroClasse));
                    students.forEach(System.out::println);
                }
            }
        }
    }

    // Ajouter un étudiant
    private static void ajouterEtudiant(Connection connection, Scanner scanner) throws SQLException {
        System.out.print("Entrez le nom de l'étudiant : ");
        String nom = scanner.nextLine();
        System.out.print("Entrez le prénom de l'étudiant : ");
        String prenom = scanner.nextLine();
        System.out.print("Entrez le numéro de classe de l'étudiant : ");
        String numeroClasse = scanner.nextLine();
        System.out.print("Entrez la date de diplôme (YYYY-MM-DD) : ");
        String dateDiplomeStr = scanner.nextLine();

        String query = "INSERT INTO students (nom, prenom, numero_classe, date_diplome) VALUES (?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, nom);
            statement.setString(2, prenom);
            statement.setString(3, numeroClasse);
            statement.setDate(4, Date.valueOf(dateDiplomeStr));  // Convertir la chaîne en Date

            int rowsInserted = statement.executeUpdate();

            if (rowsInserted > 0) {
                System.out.println("✅ Étudiant ajouté avec succès !");
            } else {
                System.out.println("⚠️ Une erreur est survenue lors de l'ajout de l'étudiant.");
            }
        }
    }

    // Supprimer un étudiant par ID
    private static void supprimerEtudiant(Connection connection, int id) throws SQLException {
        String query = "DELETE FROM students WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);
            int rowsDeleted = statement.executeUpdate();

            if (rowsDeleted > 0) {
                System.out.println("Étudiant avec ID %d supprimé avec succès !" + id);
            } else {
                System.out.println("⚠️ Aucun étudiant trouvé avec cet ID.");
            }
        }
    }

    // Méthode pour afficher le menu et gérer les actions
    public static void afficherMenu(Connection connection) {
        Scanner scanner = new Scanner(System.in);
        try {
            if (connection != null) {
                System.out.println("Connexion réussie à la base de données.");

                int choix;
                do {
                    System.out.println("\nMENU :");
                    System.out.println("1️⃣ Afficher tous les étudiants");
                    System.out.println("2️⃣ Afficher les étudiants d'une classe");
                    System.out.println("3️⃣ Supprimer un étudiant");
                    System.out.println("4️⃣ Ajouter un étudiant");
                    System.out.println("0️⃣ Quitter");
                    System.out.print("Choisissez une option : ");
                    choix = scanner.nextInt();
                    scanner.nextLine();  // Consommer la ligne restante après le choix

                    switch (choix) {
                        case 1 -> afficherTousEtudiants(connection);
                        case 2 -> {
                            System.out.print("Entrez le numéro de la classe : ");
                            String numeroClasse = scanner.nextLine();
                            afficherEtudiantsParClasse(connection, numeroClasse);
                        }
                        case 3 -> {
                            System.out.print("🗑 Entrez l'ID de l'étudiant à supprimer : ");
                            int id = scanner.nextInt();
                            supprimerEtudiant(connection, id);
                        }
                        case 4 -> ajouterEtudiant(connection, scanner);
                        case 0 -> System.out.println("Fermeture du programme...");
                        default -> System.out.println("Option invalide, veuillez réessayer !");
                    }
                } while (choix != 0);
            }
        } catch (SQLException ex) {
            System.out.println("Erreur SQL : " + ex.getMessage());
        } finally {
            scanner.close();
        }
    }
}
