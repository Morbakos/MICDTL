CREATE TABLE TEMPS_D (
    jour varchar(256) NOT NULL,
    temps_SK int NOT NULL PRIMARY KEY
);

CREATE TABLE CLIENTS_D (
    nom_client varchar(100) NOT NULL,
    adresse_client varchar(100) NOT NULL,
    adresse_facture varchar(100) NOT NULL,
    adresse_livraison varchar(100) NOT NULL,
    code_postal_facture int NOT NULL,
    client_SK int NOT NULL PRIMARY KEY
);

CREATE TABLE PRODUITS_D (
    produit_id int NOT NULL,
    produit_description varchar(100) NOT NULL,
    marque_produit varchar(100) NOT NULL,
    code_marque int NOT NULL,
    categorie_produit varchar(100) NOT NULL,
    code_categorie int NOT NULL,
    unite_stock varchar(100) NOT NULL,
    produit_SK int NOT NULL PRIMARY KEY
);

CREATE TABLE VENDEURS_D (
    nom_vendeur varchar(100) NOT NULL,
    region_vendeur varchar(100) NOT NULL,
    territoire_vendeur varchar(100) NOT NULL,
    vendeur_SK int NOT NULL PRIMARY KEY
);

CREATE TABLE MARGES_F (
    marge_degagee int NOT NULL,
    marges_id int NOT NULL PRIMARY KEY,
    montant_commande int NOT NULL,
    client_SK int NOT NULL,
    vendeur_SK int NOT NULL,
    produit_SK int NOT NULL,
    temps_SK int NOT NULL,

    FOREIGN key (client_SK) REFERENCES CLIENTS_D(client_SK),
    FOREIGN key (vendeur_SK) REFERENCES VENDEURS_D(vendeur_SK),
    FOREIGN key (produit_SK) REFERENCES PRODUITS_D(produit_SK),
    FOREIGN key (temps_SK) REFERENCES TEMPS_D(temps_SK)
)

SELECT v.nom_vendeur, c.nom_client,m.marge_degagee, m.montant_commande
FROM 
	MARGES_F m
JOIN 
	CLIENTS_D c 
ON
	m.client_SK = c.client_SK
JOIN 
	VENDEURS_D v 
ON 
	v.vendeur_SK = m.vendeur_SK
JOIN 
	PRODUITS_D p
ON
	p.produit_SK = m.produit_SK
JOIN
	TEMPS_D t
ON
	t.temps_SK = m.temps_SK
WHERE
	t.jour = "26 octobre 2013" AND  p.produit_description = "Clé USB 64Go Rouge"
GROUP BY (
	v.nom_vendeur,
	c.nom_client,
	m.marge_degagee,
	m.montant_commande
)

SELECT SUM(marge_degagee), SUM(montant_commande) 
FROM 
	MARGES_F


SELECT m.montant_commande
FROM 
	MARGES_F m
JOIN 
	CLIENTS_D c 
ON
	m.client_SK = c.client_SK
JOIN 
	VENDEURS_D v 
ON 
	v.vendeur_SK = m.vendeur_SK
JOIN 
	PRODUITS_D p
ON
	p.produit_SK = m.produit_SK
JOIN
	TEMPS_D t
ON
	t.temps_SK = m.temps_SK
WHERE
	t.jour = "26 octobre 2013" AND  p.produit_description = "Clé USB 64Go Rouge"
GROUP BY (
	v.nom_vendeur,
	c.nom_client,
	m.marge_degagee,
	c.montant_commande
)