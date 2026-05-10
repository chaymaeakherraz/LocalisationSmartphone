<?php

class Connexion {
    private $connexion;

    public function __construct() {
        $this->connexion = new PDO(
            "mysql:host=localhost;dbname=localisation;charset=utf8mb4",
            "root",
            ""
        );

        $this->connexion->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
    }

    public function getConnexion() {
        return $this->connexion;
    }
}