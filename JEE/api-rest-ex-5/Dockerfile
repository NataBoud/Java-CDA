# Image officielle Tomcat 11 avec Java 21
FROM tomcat:11.0.9-jdk21

# image maven
#docker run --rm -v ${PWD}:/usr/src/mymaven -w /usr/src/mymaven maven:3.9.4-eclipse-temurin-21 mvn clean package

#si le port est occupé
# docker run -d -p 8081:8080 api-rest-simple

# Supprime les apps par défaut (comme la page d'accueil Tomcat)
RUN rm -rf /usr/local/tomcat/webapps/*

# Copie du fichier WAR dans le dossier webapps
COPY target/api-rest-ex-5-1.0-SNAPSHOT.war /usr/local/tomcat/webapps/ROOT.war
