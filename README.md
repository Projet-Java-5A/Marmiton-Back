# FrontSkeleton

## Les installations nécessaire

- Java 21

## Avant de lancer le projet

Créer et remplire le .env à partir du message moodle.
La base de données se crée avec docker :

```bash
docker compose up -d
```

## Pour lancer le projet

```java
mvn spring-boot:run
```

Se rendre sur `http://localhost:8080/swagger-ui/index.html` pour le swagger
