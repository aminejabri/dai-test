
  DROP DATABASE IF EXISTS MLR1;

  CREATE DATABASE IF NOT EXISTS MLR1;
  USE MLR1;

  # -----------------------------------------------------------------------------
  #       TABLE : UTILISATEUR
  # -----------------------------------------------------------------------------


  CREATE TABLE IF NOT EXISTS UTILISATEUR(
    UTIL_ID int(11) NOT NULL AUTO_INCREMENT,
    UTIL_USERNAME varchar(45) NOT NULL,
    UTIL_EMAIL varchar(100) NOT NULL,
    UTIL_PASSWORD varchar(200) DEFAULT NULL,
    UTIL_NOM VARCHAR(100) NULL  ,
    UTIL_PRENOM VARCHAR(100) NULL  ,
    UTIL_ENABLED tinyint(4) NOT NULL DEFAULT 1,
    UTIL_ACCOUNT_NON_EXPIRED tinyint(1) DEFAULT NULL,
    UTIL_ACCOUNT_NON_LOCKED tinyint(1) DEFAULT NULL,
    UTIL_CREDENTIALS_NON_EXPIRED tinyint(1) DEFAULT NULL,
    UTIL_CERTIFICAT VARCHAR(32) NULL,  
    
    PRIMARY KEY (UTIL_ID),
    UNIQUE KEY UTIL_USERNAME (UTIL_USERNAME),
    UNIQUE KEY UTIL_EMAIL (UTIL_EMAIL)
  ) ;


CREATE TABLE IF NOT EXISTS ROLES (
  ROL_ID int(11) NOT NULL AUTO_INCREMENT,
  ROL_UTIL_ID  int(11) NOT NULL ,
  ROL_NAME varchar(45) NOT NULL,
  PRIMARY KEY (ROL_ID),
  UNIQUE KEY UNI_UTIL_ROLE (ROL_NAME, ROL_UTIL_ID)
) ;


# -----------------------------------------------------------------------------
#       TABLE : PERIODE
# -----------------------------------------------------------------------------

CREATE TABLE IF NOT EXISTS PERIODE
 (
   PER_ID INT(10) NOT NULL AUTO_INCREMENT 
   , PRIMARY KEY (PER_ID) 
 ); 

# -----------------------------------------------------------------------------
#       TABLE : BILAN
# -----------------------------------------------------------------------------

CREATE TABLE IF NOT EXISTS BILAN
 (
   BIL_SEA_ID INT(10) NOT NULL   ,
   BIL_FCREPOS VARCHAR(32) NULL  ,
   BIL_FCCIBLE VARCHAR(32) NULL  ,
   BIL_POIDS VARCHAR(32) NULL  ,
   BIL_FCMAX VARCHAR(32) NULL  ,
   BIL_INDICEDICKSON VARCHAR(32) NULL  ,
   BIL_ID INT(10) NOT NULL AUTO_INCREMENT  
   , PRIMARY KEY (BIL_ID) 
 ) ;

# -----------------------------------------------------------------------------
#       INDEX DE LA TABLE BILAN
# -----------------------------------------------------------------------------


CREATE UNIQUE INDEX I_FK_BILAN_SEANCE
     ON BILAN (BIL_SEA_ID ASC);

# -----------------------------------------------------------------------------
#       TABLE : PROFIL
# -----------------------------------------------------------------------------

CREATE TABLE IF NOT EXISTS PROFIL
 (
   PRO_ID INT(10) NOT NULL AUTO_INCREMENT  ,
   PRO_UTIL_ID INT(10) NOT NULL  ,
   PRO_OBJ VARCHAR(32) NULL  ,
   PRO_MES_POITRINE VARCHAR(32) NULL  ,
   PRO_MES_TAILLE VARCHAR(32) NULL  ,
   PRO_MES_HANCHE VARCHAR(32) NULL  ,
   PRO_MES_CUISSEG VARCHAR(32) NULL  ,
   PRO_MES_BRASG VARCHAR(32) NULL  
   , PRIMARY KEY (PRO_ID) 
 ) ;

# -----------------------------------------------------------------------------
#       INDEX DE LA TABLE PROFIL
# -----------------------------------------------------------------------------


CREATE UNIQUE INDEX I_FK_PROFIL_UTILISATEUR
     ON PROFIL (PRO_UTIL_ID ASC);

# -----------------------------------------------------------------------------
#       TABLE : EXERCICE
# -----------------------------------------------------------------------------

CREATE TABLE IF NOT EXISTS EXERCICE
 (
   EXE_ID INT(10) NOT NULL AUTO_INCREMENT  ,
   EXE_IMG VARCHAR(32) NULL  ,
   EXE_VIDEO VARCHAR(32) NULL  ,
   EXE_DESCRI VARCHAR(32) NULL  
   , PRIMARY KEY (EXE_ID) 
 ) ;

# -----------------------------------------------------------------------------
#       TABLE : PROGRAMME
# -----------------------------------------------------------------------------

CREATE TABLE IF NOT EXISTS PROGRAMME
 (
   PROG_ID INT(10) NOT NULL AUTO_INCREMENT  ,
   PROG_TYPE BOOL NULL  
   , PRIMARY KEY (PROG_ID) 
 ) ;

# -----------------------------------------------------------------------------
#       TABLE : NOTIFICATIONS
# -----------------------------------------------------------------------------

CREATE TABLE IF NOT EXISTS NOTIFICATIONS
 (
   NOT_ID INT(10) NOT NULL AUTO_INCREMENT  
   , PRIMARY KEY (NOT_ID) 
 ) ;

# -----------------------------------------------------------------------------
#       TABLE : SEANCE
# -----------------------------------------------------------------------------

CREATE TABLE IF NOT EXISTS SEANCE
 (
   SEA_ID INT(10) NOT NULL AUTO_INCREMENT  ,
   SEA_TYPE VARCHAR(32) NULL  ,
   SEA_ACTIVE VARCHAR(32) NULL  
   , PRIMARY KEY (SEA_ID) 
 ) ;

# -----------------------------------------------------------------------------
#       TABLE : EVAL_UTIL_SEANCE
# -----------------------------------------------------------------------------

CREATE TABLE IF NOT EXISTS EVAL_UTIL_SEANCE
 (
   ESEA_SEA_ID INT(10) NOT NULL   ,
   ESEA_PROG_ID INT(10) NOT NULL   ,
   ESEA_UTIL_ID INT(10) NOT NULL   ,
   ESEA_ORDRE INT(10) NULL  ,
   ESEA_STATUT VARCHAR(32) NULL  ,
   ESEA_EVALUATION INT(10) NULL 
   , PRIMARY KEY (ESEA_SEA_ID,ESEA_PROG_ID,ESEA_UTIL_ID) 
 ) ;

# -----------------------------------------------------------------------------
#       INDEX DE LA TABLE EVAL_UTIL_SEANCE
# -----------------------------------------------------------------------------


CREATE  INDEX I_FK_EVAL_UTIL_SEANCE_SEANCE
     ON EVAL_UTIL_SEANCE (ESEA_SEA_ID ASC);

CREATE  INDEX I_FK_EVAL_UTIL_SEANCE_PROGRAMME
     ON EVAL_UTIL_SEANCE (ESEA_PROG_ID ASC);

CREATE  INDEX I_FK_EVAL_UTIL_SEANCE_UTILISATEUR
     ON EVAL_UTIL_SEANCE (ESEA_UTIL_ID ASC);

# -----------------------------------------------------------------------------
#       TABLE : RECEVOIR
# -----------------------------------------------------------------------------

CREATE TABLE IF NOT EXISTS RECEVOIR
 (
   REC_NOT_ID INT(10) NOT NULL  ,
   REC_UTIL_ID INT(10) NOT NULL   
   , PRIMARY KEY (REC_NOT_ID,REC_UTIL_ID) 
 ) ;

# -----------------------------------------------------------------------------
#       INDEX DE LA TABLE RECEVOIR
# -----------------------------------------------------------------------------


CREATE  INDEX I_FK_RECEVOIR_NOTIFICATIONS
     ON RECEVOIR (REC_NOT_ID ASC);

CREATE  INDEX I_FK_RECEVOIR_UTILISATEUR
     ON RECEVOIR (REC_UTIL_ID ASC);

# -----------------------------------------------------------------------------
#       TABLE : COMPOSER_PER_PRO
# -----------------------------------------------------------------------------

CREATE TABLE IF NOT EXISTS COMPOSER_PER_PRO
 (
   CPP_PROG_ID INT(10) NOT NULL   ,
   CPP_UTIL_ID INT(10) NOT NULL   ,
   CPP_PER_ID INT(10) NOT NULL   ,
   CPP_ORDREPER INT(10) NOT NULL  
   , PRIMARY KEY (CPP_PROG_ID,CPP_UTIL_ID,CPP_PER_ID,CPP_ORDREPER) 
 ) ;

# -----------------------------------------------------------------------------
#       INDEX DE LA TABLE COMPOSER_PER_PRO
# -----------------------------------------------------------------------------


CREATE  INDEX I_FK_COMPOSER_PER_PRO_PROGRAMME
     ON COMPOSER_PER_PRO (CPP_PROG_ID ASC);

CREATE  INDEX I_FK_COMPOSER_PER_PRO_UTILISATEUR
     ON COMPOSER_PER_PRO (CPP_UTIL_ID ASC);

CREATE  INDEX I_FK_COMPOSER_PER_PRO_PERIODE
     ON COMPOSER_PER_PRO (CPP_PER_ID ASC);

# -----------------------------------------------------------------------------
#       TABLE : APPARTENIR
# -----------------------------------------------------------------------------

CREATE TABLE IF NOT EXISTS APPARTENIR
 (
   APP_PER_ID INT(10) NOT NULL   ,
   APP_SEA_ID INT(10) NOT NULL   ,
   APP_ORDRESEA INT(10)   
   , PRIMARY KEY (APP_PER_ID,APP_SEA_ID) 
 ); 

# -----------------------------------------------------------------------------
#       INDEX DE LA TABLE APPARTENIR
# -----------------------------------------------------------------------------


CREATE  INDEX I_FK_APPARTENIR_PERIODE
     ON APPARTENIR (APP_PER_ID ASC);

CREATE  INDEX I_FK_APPARTENIR_SEANCE
     ON APPARTENIR (APP_SEA_ID ASC);
   
# -----------------------------------------------------------------------------
#       TABLE : PROG_SEANCE
# -----------------------------------------------------------------------------

CREATE TABLE IF NOT EXISTS PROG_SEANCE
 (
   PRS_SEA_ID INT(10) NOT NULL ,
   PRS_PROG_ID INT(10) NOT NULL ,
   PRS_ORDRE_SEANCE INT(10) NOT NULL 
   , PRIMARY KEY (PRS_SEA_ID,PRS_PROG_ID) 
 ) ;

# -----------------------------------------------------------------------------
#       INDEX DE LA TABLE PROG_SEANCE
# -----------------------------------------------------------------------------


CREATE  INDEX I_FK_PROG_SEANCE_PROGRAMME
     ON PROG_SEANCE (PRS_PROG_ID ASC);

CREATE  INDEX I_FK_PROG_SEANCE_SEANCE
     ON PROG_SEANCE (PRS_SEA_ID ASC);

# -----------------------------------------------------------------------------
#       TABLE : AFFECTER
# -----------------------------------------------------------------------------

CREATE TABLE IF NOT EXISTS AFFECTER
 (
   AFF_UTIL_ID INT(10) NOT NULL ,
   AFF_PROG_ID INT(10) NOT NULL  
   , PRIMARY KEY (AFF_UTIL_ID,AFF_PROG_ID) 
 ) ;

# -----------------------------------------------------------------------------
#       INDEX DE LA TABLE AFFECTER
# -----------------------------------------------------------------------------


CREATE  INDEX I_FK_AFFECTER_UTILISATEUR
     ON AFFECTER (AFF_UTIL_ID ASC);

CREATE  INDEX I_FK_AFFECTER_PROGRAMME
     ON AFFECTER (AFF_PROG_ID ASC);

# -----------------------------------------------------------------------------
#       TABLE : COMPOSER_SEA_EXE
# -----------------------------------------------------------------------------

CREATE TABLE IF NOT EXISTS COMPOSER_SEA_EXE
 (
   CSE_EXE_ID INT(10) NOT NULL  ,
   CSE_SEA_ID INT(10) NOT NULL ,
   CSE_ORDRE INT(10) NOT NULL ,
   CSE_CHRONO INT(10)  ,
   CSE_REPETITION INT(10) 
   , PRIMARY KEY (CSE_EXE_ID,CSE_SEA_ID,CSE_ORDRE) 
 ) ;

# -----------------------------------------------------------------------------
#       INDEX DE LA TABLE COMPOSER_SEA_EXE
# -----------------------------------------------------------------------------


CREATE  INDEX I_FK_COMPOSER_SEA_EXE_EXERCICE
     ON COMPOSER_SEA_EXE (CSE_EXE_ID ASC);

CREATE  INDEX I_FK_COMPOSER_SEA_EXE_SEANCE
     ON COMPOSER_SEA_EXE (CSE_SEA_ID ASC);


# -----------------------------------------------------------------------------
#       CREATION DES REFERENCES DE TABLE
# -----------------------------------------------------------------------------


ALTER TABLE BILAN 
  ADD FOREIGN KEY FK_BILAN_SEANCE (BIL_SEA_ID)
      REFERENCES SEANCE (SEA_ID) ;


ALTER TABLE PROFIL 
  ADD FOREIGN KEY FK_PROFIL_UTILISATEUR (PRO_UTIL_ID)
      REFERENCES UTILISATEUR (UTIL_ID) ;


ALTER TABLE EVAL_UTIL_SEANCE 
  ADD FOREIGN KEY FK_EVAL_UTIL_SEANCE_SEANCE (ESEA_SEA_ID)
      REFERENCES SEANCE (SEA_ID) ;


ALTER TABLE EVAL_UTIL_SEANCE 
  ADD FOREIGN KEY FK_EVAL_UTIL_SEANCE_PROGRAMME (ESEA_PROG_ID)
      REFERENCES PROGRAMME (PROG_ID) ;


ALTER TABLE EVAL_UTIL_SEANCE 
  ADD FOREIGN KEY FK_EVAL_UTIL_SEANCE_UTILISATEUR (ESEA_UTIL_ID)
      REFERENCES UTILISATEUR (UTIL_ID) ;


ALTER TABLE RECEVOIR 
  ADD FOREIGN KEY FK_RECEVOIR_NOTIFICATIONS (REC_NOT_ID)
      REFERENCES NOTIFICATIONS (NOT_ID) ;


ALTER TABLE RECEVOIR 
  ADD FOREIGN KEY FK_RECEVOIR_UTILISATEUR (REC_UTIL_ID)
      REFERENCES UTILISATEUR (UTIL_ID) ;


ALTER TABLE COMPOSER_PER_PRO 
  ADD FOREIGN KEY FK_COMPOSER_PER_PRO_PROGRAMME (CPP_PROG_ID)
      REFERENCES PROGRAMME (PROG_ID) ;


ALTER TABLE COMPOSER_PER_PRO 
  ADD FOREIGN KEY FK_COMPOSER_PER_PRO_UTILISATEUR (CPP_UTIL_ID)
      REFERENCES UTILISATEUR (UTIL_ID) ;


ALTER TABLE COMPOSER_PER_PRO 
  ADD FOREIGN KEY FK_COMPOSER_PER_PRO_PERIODE (CPP_PER_ID)
      REFERENCES PERIODE (PER_ID) ;


ALTER TABLE APPARTENIR 
  ADD FOREIGN KEY FK_APPARTENIR_PERIODE (APP_PER_ID)
      REFERENCES PERIODE (PER_ID) ;


ALTER TABLE APPARTENIR 
  ADD FOREIGN KEY FK_APPARTENIR_SEANCE (APP_SEA_ID)
      REFERENCES SEANCE (SEA_ID) ;


ALTER TABLE AFFECTER 
  ADD FOREIGN KEY FK_AFFECTER_UTILISATEUR (AFF_UTIL_ID)
      REFERENCES UTILISATEUR (UTIL_ID) ;


ALTER TABLE AFFECTER 
  ADD FOREIGN KEY FK_AFFECTER_PROGRAMME (AFF_PROG_ID)
      REFERENCES PROGRAMME (PROG_ID) ;


ALTER TABLE COMPOSER_SEA_EXE 
  ADD FOREIGN KEY FK_COMPOSER_SEA_EXE_EXERCICE (CSE_EXE_ID)
      REFERENCES EXERCICE (EXE_ID) ;


ALTER TABLE COMPOSER_SEA_EXE 
  ADD FOREIGN KEY FK_COMPOSER_SEA_EXE_SEANCE (CSE_SEA_ID)
      REFERENCES SEANCE (SEA_ID) ;

ALTER TABLE ROLES 
  ADD FOREIGN KEY FK_ROL_UTIL_ID (ROL_UTIL_ID)
      REFERENCES UTILISATEUR (UTIL_ID) ;
