package org.example.ExoDAO.Util;

import org.example.ExoDAO.DAO.CategorieDAO;
import org.example.ExoDAO.Entity.Categorie;
import org.example.ExoDAO.Entity.Ingredient;

import java.util.List;
import java.util.Scanner;

public class IhmCategorie {
    private Scanner scanner;
    private CategorieDAO categorieDAO;

    public IhmCategorie() {
        scanner = new Scanner(System.in);
        categorieDAO = new CategorieDAO();
    }

    public void start(){
        String entry ;
        while (true){
            showMenu();
            entry = scanner.nextLine();
            switch (entry) {
                case "1" -> showCategories();
                case "2" -> createCategorie();
                case "3" -> updateCategorie();
                case "4" -> deleteCategorie();
                case "q" -> {
                    return;
                }
                default -> System.out.println("❌ Option invalide, réessayez.");
            }
        }
    }

    private void showMenu() {
        System.out.println("""
                ----📝 GESTION DES CATEGORIES ----
               1️⃣ Afficher tous les categories
               2️⃣ Creer une catégorie
               3️⃣ Mettre à jour une catégorie
               4️⃣ Supprimer une catégorie
               q️⃣  Quitter gestion des categories
                """);
    }

    private void showCategories() {
        List<Categorie> categories = categorieDAO.getAll();
        if (categories.isEmpty()) {
            System.out.println("🚫 Aucune categorie trouvée.");
        } else {
            System.out.println("🍽 Liste des categories : ");
            categories.forEach(categorie ->
                    System.out.println(categorie.getId() + ". " + categorie.getName())
            );
        }
    }
    private void createCategorie() {
        System.out.println("--- ajouter une catégorie ---");
        System.out.println("nom :");
        String name = scanner.nextLine();

        Categorie categorie = Categorie.builder().name(name).build();

        Categorie savedCategorie = categorieDAO.save(categorie);
        if (savedCategorie != null) {
            System.out.println("✅ La catégorie "+savedCategorie.getName()+" a été ajouté avec succès");
        } else {
            System.out.println("❌ Erreur lors de l'ajout de la catégorie.");
        }
    }

    private void updateCategorie() {
        System.out.println("--- Mettre à jour une catégorie ---");
        System.out.print("Entrez l'ID de l'ingrédient à mettre à jour : ");
        int id = Integer.parseInt(scanner.nextLine());

        Categorie categorie = categorieDAO.getById(id);

        if (categorie != null) {
            System.out.print("Nom actuel : " + categorie.getName() + "\nNouveau nom : ");
            String newName = scanner.nextLine();
            categorie.setName(newName);

            boolean updated = categorieDAO.update(categorie);
            if (updated) {
                System.out.println("✅ La catégorie a été mis à jour avec succès.");
            } else {
                System.out.println("❌ Erreur lors de la mise à jour de la catégorie.");
            }
        } else {
            System.out.println("❌ Catégorie non trouvée.");
        }
    }

    private void deleteCategorie() {
        System.out.println("--- Supprimer une catégorie ---");
        System.out.print("Entrez l'ID de la catégorie à supprimer : ");
        int id = Integer.parseInt(scanner.nextLine());

        boolean deleted = categorieDAO.delete(id);
        if (deleted) {
            System.out.println("✅ La catégorie a été supprimé avec succès.");
        } else {
            System.out.println("❌ Erreur lors de la suppression de la catégorie.");
        }
    }

}
