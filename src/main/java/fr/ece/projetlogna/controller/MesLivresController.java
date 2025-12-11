package fr.ece.projetlogna.controller;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class MesLivresController {

    @FXML private TableView<?> tableMesLivres;
    @FXML private TableColumn<?, ?> colTitre;
    @FXML private TableColumn<?, ?> colAuteur;
    @FXML private TableColumn<?, ?> colProgression;
    @FXML private TableColumn<?, ?> colActions;

    @FXML
    public void initialize() {
        System.out.println("Mes Livres chargés !");
    }

}