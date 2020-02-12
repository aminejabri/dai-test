DROP TABLE IF EXISTS `UTIL_EXERCICE`;
DROP TABLE IF EXISTS `COMPOSER_PER_PRO`;
DROP TABLE IF EXISTS `AFFECT_UTIL_PROGRA`;
DROP TABLE IF EXISTS `COMPOSER_SEA_EXE`;
DROP TABLE IF EXISTS `UTIL_SEANCE`;
DROP TABLE IF EXISTS `PROFIL`;
DROP TABLE IF EXISTS `RECEVOIR`;
DROP TABLE IF EXISTS `ROLES`;
DROP TABLE IF EXISTS `BILAN`;
DROP TABLE IF EXISTS `PROG_SEANCE`;
DROP TABLE IF EXISTS `SEANCE_PERIODE`;
DROP TABLE IF EXISTS `COMPOSER_SEA_EXE`;
DROP TABLE IF EXISTS `NOTIFICATIONS`;
DROP TABLE IF EXISTS `UTILISATEUR`;
DROP TABLE IF EXISTS `PROGRAMME`;
DROP TABLE IF EXISTS `SEANCE`;
DROP TABLE IF EXISTS `PERIODE`;
DROP TABLE IF EXISTS `EXERCICE`;

-- LISTAGE DE LA STRUCTURE DE LA TABLE MLR1. UTILISATEUR
DROP TABLE IF EXISTS `UTILISATEUR`;
CREATE TABLE IF NOT EXISTS `UTILISATEUR` (
  `UTIL_ID` INT(11) NOT NULL AUTO_INCREMENT,
  `UTIL_USERNAME` VARCHAR(45) NOT NULL,
  `UTIL_EMAIL` VARCHAR(100) NOT NULL,
  `UTIL_DATE_NAISSANCE` DATETIME NOT NULL,
  `UTIL_PASSWORD` VARCHAR(200) DEFAULT NULL,
  `UTIL_NOM` VARCHAR(100) DEFAULT NULL,
  `UTIL_PRENOM` VARCHAR(100) DEFAULT NULL,
  `UTIL_ENABLED` TINYINT(4) NOT NULL DEFAULT 1,
  `UTIL_ACCOUNT_NON_EXPIRED` TINYINT(1) DEFAULT NULL,
  `UTIL_ACCOUNT_NON_LOCKED` TINYINT(1) DEFAULT NULL,
  `UTIL_CREDENTIALS_NON_EXPIRED` TINYINT(1) DEFAULT NULL,
  `UTIL_CERTIFICAT` VARCHAR(32) DEFAULT NULL,
  PRIMARY KEY (`UTIL_ID`),
  UNIQUE KEY `UTIL_USERNAME` (`UTIL_USERNAME`),
  UNIQUE KEY `UTIL_EMAIL` (`UTIL_EMAIL`)
) ENGINE=INNODB AUTO_INCREMENT=4 DEFAULT CHARSET=UTF8;

-- LES DONNÉES EXPORTÉES N'ÉTAIENT PAS SÉLECTIONNÉES.

-- LISTAGE DE LA STRUCTURE DE LA TABLE MLR1. PROGRAMME
DROP TABLE IF EXISTS `PROGRAMME`;
CREATE TABLE IF NOT EXISTS `PROGRAMME` (
  `PROG_ID` INT(10) NOT NULL AUTO_INCREMENT,
  `PROG_NOM` VARCHAR(32) NOT NULL,
  `PROG_TYPE` TINYINT(1) DEFAULT NULL,
  PRIMARY KEY (`PROG_ID`)
) ENGINE=INNODB DEFAULT CHARSET=UTF8;

-- LES DONNÉES EXPORTÉES N'ÉTAIENT PAS SÉLECTIONNÉES.

-- LISTAGE DE LA STRUCTURE DE LA TABLE MLR1. SEANCE
DROP TABLE IF EXISTS `SEANCE`;
CREATE TABLE IF NOT EXISTS `SEANCE` (
  `SEA_ID` INT(10) NOT NULL AUTO_INCREMENT,
  `SEA_TYPE` VARCHAR(32) DEFAULT NULL,
  PRIMARY KEY (`SEA_ID`)
) ENGINE=INNODB DEFAULT CHARSET=UTF8;

-- LES DONNÉES EXPORTÉES N'ÉTAIENT PAS SÉLECTIONNÉES.

-- LISTAGE DE LA STRUCTURE DE LA TABLE MLR1. PERIODE
DROP TABLE IF EXISTS `PERIODE`;
CREATE TABLE IF NOT EXISTS `PERIODE` (
  `PER_ID` INT(10) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`PER_ID`)
) ENGINE=INNODB DEFAULT CHARSET=UTF8;


-- LISTAGE DE LA STRUCTURE DE LA TABLE MLR1. AFFECT_UTIL_PROGRA
DROP TABLE IF EXISTS `AFFECT_UTIL_PROGRA`;
CREATE TABLE IF NOT EXISTS `AFFECT_UTIL_PROGRA` (
  `AUP_ID` INT(10) NOT NULL AUTO_INCREMENT,
  `AUP_UTIL_ID` INT(10) NOT NULL,
  `AUP_PROG_ID` INT(10) NOT NULL,
  PRIMARY KEY (`AUP_ID`),
  KEY `I_FK_AFFECT_UTIL_PROGRA_UTILISATEUR` (`AUP_UTIL_ID`),
  KEY `I_FK_AFFECT_UTIL_PROGRA_PROGRAMME` (`AUP_PROG_ID`),
  UNIQUE KEY `UNI_UTIL_PROGRA` (`AUP_UTIL_ID`,`AUP_PROG_ID`),
  CONSTRAINT `FK_AFFECT_UTIL_PROGRA_PROGRAMME` FOREIGN KEY (`AUP_PROG_ID`) REFERENCES `PROGRAMME` (`PROG_ID`),
  CONSTRAINT `FK_AFFECT_UTIL_PROGRA_UTILISATEUR` FOREIGN KEY (`AUP_UTIL_ID`) REFERENCES `UTILISATEUR` (`UTIL_ID`)
) ENGINE=INNODB DEFAULT CHARSET=UTF8;

-- LES DONNÉES EXPORTÉES N'ÉTAIENT PAS SÉLECTIONNÉES.

-- LISTAGE DE LA STRUCTURE DE LA TABLE MLR1. COMPOSER_PER_PRO
DROP TABLE IF EXISTS `COMPOSER_PER_PRO`;
CREATE TABLE IF NOT EXISTS `COMPOSER_PER_PRO` (
  `CPP_ID` INT(10) NOT NULL AUTO_INCREMENT,
  `CPP_PROG_ID` INT(10) NOT NULL,
  `CPP_UTIL_ID` INT(10) NOT NULL,
  `CPP_PER_ID` INT(10) NOT NULL,
  `CPP_ORDRE_PER` INT(10) NOT NULL,
  PRIMARY KEY (`CPP_ID`),
  UNIQUE KEY `UNI_CPP_PROG_ID` (`CPP_PROG_ID`,`CPP_UTIL_ID`,`CPP_PER_ID`,`CPP_ORDRE_PER`),
  KEY `I_FK_COMPOSER_PER_PRO_PROGRAMME` (`CPP_PROG_ID`),
  KEY `I_FK_COMPOSER_PER_PRO_UTILISATEUR` (`CPP_UTIL_ID`),
  KEY `I_FK_COMPOSER_PER_PRO_PERIODE` (`CPP_PER_ID`),
  CONSTRAINT `FK_COMPOSER_PER_PRO_PERIODE` FOREIGN KEY (`CPP_PER_ID`) REFERENCES `PERIODE` (`PER_ID`),
  CONSTRAINT `FK_COMPOSER_PER_PRO_PROGRAMME` FOREIGN KEY (`CPP_PROG_ID`) REFERENCES `PROGRAMME` (`PROG_ID`),
  CONSTRAINT `FK_COMPOSER_PER_PRO_UTILISATEUR` FOREIGN KEY (`CPP_UTIL_ID`) REFERENCES `UTILISATEUR` (`UTIL_ID`)
) ENGINE=INNODB DEFAULT CHARSET=UTF8;

-- LES DONNÉES EXPORTÉES N'ÉTAIENT PAS SÉLECTIONNÉES.



-- LES DONNÉES EXPORTÉES N'ÉTAIENT PAS SÉLECTIONNÉES.

-- LISTAGE DE LA STRUCTURE DE LA TABLE MLR1. UTIL_SEANCE

-- LES DONNÉES EXPORTÉES N'ÉTAIENT PAS SÉLECTIONNÉES.

-- LISTAGE DE LA STRUCTURE DE LA TABLE MLR1. BILAN
DROP TABLE IF EXISTS `BILAN`;
CREATE TABLE IF NOT EXISTS `BILAN` (
  `BIL_FCREPOS` FLOAT(32) DEFAULT NULL,
  `BIL_FCCIBLE` FLOAT(32) DEFAULT NULL,
  `BIL_POIDS` FLOAT(32) DEFAULT NULL,
  `BIL_FCMAX` FLOAT(32) DEFAULT NULL,
  `BIL_FC_5MIN_ALLONGE` FLOAT(32) DEFAULT NULL,
  `BIL_FC_30_FLEX` FLOAT(32) DEFAULT NULL,
  `BIL_FC_1_MIN_EXO_ALLONGE` FLOAT(32) DEFAULT NULL,
  `BIL_INDICEDICKSON` FLOAT(32) DEFAULT NULL,
  `BIL_ID` INT(10) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`BIL_ID`)
) ENGINE=INNODB DEFAULT CHARSET=UTF8;

DROP TABLE IF EXISTS `UTIL_SEANCE`;
CREATE TABLE IF NOT EXISTS `UTIL_SEANCE` (
  `UTS_ID` INT(10) NOT NULL AUTO_INCREMENT,
  `UTS_SEA_ID` INT(10) NOT NULL,
  `UTS_PROG_ID` INT(10) NOT NULL,
  `UTS_UTIL_ID` INT(10) NOT NULL,
  `UTS_BIL_ID` INT(10) DEFAULT NULL,
  `UTS_ORDRE` INT(10) DEFAULT NULL,
  `UTS_STATUT` VARCHAR(32) DEFAULT NULL,
  `UTS_EVALUATION` INT(10) DEFAULT NULL,


  PRIMARY KEY (`UTS_ID`),
  KEY `I_FK_UTIL_SEANCE_SEANCE` (`UTS_SEA_ID`),
  KEY `I_FK_UTIL_SEANCE_PROGRAMME` (`UTS_PROG_ID`),
  KEY `I_FK_UTIL_SEANCE_UTILISATEUR` (`UTS_UTIL_ID`),
  KEY `I_FK_UTIL_SEANCE_BILAN` (`UTS_BIL_ID`),
  UNIQUE KEY `UTI_UTS` (`UTS_SEA_ID`,`UTS_PROG_ID`,`UTS_UTIL_ID`,`UTS_ORDRE`),
  CONSTRAINT `FK_UTIL_SEANCE_PROGRAMME` FOREIGN KEY (`UTS_PROG_ID`) REFERENCES `PROGRAMME` (`PROG_ID`),
  CONSTRAINT `FK_UTIL_SEANCE_SEANCE` FOREIGN KEY (`UTS_SEA_ID`) REFERENCES `SEANCE` (`SEA_ID`),
  CONSTRAINT `FK_UTIL_SEANCE_UTILISATEUR` FOREIGN KEY (`UTS_UTIL_ID`) REFERENCES `UTILISATEUR` (`UTIL_ID`),
  CONSTRAINT `FK_UTIL_SEANCE_BILAN` FOREIGN KEY (`UTS_BIL_ID`) REFERENCES `BILAN` (`BIL_ID`)
) ENGINE=INNODB DEFAULT CHARSET=UTF8;

DROP TABLE IF EXISTS `UTIL_SEANCE`;
CREATE TABLE IF NOT EXISTS `UTIL_SEANCE` (
  `UTS_ID` INT(10) NOT NULL AUTO_INCREMENT,
  `UTS_SEA_ID` INT(10) NOT NULL,
  `UTS_PROG_ID` INT(10) NOT NULL,
  `UTS_UTIL_ID` INT(10) NOT NULL,
  `UTS_BIL_ID` INT(10) DEFAULT NULL,
  `UTS_ORDRE` INT(10) DEFAULT NULL,
  `UTS_STATUT` VARCHAR(32) DEFAULT NULL,
  `UTS_EVALUATION` INT(10) DEFAULT NULL,


  PRIMARY KEY (`UTS_ID`),
  KEY `I_FK_UTIL_SEANCE_SEANCE` (`UTS_SEA_ID`),
  KEY `I_FK_UTIL_SEANCE_PROGRAMME` (`UTS_PROG_ID`),
  KEY `I_FK_UTIL_SEANCE_UTILISATEUR` (`UTS_UTIL_ID`),
  KEY `I_FK_UTIL_SEANCE_BILAN` (`UTS_BIL_ID`),
  UNIQUE KEY `UTI_UTS` (`UTS_SEA_ID`,`UTS_PROG_ID`,`UTS_UTIL_ID`,`UTS_ORDRE`),
  CONSTRAINT `FK_UTIL_SEANCE_PROGRAMME` FOREIGN KEY (`UTS_PROG_ID`) REFERENCES `PROGRAMME` (`PROG_ID`),
  CONSTRAINT `FK_UTIL_SEANCE_SEANCE` FOREIGN KEY (`UTS_SEA_ID`) REFERENCES `SEANCE` (`SEA_ID`),
  CONSTRAINT `FK_UTIL_SEANCE_UTILISATEUR` FOREIGN KEY (`UTS_UTIL_ID`) REFERENCES `UTILISATEUR` (`UTIL_ID`),
  CONSTRAINT `FK_UTIL_SEANCE_BILAN` FOREIGN KEY (`UTS_BIL_ID`) REFERENCES `BILAN` (`BIL_ID`)
) ENGINE=INNODB DEFAULT CHARSET=UTF8;


-- LISTAGE DE LA STRUCTURE DE LA TABLE MLR1. EXERCICE
DROP TABLE IF EXISTS `EXERCICE`;
CREATE TABLE IF NOT EXISTS `EXERCICE` (
  `EXE_ID` INT(10) NOT NULL AUTO_INCREMENT,
  `EXE_IMG` VARCHAR(256) DEFAULT NULL,
  `EXE_VIDEO` VARCHAR(32) DEFAULT NULL,
  `EXE_NOM` VARCHAR(50) NOT NULL,
  `EXE_DESCRI` VARCHAR(256) DEFAULT NULL,
  PRIMARY KEY (`EXE_ID`),
  UNIQUE KEY (`EXE_NOM`)
) ENGINE=INNODB DEFAULT CHARSET=UTF8;

-- LES DONNÉES EXPORTÉES N'ÉTAIENT PAS SÉLECTIONNÉES.

-- LISTAGE DE LA STRUCTURE DE LA TABLE MLR1. PROFIL
DROP TABLE IF EXISTS `PROFIL`;
CREATE TABLE IF NOT EXISTS `PROFIL` (
  `PRO_ID` INT(10) NOT NULL AUTO_INCREMENT,
  `PRO_UTIL_ID` INT(10) NOT NULL,
  `PRO_OBJ` VARCHAR(32) DEFAULT NULL,
  `PRO_MES_POITRINE` FLOAT(32) DEFAULT NULL,
  `PRO_MES_TAILLE` FLOAT(32) DEFAULT NULL,
  `PRO_MES_HANCHE` FLOAT(32) DEFAULT NULL,
  `PRO_MES_CUISSEG` FLOAT(32) DEFAULT NULL,
  `PRO_MES_BRASG` FLOAT(32) DEFAULT NULL,
  PRIMARY KEY (`PRO_ID`),
  UNIQUE KEY `I_FK_PROFIL_UTILISATEUR` (`PRO_UTIL_ID`),
  CONSTRAINT `FK_PROFIL_UTILISATEUR` FOREIGN KEY (`PRO_UTIL_ID`) REFERENCES `UTILISATEUR` (`UTIL_ID`)
) ENGINE=INNODB DEFAULT CHARSET=UTF8;

-- LES DONNÉES EXPORTÉES N'ÉTAIENT PAS SÉLECTIONNÉES.


-- LES DONNÉES EXPORTÉES N'ÉTAIENT PAS SÉLECTIONNÉES.

-- LISTAGE DE LA STRUCTURE DE LA TABLE MLR1. NOTIFICATIONS
DROP TABLE IF EXISTS `NOTIFICATIONS`;
CREATE TABLE IF NOT EXISTS `NOTIFICATIONS` (
  `NOT_ID` INT(10) NOT NULL AUTO_INCREMENT,
  `NOT_UTIL_ID_IN` INT(11) NOT NULL,
  `NOT_UTIL_ID_OUT` INT(11) NOT NULL,
  `NOT_MESSAGE` VARCHAR(256) DEFAULT NULL,
  PRIMARY KEY (`NOT_ID`),
  CONSTRAINT `FK_NOTIF_UTILISATEUR_IN` FOREIGN KEY (`NOT_UTIL_ID_IN`) REFERENCES `UTILISATEUR` (`UTIL_ID`),
  CONSTRAINT `FK_NOTIF_UTILISATEUR_OUT` FOREIGN KEY (`NOT_UTIL_ID_OUT`) REFERENCES `UTILISATEUR` (`UTIL_ID`)
) ENGINE=INNODB DEFAULT CHARSET=UTF8;

-- LES DONNÉES EXPORTÉES N'ÉTAIENT PAS SÉLECTIONNÉES.

-- LISTAGE DE LA STRUCTURE DE LA TABLE MLR1. ROLES
DROP TABLE IF EXISTS `ROLES`;
CREATE TABLE IF NOT EXISTS `ROLES` (
  `ROL_ID` INT(11) NOT NULL AUTO_INCREMENT,
  `ROL_UTIL_ID` INT(11) NOT NULL,
  `ROL_NAME` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`ROL_ID`),
  UNIQUE KEY `UNI_UTIL_ROLE` (`ROL_NAME`,`ROL_UTIL_ID`),
  KEY `FK_ROL_UTIL_ID` (`ROL_UTIL_ID`),
  CONSTRAINT `FK_ROL_UTIL_ID` FOREIGN KEY (`ROL_UTIL_ID`) REFERENCES `UTILISATEUR` (`UTIL_ID`)
) ENGINE=INNODB AUTO_INCREMENT=4 DEFAULT CHARSET=UTF8;

-- LES DONNÉES EXPORTÉES N'ÉTAIENT PAS SÉLECTIONNÉES.

-- LISTAGE DE LA STRUCTURE DE LA TABLE MLR1. PROG_SEANCE
DROP TABLE IF EXISTS `PROG_SEANCE`;
CREATE TABLE IF NOT EXISTS `PROG_SEANCE` (
  `PRS_ID` INT(10) NOT NULL AUTO_INCREMENT,
  `PRS_PROG_ID` INT(10) NOT NULL,
  `PRS_SEA_ID` INT(10) NOT NULL,
  `PRS_ORDRE_SEANCE` INT(10) NOT NULL,
  PRIMARY KEY (`PRS_ID`),
  KEY `I_FK_PROG_SEANCE_PROGRAMME` (`PRS_PROG_ID`),
  KEY `I_FK_PROG_SEANCE_SEANCE` (`PRS_SEA_ID`),
  UNIQUE KEY `UNI_PROG_SEANCE` (`PRS_SEA_ID`,`PRS_PROG_ID`,`PRS_ORDRE_SEANCE`),
  CONSTRAINT `FK_PROG_SEANCE_PROGRAMME` FOREIGN KEY (`PRS_PROG_ID`) REFERENCES `PROGRAMME` (`PROG_ID`), 
  CONSTRAINT `FK_PROG_SEANCE_SEANCE` FOREIGN KEY (`PRS_SEA_ID`) REFERENCES `SEANCE` (`SEA_ID`)
) ENGINE=INNODB DEFAULT CHARSET=UTF8;

-- LES DONNÉES EXPORTÉES N'ÉTAIENT PAS SÉLECTIONNÉES.

-- LISTAGE DE LA STRUCTURE DE LA TABLE MLR1. SEANCE_PERIODE
DROP TABLE IF EXISTS `SEANCE_PERIODE`;
CREATE TABLE IF NOT EXISTS `SEANCE_PERIODE` (
  `SPE_ID` INT(10) NOT NULL AUTO_INCREMENT,
  `SPE_PER_ID` INT(10) NOT NULL,
  `SPE_SEA_ID` INT(10) NOT NULL,
  `SPE_ORDRE_SEA` INT(10) NOT NULL,
  PRIMARY KEY (`SPE_ID`),
  UNIQUE KEY  `UNI_SEANCE_PERIODE` (`SPE_PER_ID`,`SPE_SEA_ID`, `SPE_ORDRE_SEA`),
  KEY `I_FK_SEANCE_PERIODE_PERIODE` (`SPE_PER_ID`),
  KEY `I_FK_SEANCE_PERIODE_SEANCE` (`SPE_SEA_ID`),
  CONSTRAINT `FK_SEANCE_PERIODE_PERIODE` FOREIGN KEY (`SPE_PER_ID`) REFERENCES `PERIODE` (`PER_ID`),
  CONSTRAINT `FK_SEANCE_PERIODE_SEANCE` FOREIGN KEY (`SPE_SEA_ID`) REFERENCES `SEANCE` (`SEA_ID`)
) ENGINE=INNODB DEFAULT CHARSET=UTF8;

-- LES DONNÉES EXPORTÉES N'ÉTAIENT PAS SÉLECTIONNÉES.

-- LISTAGE DE LA STRUCTURE DE LA TABLE MLR1. SEANCE_PERIODE
DROP TABLE IF EXISTS `UTIL_EXERCICE`;
CREATE TABLE IF NOT EXISTS `UTIL_EXERCICE` (
  `UEX_ID` INT(10) NOT NULL AUTO_INCREMENT,
  `UEX_PROG_ID` INT(10) NOT NULL,
  `UEX_UTIL_ID` INT(10) NOT NULL,
  `UEX_EXE_ID` INT(10) NOT NULL,
  `UEX_SEA_ID` INT(10) NOT NULL,
  `UEX_ORDRE_SEA` INT(10) NOT NULL,
  `UEX_ORDRE_EXER` INT(10) NOT NULL,
  `UEX_TYPE_EXE` INT(10) NULL,
  `UEX_STATUT` VARCHAR(50) DEFAULT NULL,
  `UEX_NOTE` VARCHAR(10)  NULL,
  `UEX_COMMENTAIRE` VARCHAR(265) NULL,
  PRIMARY KEY (`UEX_ID`),
  UNIQUE KEY  `UNI_UTIL_EXERCICE` (`UEX_PROG_ID`,`UEX_UTIL_ID`,`UEX_EXE_ID`,`UEX_SEA_ID`,`UEX_ORDRE_SEA`,`UEX_ORDRE_EXER`),
  CONSTRAINT `FK_UTIL_PROG` FOREIGN KEY (`UEX_PROG_ID`) REFERENCES `PROGRAMME` (`PROG_ID`),
  CONSTRAINT `FK_UTIL_UTIL` FOREIGN KEY (`UEX_UTIL_ID`) REFERENCES `UTILISATEUR` (`UTIL_ID`),
  CONSTRAINT `FK_UTIL_EXE` FOREIGN KEY (`UEX_EXE_ID`) REFERENCES `EXERCICE` (`EXE_ID`),
  CONSTRAINT `FK_UTIL_SEA` FOREIGN KEY (`UEX_SEA_ID`) REFERENCES `SEANCE` (`SEA_ID`)
) ENGINE=INNODB DEFAULT CHARSET=UTF8;

-- LES DONNÉES EXPORTÉES N'ÉTAIENT PAS SÉLECTIONNÉES.

-- LISTAGE DE LA STRUCTURE DE LA TABLE MLR1. COMPOSER_SEA_EXE
DROP TABLE IF EXISTS `COMPOSER_SEA_EXE`;
CREATE TABLE IF NOT EXISTS `COMPOSER_SEA_EXE` (
  `CSE_ID` INT(10) NOT NULL AUTO_INCREMENT,
  `CSE_EXE_ID` INT(10) NOT NULL,
  `CSE_SEA_ID` INT(10) NOT NULL,
  `CSE_ORDRE_SEANCE` INT(10) NOT NULL,
  `CSE_ORDRE_EXE` INT(10) NOT NULL,
  `CSE_PERF_PRED` INT(10) DEFAULT NULL,
  `CSE_TYPE_EXER` VARCHAR(10) DEFAULT NULL,
  PRIMARY KEY (`CSE_ID`),
  UNIQUE KEY `UNI_COMPOSER_SEA_EXE` (`CSE_EXE_ID`,`CSE_SEA_ID`,`CSE_ORDRE_EXE`,`CSE_ORDRE_SEANCE`),
  KEY `I_FK_COMPOSER_SEA_EXE_EXERCICE` (`CSE_EXE_ID`),
  KEY `I_FK_COMPOSER_SEA_EXE_SEANCE` (`CSE_SEA_ID`),
  CONSTRAINT `FK_COMPOSER_SEA_EXE_EXERCICE` FOREIGN KEY (`CSE_EXE_ID`) REFERENCES `EXERCICE` (`EXE_ID`),
  CONSTRAINT `FK_COMPOSER_SEA_EXE_SEANCE` FOREIGN KEY (`CSE_SEA_ID`) REFERENCES `SEANCE` (`SEA_ID`)
) ENGINE=INNODB DEFAULT CHARSET=UTF8;

-- LISTAGE DE LA STRUCTURE DE LA TABLE MLR1. COMPOSER_SEA_EXE
/*DROP TABLE IF EXISTS `UTILISATEUR_EXERCICE`;
CREATE TABLE IF NOT EXISTS `COMPOSER_SEA_EXE` (
  `UEX_ID` INT(10) NOT NULL,
  `UEX_SEA_ID` INT(10) NOT NULL,
  `UEX_` INT(10) NOT NULL,
  `UEX` INT(10) DEFAULT NULL,
  `UEX` INT(10) DEFAULT NULL,
  PRIMARY KEY (`CSE_EXE_ID`,`CSE_SEA_ID`,`CSE_ORDRE`),
  KEY `I_FK_COMPOSER_SEA_EXE_EXERCICE` (`CSE_EXE_ID`),
  KEY `I_FK_COMPOSER_SEA_EXE_SEANCE` (`CSE_SEA_ID`),
  CONSTRAINT `FK_COMPOSER_SEA_EXE_EXERCICE` FOREIGN KEY (`CSE_EXE_ID`) REFERENCES `EXERCICE` (`EXE_ID`),
  CONSTRAINT `FK_COMPOSER_SEA_EXE_SEANCE` FOREIGN KEY (`CSE_SEA_ID`) REFERENCES `SEANCE` (`SEA_ID`)
) ENGINE=INNODB DEFAULT CHARSET=UTF8;
*/