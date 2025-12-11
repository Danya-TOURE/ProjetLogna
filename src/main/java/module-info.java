module fr.ece.projetlogna {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens fr.ece.projetlogna to javafx.fxml;
    exports fr.ece.projetlogna;
}