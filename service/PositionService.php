<?php

require_once __DIR__ . '/../connexion/Connexion.php';
require_once __DIR__ . '/../classe/Position.php';

class PositionService {
    private $connexion;

    public function __construct() {
        $this->connexion = new Connexion();
    }

    public function create(Position $position) {
        $sql = "INSERT INTO position (latitude, longitude, date_position, imei)
                VALUES (:latitude, :longitude, :date_position, :imei)";

        $stmt = $this->connexion->getConnexion()->prepare($sql);

        $stmt->execute([
            "latitude" => $position->getLatitude(),
            "longitude" => $position->getLongitude(),
            "date_position" => $position->getDatePosition(),
            "imei" => $position->getImei()
        ]);
    }
}