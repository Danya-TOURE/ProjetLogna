module fr.ece.projetlogna {
    requires javafx.controls;
    requires javafx.fxml;

    requires java.sql;  // ← obligatoire pour utiliser Connection, DriverManager, etc.

    opens fr.ece.projetlogna to javafx.fxml;
    exports fr.ece.projetlogna;
}
