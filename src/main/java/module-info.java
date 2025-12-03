module fr.ece.projetlogna {
    requires javafx.controls;
    requires javafx.fxml;


    opens fr.ece.projetlogna to javafx.fxml;
    exports fr.ece.projetlogna;
}