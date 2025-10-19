-- Populate utilisateurs
INSERT INTO utilisateurs (id_user, is_admin, nom_user, prenom_user, mail_user, mdp_user) VALUES
(1, true, 'ABDELLI', 'Arthur', 'arthur@arthur', 'arthur'),
(2, false, 'ABDELLI', 'Younes', 'younes@younes', 'younes');

-- Populate categorie
INSERT INTO categorie (id_categorie, nom_categorie) VALUES
(1, 'fruit'),
(2, 'légume'),
(3, 'viande'),
(4, 'condiment'),
(5, 'légumineuse');

-- Populate ingredient
INSERT INTO ingredient (id_ingredient, nom_ingredient, id_categorie) VALUES
(1, 'carotte', 2),
(2, 'tomate', 2),
(4, 'pomme', 1),
(5, 'côte de porc', 3),
(6, 'poivre', 4),
(7, 'pois chiche', 5);

-- Populate ustensile
INSERT INTO ustensile (id_ustensile, nom_ustensile) VALUES
(1, 'four'),
(2, 'micro-onde'),
(3, 'plancha');

-- Populate recette
INSERT INTO recette (id_recette, nom_recette, contenu_recette, image_recette, difficulte_recette, duree_recette, prix_recette, id_user) VALUES
(1, 'tarte à la carotte', 'Première étape : éplucher les carottes ...', 'https://uneplumedanslacuisine.com/wp-content/uploads/2015/07/Tarte-aux-carottes-30-1.jpg', 1, 45, 10, 1);

-- Populate utiliser (recette-ustensile)
INSERT INTO utiliser (id_recette, id_ustensile) VALUES
(1, 1);

-- Populate recette_ingredient (recette-ingredient with quantity)
INSERT INTO recette_ingredient (id_recette, id_ingredient, quantite) VALUES
(1, 1, '500g'), -- 500g of carottes
(1, 6, '1 pincée'); -- a pinch of poivre
