# LAB 11 – Application Android de Localisation GPS avec PHP/MySQL

## Description

Ce projet consiste à développer une application Android permettant de récupérer la position GPS d’un smartphone puis d’envoyer les coordonnées géographiques vers une base de données MySQL via un service PHP.

---

## Fonctionnalités

- Détection de la position GPS
- Affichage de la latitude et longitude
- Envoi des coordonnées vers un serveur PHP
- Stockage des données dans MySQL

---

## Technologies utilisées

### Mobile
- Android Studio
- Java
- XML

### Back-End
- PHP
- MySQL

### Serveur
- XAMPP

---

## Structure du projet

```bash
localisation/
│
├── classe/
│   └── Position.php
│
├── connexion/
│   └── Connexion.php
│
├── service/
│   └── PositionService.php
│
├── createPosition.php
│
└── Base MySQL
```
##Base de données
CREATE DATABASE localisation;

USE localisation;

CREATE TABLE position (
    id INT AUTO_INCREMENT PRIMARY KEY,
    latitude DOUBLE NOT NULL,
    longitude DOUBLE NOT NULL,
    date_position DATETIME NOT NULL,
    imei VARCHAR(50) NOT NULL
);

##Résultat
Position GPS détectée
Communication Android ↔ PHP réussie
Données enregistrées dans MySQL

##Conclusion

Ce laboratoire nous a permis de comprendre la géolocalisation Android ainsi que la communication entre une application mobile et une base de données MySQL via PHP.

<img width="447" height="796" alt="image" src="https://github.com/user-attachments/assets/96212769-2369-4747-8d3d-c92d3784d256" />

<img width="1908" height="752" alt="image" src="https://github.com/user-attachments/assets/b0b648d5-ea40-4927-80e8-7400365c8d03" />

https://github.com/user-attachments/assets/4d473e94-9ca7-46dd-905a-dfbe5bf0ae11

