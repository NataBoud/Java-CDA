### Exercice : Système de Gestion des Animaux dans un Zoo

Vous allez créer un programme pour gérer les animaux d'un zoo. Le programme devra utiliser des interfaces pour définir des comportements communs et des classes pour les différents types d'animaux. De plus, vous allez gérer les animaux dans des enclos et afficher des informations spécifiques à chaque type d'animal.

#### Étapes de l'exercice :

1. **Définir la classe abstract `Animal`:**
   - Méthode `manger()`: qui ne retourne rien et simule l'action de manger.
   - Méthode `dormir()`: qui ne retourne rien et simule l'action de dormir.
   - Méthode `faireDuBruit()`: qui ne retourne rien et simule l'action de faire du bruit.

2. **Créer des classes concrètes qui herite de la classe `Animal`:**
   - `Lion` : Attributs spécifiques : nom, âge.
   - `Elephant` : Attributs spécifiques : nom, âge, poids.

3. **Définir CLasse generique `Enclos<T>`:**
   - Méthode `ajouterAnimal(Animal animal)`: qui ajoute un animal à l'enclos.
   - Méthode `afficherAnimaux()`: qui affiche le tableau des animaux dans l'enclos.


5. **Classe principale `Zoo`:**
   - Créez des instances de `Lion` et `Elephant`.
   - Ajoutez-les dans les enclos correspondants.
   - Affichez les animaux dans chaque enclos.

6. **IHM :**
    -  Crée un imh permetant de gerer les animaux et leurs enclos
        - création d'animaux
        - création d'enclos
        - ajouter des animaux a des enclos
        - visualiser les animaux dans un enclos

