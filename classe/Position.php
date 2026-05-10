<?php

class Position {
    private $latitude;
    private $longitude;
    private $datePosition;
    private $imei;

    public function __construct($latitude, $longitude, $datePosition, $imei) {
        $this->latitude = $latitude;
        $this->longitude = $longitude;
        $this->datePosition = $datePosition;
        $this->imei = $imei;
    }

    public function getLatitude() {
        return $this->latitude;
    }

    public function getLongitude() {
        return $this->longitude;
    }

    public function getDatePosition() {
        return $this->datePosition;
    }

    public function getImei() {
        return $this->imei;
    }
}