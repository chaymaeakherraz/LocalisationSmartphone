<?php

require_once __DIR__ . '/service/PositionService.php';

if (
    isset($_GET['latitude']) &&
    isset($_GET['longitude']) &&
    isset($_GET['date_position']) &&
    isset($_GET['imei'])
) {
    $position = new Position(
        $_GET['latitude'],
        $_GET['longitude'],
        $_GET['date_position'],
        $_GET['imei']
    );

    $service = new PositionService();
    $service->create($position);

    echo "Position enregistrée avec succès";
} else {
    echo "Paramètres manquants";
}