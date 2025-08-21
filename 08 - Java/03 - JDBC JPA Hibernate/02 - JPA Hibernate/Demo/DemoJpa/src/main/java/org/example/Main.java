package org.example;



import org.example.Heritage.Product;
import org.example.Heritage.ProductElectronic;
import org.example.Heritage.ProductFood;
import org.example.Heritage.ProductHousing;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf= Persistence.createEntityManagerFactory("demo_jpa");
        EntityManager entityManager = emf.createEntityManager();

//        Article article = Article.builder()
//                .name("Article4")
//                .price(12.80f)
//                .quantity(25)
//                .restockDate(LocalDate.now())
//                .build();
//// Ajout de la donnée
//        entityManager.getTransaction().begin();
//        entityManager.persist(article);
//        entityManager.getTransaction().commit();

    // find / getReference
//        int id = 10;
//        Article article = entityManager.find(Article.class,id);
//        System.out.println(article);
//
//        try{
//            Article article1 = entityManager.getReference(Article.class,10);
//            System.out.println(article1);
//        }catch (EntityNotFoundException ex){
//            System.out.println(ex.getMessage());
//        }

        //Query
//        Query query = entityManager.createQuery("select article from Article as article where article.name = :name",Article.class);
//        query.setParameter("name","Article1");
//
//        Article articleFound =  (Article) query.getSingleResult();
//
//        System.out.println(articleFound);
//
//        Query query1 = entityManager.createQuery("select a from Article a",Article.class);
//        List<Article> articles = query1.getResultList();
//
//        System.out.println(articles);

//Update
//    entityManager.getTransaction().begin();
//    Article article = entityManager.find(Article.class,2);
//    if(article != null){
//        article.setQuantity(200);
//        article.setPrice(80.2f);
//
//    }
//    entityManager.getTransaction().commit();

        //delete
//    entityManager.getTransaction().begin();
//    Article article = entityManager.find(Article.class,4);
//    if(article != null){
//        entityManager.remove(article);
//    }
//    entityManager.getTransaction().commit();
//
//

        //one to one
//        Adresse adresse = Adresse.builder().codePostal(59000).rue("rue de la rue").build();
//        Adresse adresse2 = Adresse.builder().codePostal(59300).rue("rue de la rue2 ").build();
//
//        Fabriquant fabriquant = Fabriquant.builder().name("Fabriquant1").adresse(adresse).build();
//        Fabriquant fabriquant2 = Fabriquant.builder().name("Fabriquant2").adresse(adresse2).build();
//
//
//        entityManager.getTransaction().begin();
//
//        entityManager.persist(fabriquant);
//        entityManager.persist(fabriquant2);
//
//        entityManager.getTransaction().commit();


        //many to one

//        Article article1 = entityManager.find(Article.class,1);
//        Article article2 = entityManager.find(Article.class,2);
//
//        Fabriquant fabriquant = entityManager.find(Fabriquant.class,1);
//
//        entityManager.getTransaction().begin();
//
//        article1.setFabriquant(fabriquant);
//        article2.setFabriquant(fabriquant);
//
//        entityManager.getTransaction().commit();


//        Fabriquant fabriquant1 = entityManager.find(Fabriquant.class,1);
//
//        System.out.println(fabriquant1);


        //Many to Many

//        Commande commande = Commande.builder().numerosCommande("qqsd64851231").build();
//
//        Article article1 = entityManager.find(Article.class,1);
//        Article article2 = entityManager.find(Article.class,2);
//
//        commande.setArticles(Arrays.asList(article1,article2));
//
//        entityManager.getTransaction().begin();
//
//        entityManager.persist(commande);
//
//        entityManager.getTransaction().commit();
//
//        Commande commande1 = entityManager.find(Commande.class,1);
//        System.out.println(commande1);
//

        Product product = ProductElectronic.builder().batterieDuration(12).name("product1").price(12.5f).build();
        Product product2 = ProductElectronic.builder().batterieDuration(12).name("product2").price(12.5f).build();
        Product product3 = ProductFood.builder().expiryDate(LocalDate.now()).name("product3").price(12.5f).build();
        Product product4 = ProductHousing.builder().height(10).width(50).name("product3").price(12.5f).build();

        entityManager.getTransaction().begin();
        entityManager.persist(product);
        entityManager.persist(product2);
        entityManager.persist(product3);
        entityManager.persist(product4);
        entityManager.persist(product);
        entityManager.getTransaction().commit();

    }
}

