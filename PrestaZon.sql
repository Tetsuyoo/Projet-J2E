-- +++++++++++++++++++++++++++++++++++++++++++++++++++++ --
-- 		SCRIPT DE CREATION DES DONNEES EMARKET
-- +++++++++++++++++++++++++++++++++++++++++++++++++++++ --

-- --------------------------------------------------------
-- Décommenter les lignes suivantes si les tables existent 
-- déjà dans la base (cas où vous voulez repartir d'un 
-- environnement "propre").
-- 

DROP TABLE IF EXISTS commande ;
DROP TABLE IF EXISTS commandeFournisseur ;
DROP TABLE IF EXISTS compte ;
DROP TABLE IF EXISTS fournisseur ;
DROP TABLE IF EXISTS client ;
DROP TABLE IF EXISTS article ;
-- --------------------------------------------------------

--
-- Structure de la table client
--

CREATE TABLE client (
  idClient INT NOT NULL auto_increment,
  nom VARCHAR(100) NOT NULL,
  prenom VARCHAR(100) NOT NULL,
  adresse VARCHAR(255),
  login VARCHAR(50) NOT NULL,
  password VARCHAR(50) NOT NULL,    
  CONSTRAINT PRIMARY KEY (idClient)
);


-- --------------------------------------------------------

--
-- Structure de la table article
--
CREATE TABLE article (
  reference INT NOT NULL auto_increment,
  type VARCHAR(255) NOT NULL,
  prixUnitaire DOUBLE DEFAULT 0,
  CONSTRAINT PRIMARY KEY (reference)
);

-- --------------------------------------------------------

--
-- Structure de la table product_has_component
--

CREATE TABLE commande (
	idClient INT NOT NULL,
	reference INT NOT NULL,
	dateCommande date,
	quantite INT,
    CONSTRAINT PK_Commande PRIMARY KEY (idClient,reference,dateCommande),
	CONSTRAINT FK_client_commande FOREIGN KEY (idClient) REFERENCES client(idClient),
	CONSTRAINT FK_article_commande FOREIGN KEY (reference) REFERENCES article(reference)
);


-- --------------------------------------------------------

--
-- Structure de la table compte
--

CREATE TABLE compte (
  idCompte INT NOT NULL auto_increment,
  solde DOUBLE DEFAULT 0,
  CONSTRAINT PRIMARY KEY (idCompte)
);


-- --------------------------------------------------------

--
-- Structure de la table compte
--

CREATE TABLE fournisseur (
  idFournisseur INT NOT NULL auto_increment,
  nomFournisseur VARCHAR(100) NOT NULL,
  CONSTRAINT PRIMARY KEY (idFournisseur)
);

-- --------------------------------------------------------

--
-- Structure de la table commandeFournisseur
--

CREATE TABLE commandeFournisseur (
   idClient INT NOT NULL,
   reference INT NOT NULL,
   dateAppro date,
   idFournisseur INT,
   quantiteCmd INT,
   CONSTRAINT PK_CommandeFournisseur PRIMARY KEY (idClient, reference, dateAppro),
   CONSTRAINT FK_client_cmdfournisseur FOREIGN KEY (idClient)
   REFERENCES client(idClient),
   CONSTRAINT FK_article_cmdfournisseur FOREIGN KEY (reference)
   REFERENCES article(reference)
);