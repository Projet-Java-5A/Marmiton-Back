# FrontSkeleton

## Les installations nécessaire

- Java 21

## Avant de lancer le projet

Créer et remplire le .env à partir du message moodle. (Je le remets la au cas où)

```bash
DATABASE_USER = "marmitax"
DATABASE_NAME = "marmitax"
DATABASE_PASSWORD = "marmitax"
```

## Pour lancer le projet sans docker principal

Dans le fichier `Marmiton\Marmiton-Back\src\main\resources\application.properties` changer le `spring.datasource.url` en décomentant les lignes indiqués.

La base de données se crée avec docker :

```bash
docker compose up -d
```

Lancer l'application :

```java
mvn spring-boot:run
```

Se rendre sur `http://localhost:8080/swagger-ui/index.html` pour le swagger
