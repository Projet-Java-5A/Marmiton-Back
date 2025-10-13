CREATE SEQUENCE utilisateurs_seq START WITH 1 INCREMENT BY 50;
CREATE SEQUENCE categorie_seq START WITH 1 INCREMENT BY 50;
CREATE SEQUENCE ustensile_seq START WITH 1 INCREMENT BY 50;
CREATE SEQUENCE ingredient_seq START WITH 1 INCREMENT BY 50;
CREATE SEQUENCE recette_seq START WITH 1 INCREMENT BY 50;

CREATE TABLE utilisateurs (
    id_user BIGINT PRIMARY KEY DEFAULT nextval('utilisateurs_seq'),
    is_admin BOOLEAN,
    nom_user VARCHAR(255),
    prenom_user VARCHAR(255),
    mail_user VARCHAR(255),
    mdp_user VARCHAR(255)
);

CREATE TABLE categorie (
    id_categorie BIGINT PRIMARY KEY DEFAULT nextval('categorie_seq'),
    nom_categorie VARCHAR(255)
);

CREATE TABLE ustensile (
    id_ustensile BIGINT PRIMARY KEY DEFAULT nextval('ustensile_seq'),
    nom_ustensile VARCHAR(255)
);

CREATE TABLE ingredient (
    id_ingredient BIGINT PRIMARY KEY DEFAULT nextval('ingredient_seq'),
    nom_ingredient VARCHAR(255),
    id_categorie BIGINT,
    FOREIGN KEY (id_categorie) REFERENCES categorie (id_categorie)
);

CREATE TABLE recette (
    id_recette BIGINT PRIMARY KEY DEFAULT nextval('recette_seq'),
    nom_recette VARCHAR(255),
    duree_recette INTEGER,
    difficulte_recette INTEGER,
    prix_recette INTEGER,
    image_recette VARCHAR(255),
    contenu_recette TEXT,
    id_user BIGINT,
    FOREIGN KEY (id_user) REFERENCES utilisateurs (id_user)
);

CREATE TABLE contenir (
    id_recette BIGINT,
    id_ingredient BIGINT,
    quantité_ingredient VARCHAR(255),
    PRIMARY KEY (id_recette, id_ingredient),
    FOREIGN KEY (id_recette) REFERENCES recette (id_recette),
    FOREIGN KEY (id_ingredient) REFERENCES ingredient (id_ingredient)
);

CREATE TABLE utiliser (
    id_recette BIGINT,
    id_ustensile BIGINT,
    PRIMARY KEY (id_recette, id_ustensile),
    FOREIGN KEY (id_recette) REFERENCES recette (id_recette),
    FOREIGN KEY (id_ustensile) REFERENCES ustensile (id_ustensile)
);