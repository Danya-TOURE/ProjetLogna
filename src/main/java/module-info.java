module fr.ece.projetlogna {

    // JavaFX
    requires javafx.controls;
    requires javafx.fxml;
    requires jbcrypt; // ← AJOUT IMPORTANT


    // JDBC ( MySQL utilise java.sql )
    requires java.sql;

    // Le driver MySQL 8 (nom EXACT du module)
    requires mysql.connector.j;

    // ======= PACKAGES ACCESSIBLES À JAVAFX =======

    // Ton MainApp est dans le package "app"
    opens app to javafx.graphics, javafx.fxml;
    exports app;

    // Controllers JavaFX
    opens fr.ece.projetlogna.controller to javafx.fxml;
    exports fr.ece.projetlogna.controller;

    // Modèles (si utilisés dans FXML)
    opens fr.ece.projetlogna.model to javafx.fxml;
    exports fr.ece.projetlogna.model;

    // DAO (pas forcément nécessaire)
    opens fr.ece.projetlogna.dao;
    exports fr.ece.projetlogna.dao;

    // Base de données
    opens fr.ece.projetlogna.database to javafx.fxml;
    exports fr.ece.projetlogna.database;
}

