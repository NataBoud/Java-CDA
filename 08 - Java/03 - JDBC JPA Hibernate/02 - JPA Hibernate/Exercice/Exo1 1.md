## Exercice 1 :

### Parie 1 :

- cree un CRUD sur l'entité Etudiant.

- Etudiant : 
    - Id
    - nom
    - prenom
    - classe

- EtudiantRepository 


### Partie 2 :

- un étudiant a une seule adresse et une adresse est liée à un seul étudiant
    
- Adresse :
    - numéros
    - rue
    - ville
    - code postal

- adresseRepository

- Un étudiant aura une liste d'Examens (One to many)
- Examen :
    - date
    - note
    - Matière (string)

- ExamentRepository

- un étudiant pourra suivre plusieurs cours et un cours pourra être suivi par plusieurs étudiants :
- Cours :
    - matière
    - professeur
    - salle
    - horaire

- CoursRepository


### Bonus : 
- ajouter la recherche d'examens pour un étudiant par matière / par date
- ajouter le calcul de la moyenne d'un étudiant
- ajouter la recherche du cours par matière et par professeur
