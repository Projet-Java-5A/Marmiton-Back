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
INSERT INTO recette (id_recette, nom_recette, contenu_recette, image_recette, difficulte_recette, duree_recette, prix_recette, id_user, approval_status) VALUES
(1, 'tarte à la carotte', 'Première étape : éplucher les carottes ...', 'https://uneplumedanslacuisine.com/wp-content/uploads/2015/07/Tarte-aux-carottes-30-1.jpg', 1, 45, 10, 1, 'APPROVED');

-- Populate utiliser (recette-ustensile)
INSERT INTO utiliser (id_recette, id_ustensile) VALUES
(1, 1);

-- Populate recette_ingredient (recette-ingredient with quantity)
INSERT INTO recette_ingredient (id_recette, id_ingredient, quantité_ingredient) VALUES
(1, 1, '500g'), -- 500g of carottes
(1, 6, '1 pincée'); -- a pinch of poivre

-- Populate categorie
INSERT INTO categorie (id_categorie, nom_categorie) VALUES
(6, 'Féculent'),
(7, 'Produit laitier');

-- Populate ingredient
INSERT INTO ingredient (id_ingredient, nom_ingredient, id_categorie) VALUES
(8, 'Pâtes', 6),
(9, 'Oeuf', 7),
(10, 'Fromage', 7),
(11, 'Lardon', 3),
(12, 'Oignon', 2),
(13, 'Ail', 2),
(14, 'Huile d''olive', 4),
(15, 'Crème fraîche', 7),
(16, 'Poulet', 3),
(17, 'Riz', 6),
(18, 'Curry', 4),
(19, 'Lait de coco', 7),
(20, 'Poivron', 2),
(21, 'Courgette', 2),
(22, 'Boeuf haché', 3),
(23, 'Lasagnes', 6),
(24, 'Sauce tomate', 4),
(25, 'Béchamel', 4);

-- Populate ustensile
INSERT INTO ustensile (id_ustensile, nom_ustensile) VALUES
(4, 'Casserole'),
(5, 'Poêle'),
(6, 'Spatule'),
(7, 'Saladier'),
(8, 'Presse-ail'),
(9, 'Plat à gratin');

-- Populate recette
INSERT INTO recette (id_recette, nom_recette, contenu_recette, image_recette, difficulte_recette, duree_recette, prix_recette, id_user, approval_status) VALUES
(2, 'Pâtes à la carbonara', 'Faire cuire les pâtes. Faire revenir les lardons et l''oignon. Mélanger les oeufs, le fromage et la crème. Ajouter les pâtes et les lardons. Servir chaud.', 'https://assets.afcdn.com/recipe/20160401/465_w600.jpg', 2, 20, 5, 1, 'APPROVED'),
(3, 'Poulet au curry', 'Faire dorer le poulet. Ajouter l''oignon, l''ail et le curry. Verser le lait de coco et laisser mijoter. Servir avec du riz.', 'https://www.etal-des-epices.com/wp-content/uploads/2023/11/poulet-curry-coco.jpg', 2, 30, 12, 2, 'APPROVED'),
(4, 'Lasagnes à la bolognaise', 'Préparer la sauce bolognaise avec le boeuf haché, la sauce tomate, l''oignon et l''ail. Monter les lasagnes en alternant couches de pâtes, de bolognaise et de béchamel. Terminer par du fromage. Enfourner 30 minutes.', 'https://ets-drap.com/wp-content/uploads/2019/04/Lasagne-maison-avec-sauce-Bolognaise-DRAP.jpg', 3, 60, 15, 1, 'APPROVED');

-- Populate utiliser (recette-ustensile)
INSERT INTO utiliser (id_recette, id_ustensile) VALUES
(2, 4),
(2, 5),
(2, 6),
(2, 7),
(3, 4),
(3, 5),
(3, 6),
(3, 8),
(4, 4),
(4, 5),
(4, 6),
(4, 9);

-- Populate recette_ingredient (recette-ingredient with quantity)
INSERT INTO recette_ingredient (id_recette, id_ingredient, quantité_ingredient) VALUES
(2, 8, '400g'),
(2, 11, '200g'),
(2, 9, '2'),
(2, 10, '100g'),
(2, 12, '1'),
(2, 6, '1 pincée'),
(3, 16, '500g'),
(3, 17, '250g'),
(3, 12, '1'),
(3, 13, '2 gousses'),
(3, 14, '2 cuillères à soupe'),
(3, 15, '20cl'),
(3, 18, '2 cuillères à café'),
(3, 19, '20cl'),
(4, 23, '1 paquet'),
(4, 22, '500g'),
(4, 24, '500g'),
(4, 12, '1'),
(4, 13, '2 gousses'),
(4, 14, '2 cuillères à soupe'),
(4, 25, '50cl'),
(4, 10, '150g');