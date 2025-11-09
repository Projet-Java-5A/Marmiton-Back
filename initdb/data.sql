-- Populate utilisateurs
INSERT INTO utilisateurs (id_user, is_admin, nom_user, prenom_user, mail_user, mdp_user) VALUES
(1, true, 'ABDELLI', 'Arthur', 'arthur@arthur', 'arthur'),
(2, false, 'ABDELLI', 'Younes', 'younes@younes', 'younes'),
(3, false, 'MARTIN', 'Léa', 'lea@martin.fr', 'leamartin'),
(4, true, 'SEGOUIN', 'Lou', 'lou@lou', 'loulou'),
(5, false, 'PASTEAU', 'Evan', 'evan@evan', 'evannn');

-- Populate categorie
INSERT INTO categorie (id_categorie, nom_categorie) VALUES
(1, 'fruit'),
(2, 'légume'),
(3, 'viande'),
(4, 'condiment'),
(5, 'légumineuse'),
(6, 'Féculent'),
(7, 'Produit laitier');

-- Populate ingredient
INSERT INTO ingredient (id_ingredient, nom_ingredient, id_categorie) VALUES
(1, 'carotte', 2),
(2, 'tomate', 2),
(4, 'pomme', 1),
(5, 'côte de porc', 3),
(6, 'poivre', 4),
(7, 'pois chiche', 5),
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
(25, 'Béchamel', 4),
(26, 'Pâte brisée', 6),
(27, 'Noix de muscade', 4),
(28, 'Pomme de terre', 2),
(29, 'Lait', 7),
(30, 'Beurre', 7),
(31, 'Chapelure', 6),
(32, 'Salade (laitue)', 2),
(33, 'Parmesan', 7),
(34, 'Croûtons', 6),
(35, 'Anchois', 3),
(36, 'Moutarde de Dijon', 4),
(37, 'Jus de citron', 1),
(38, 'Chocolat noir', 7),
(39, 'Sucre', 4),
(40, 'Farine', 6),
(41, 'Mascarpone', 7),
(42, 'Café fort', 4),
(43, 'Cacao en poudre', 4),
(44, 'Boudoirs', 6),
(45, 'Vin rouge', 4),
(46, 'Bouillon de boeuf', 4),
(47, 'Champignons de Paris', 2),
(48, 'Lardons fumés', 3),
(49, 'Veau (sauté)', 3),
(50, 'Crème fleurette', 7),
(51, 'Vin blanc sec', 4),
(52, 'Bouillon de volaille', 4),
(53, 'Jaune d''oeuf', 7),
(54, 'Sel', 4);

-- Populate ustensile
INSERT INTO ustensile (id_ustensile, nom_ustensile) VALUES
(1, 'four'),
(2, 'micro-onde'),
(3, 'plancha'),
(4, 'Casserole'),
(5, 'Poêle'),
(6, 'Spatule'),
(7, 'Saladier'),
(8, 'Presse-ail'),
(9, 'Plat à gratin'),
(10, 'Moule à tarte'),
(11, 'Fouet'),
(12, 'Économe'),
(13, 'Mixeur plongeant'),
(14, 'Plat à gratin'),
(15, 'Couteau'),
(16, 'Planche à découper'),
(17, 'Cocotte');

-- Populate recette
INSERT INTO recette (id_recette, nom_recette, contenu_recette, image_recette, difficulte_recette, duree_recette, prix_recette, id_user, approval_status) VALUES
(1, 'tarte à la carotte', 'Première étape : éplucher les carottes ...', 'https://uneplumedanslacuisine.com/wp-content/uploads/2015/07/Tarte-aux-carottes-30-1.jpg', 1, 45, 10, 1, 'APPROVED'),
(2, 'Pâtes à la carbonara', 'Faire cuire les pâtes. Faire revenir les lardons et l''oignon. Mélanger les oeufs, le fromage et la crème. Ajouter les pâtes et les lardons. Servir chaud.', 'https://assets.afcdn.com/recipe/20160401/465_w600.jpg', 2, 20, 5, 1, 'APPROVED'),
(3, 'Poulet au curry', 'Faire dorer le poulet. Ajouter l''oignon, l''ail et le curry. Verser le lait de coco et laisser mijoter. Servir avec du riz.', 'https://www.etal-des-epices.com/wp-content/uploads/2023/11/poulet-curry-coco.jpg', 2, 30, 12, 2, 'APPROVED'),
(4, 'Lasagnes à la bolognaise', 'Préparer la sauce bolognaise avec le boeuf haché, la sauce tomate, l''oignon et l''ail. Monter les lasagnes en alternant couches de pâtes, de bolognaise et de béchamel. Terminer par du fromage. Enfourner 30 minutes.', 'https://ets-drap.com/wp-content/uploads/2019/04/Lasagne-maison-avec-sauce-Bolognaise-DRAP.jpg', 3, 60, 15, 1, 'APPROVED'),
(5, 'Quiche Lorraine', 'Préchauffer le four à 180°C. Étaler la pâte brisée dans un moule à tarte. Faire dorer les lardons à la poêle. Dans un saladier, battre les oeufs avec la crème fraîche, le sel, le poivre et la muscade. Ajouter les lardons et le fromage râpé. Verser la préparation sur la pâte. Enfourner pour 30-35 minutes.', 'url_image_quiche', 2, 45, 8, 3, 'APPROVED'),
(6, 'Gratin Dauphinois', 'Préchauffer le four à 160°C. Éplucher et couper les pommes de terre en fines rondelles. Frotter un plat à gratin avec une gousse d''ail. Disposer les rondelles de pommes de terre dans le plat. Dans une casserole, faire chauffer le lait, la crème, le sel, le poivre et la muscade. Verser sur les pommes de terre. Parsemer de noisettes de beurre. Enfourner pour 1h30.', 'url_image_gratin', 2, 110, 9, 4, 'APPROVED'),
(7, 'Hachis Parmentier', 'Faire cuire les pommes de terre et les écraser en purée avec du lait et du beurre. Saler, poivrer. Faire revenir l''oignon et l''ail hachés, puis ajouter le boeuf haché et la sauce tomate. Laisser mijoter. Dans un plat à gratin, étaler une couche de viande puis recouvrir de purée. Strier avec une fourchette et parsemer de chapelure. Enfourner 20 minutes à 200°C.', 'url_image_hachis', 2, 50, 11, 5, 'APPROVED'),
(8, 'Salade César', 'Laver et essorer la salade. Couper le poulet en morceaux et le faire dorer. Préparer la sauce : mixer l''ail, les anchois, le parmesan, le jaune d''oeuf, le jus de citron et la moutarde. Monter à l''huile d''olive. Mélanger la salade, le poulet, les croûtons et la sauce. Servir avec des copeaux de parmesan.', 'url_image_cesar', 2, 25, 13, 1, 'APPROVED'),
(9, 'Mousse au chocolat', 'Faire fondre le chocolat au bain-marie. Séparer les blancs des jaunes d''oeufs. Ajouter les jaunes au chocolat fondu. Monter les blancs en neige ferme avec une pincée de sel. Incorporer délicatement les blancs en neige au mélange chocolaté. Réfrigérer au moins 3 heures.', 'url_image_mousse', 1, 20, 7, 2, 'APPROVED'),
(10, 'Crêpes faciles', 'Dans un saladier, mélanger la farine et le sucre. Creuser un puits et y ajouter les oeufs. Mélanger au fouet en ajoutant le lait petit à petit pour éviter les grumeaux. Ajouter le beurre fondu. Laisser reposer la pâte 1 heure. Faire cuire les crêpes dans une poêle chaude et huilée.', 'url_image_crepes', 1, 80, 4, 3, 'APPROVED'),
(11, 'Tiramisu', 'Séparer les blancs des jaunes d''oeufs. Mélanger les jaunes avec le sucre jusqu''à ce que le mélange blanchisse. Ajouter le mascarpone et fouetter. Monter les blancs en neige et les incorporer délicatement. Tremper rapidement les boudoirs dans le café froid. Monter le tiramisu en alternant une couche de boudoirs et une couche de crème. Réfrigérer au moins 4 heures. Saupoudrer de cacao avant de servir.', 'url_image_tiramisu', 3, 30, 14, 4, 'APPROVED'),
(12, 'Boeuf Bourguignon', 'Couper le boeuf en morceaux. Dans une cocotte, faire dorer la viande sur toutes ses faces avec de l''huile. Retirer la viande. Faire revenir les oignons et les carottes. Remettre la viande, saupoudrer de farine et mélanger. Ajouter le vin rouge, le bouillon, l''ail et un bouquet garni. Couvrir et laisser mijoter 3 heures à feu doux. Ajouter les champignons et les lardons 30 minutes avant la fin.', 'url_image_bourguignon', 4, 200, 20, 5, 'APPROVED'),
(13, 'Soupe à l''oignon', 'Émincer finement les oignons. Les faire revenir dans une casserole avec du beurre pendant 20 minutes jusqu''à ce qu''ils soient bien caramélisés. Saupoudrer de farine, mélanger, puis ajouter le vin blanc et le bouillon de boeuf. Laisser mijoter 30 minutes. Servir dans des bols allant au four, déposer une tranche de pain grillé, couvrir de fromage râpé et faire gratiner.', 'url_image_soupe_oignon', 2, 60, 8, 1, 'APPROVED'),
(14, 'Ratatouille', 'Couper tous les légumes (tomates, courgettes, poivrons, oignon) en morceaux. Faire revenir l''oignon et l''ail dans une cocotte avec de l''huile d''olive. Ajouter les poivrons et laisser cuire 10 minutes. Ajouter les courgettes, puis les tomates. Saler, poivrer, ajouter des herbes de Provence. Couvrir et laisser mijoter 45 minutes.', 'url_image_ratatouille', 2, 70, 10, 2, 'APPROVED'),
(15, 'Blanquette de veau', 'Mettre les morceaux de veau dans une cocotte, couvrir d''eau froide. Porter à ébullition et écumer. Ajouter les carottes, un oignon et un bouquet garni. Laisser mijoter 1h30. Faire un roux : faire fondre le beurre, ajouter la farine, puis délayer avec du bouillon de cuisson filtré. Ajouter les champignons. Lier la sauce avec le jaune d''oeuf, la crème et un filet de citron. Napper la viande de cette sauce.', 'url_image_blanquette', 4, 120, 22, 4, 'PENDING');

-- Populate utiliser (recette-ustensile)
INSERT INTO utiliser (id_recette, id_ustensile) VALUES
(1, 1),
(2, 4), (2, 5), (2, 6), (2, 7),
(3, 4), (3, 5), (3, 6), (3, 8),
(4, 4), (4, 5), (4, 6), (4, 9),
(5, 1), (5, 5), (5, 7), (5, 10), (5, 11), 
(6, 1), (6, 4), (6, 8), (6, 12), (6, 14),
(7, 4), (7, 5), (7, 14), (7, 15), (7, 16), 
(8, 5), (8, 7), (8, 13), (8, 15), (8, 16),
(9, 4), (9, 7), (9, 11), 
(10, 5), (10, 7), (10, 11), 
(11, 7), (11, 11), 
(12, 17), (12, 15), (12, 16), 
(13, 1), (13, 4), (13, 15), (13, 16), 
(14, 17), (14, 15), (14, 16), 
(15, 17), (15, 11), (15, 15);

-- Populate recette_ingredient (recette-ingredient with quantity)
INSERT INTO recette_ingredient (id_recette, id_ingredient, quantite) VALUES
(1, 1, '500g'), (1, 6, '1 pincée'),
(2, 8, '400g'), (2, 11, '200g'), (2, 9, '2'), (2, 10, '100g'), (2, 12, '1'), (2, 6, '1 pincée'),
(3, 16, '500g'), (3, 17, '250g'), (3, 12, '1'), (3, 13, '2 gousses'), (3, 14, '2 cuillères à soupe'), (3, 15, '20cl'), (3, 18, '2 cuillères à café'), (3, 19, '20cl'),
(4, 23, '1 paquet'), (4, 22, '500g'), (4, 24, '500g'), (4, 12, '1'), (4, 13, '2 gousses'), (4, 14, '2 cuillères à soupe'), (4, 25, '50cl'), (4, 10, '150g'),
(5, 26, '1'), (5, 11, '200g'), (5, 9, '3'), (5, 15, '20cl'), (5, 10, '150g'), (5, 54, '1 pincée'), (5, 6, '1 pincée'), (5, 27, '1 pincée'),
(6, 28, '1.5kg'), (6, 13, '2 gousses'), (6, 29, '50cl'), (6, 15, '50cl'), (6, 30, '50g'), (6, 54, 'sel'), (6, 6, 'poivre'), (6, 27, '1 pincée'),
(7, 28, '1kg'), (7, 22, '500g'), (7, 12, '1'), (7, 13, '1 gousse'), (7, 24, '200g'), (7, 29, '20cl'), (7, 30, '40g'), (7, 31, '3 cuillères à soupe'),
(8, 32, '1'), (8, 16, '2 blancs'), (8, 34, '100g'), (8, 33, '50g'), (8, 53, '1'), (8, 13, '1 gousse'), (8, 35, '2 filets'), (8, 36, '1 c.à.c'), (8, 37, '1/2'), (8, 14, '10cl'),
(9, 38, '200g'), (9, 9, '6'), (9, 54, '1 pincée'),
(10, 40, '250g'), (10, 9, '4'), (10, 29, '50cl'), (10, 39, '2 c.à.s'), (10, 30, '50g'),
(11, 9, '3'), (11, 39, '100g'), (11, 41, '250g'), (11, 44, '24'), (11, 42, '20cl'), (11, 43, '2 c.à.s'),
(12, 22, '1.5kg de boeuf'), (12, 1, '2'), (12, 12, '2'), (12, 48, '200g'), (12, 45, '75cl'), (12, 46, '50cl'), (12, 47, '250g'), (12, 40, '2 c.à.s'),
(13, 12, '5'), (13, 30, '50g'), (13, 40, '1 c.à.s'), (13, 51, '20cl'), (13, 46, '1L'), (13, 10, '150g'),
(14, 2, '4'), (14, 21, '2'), (14, 20, '2'), (14, 12, '1'), (14, 13, '2 gousses'), (14, 14, '4 c.à.s'),
(15, 49, '1.2kg'), (15, 1, '2'), (15, 12, '1'), (15, 47, '250g'), (15, 30, '50g'), (15, 40, '40g'), (15, 50, '20cl'), (15, 53, '1'), (15, 37, '1/2');

SELECT setval('utilisateurs_id_user_seq', (SELECT MAX(id_user) FROM utilisateurs));
SELECT setval('categorie_id_categorie_seq', (SELECT MAX(id_categorie) FROM categorie));
SELECT setval('ingredient_id_ingredient_seq', (SELECT MAX(id_ingredient) FROM ingredient));
SELECT setval('ustensile_id_ustensile_seq', (SELECT MAX(id_ustensile) FROM ustensile));
SELECT setval('recette_id_recette_seq', (SELECT MAX(id_recette) FROM recette));