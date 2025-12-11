package fr.ece.projetlogna.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class LivreController {

    private String categorie;  // La catégorie reçue depuis CategorieController

    @FXML
    private Label labelCategorie; // optionnel si tu veux l'afficher dans le FXML

    // Méthode appelée depuis CategorieController
    public void setCategorie(String categorie) {
        this.categorie = categorie;
        System.out.println("Catégorie reçue : " + categorie);

        if (labelCategorie != null) {
            labelCategorie.setText("Catégorie : " + categorie);
        }

        // 👉 Ici tu pourras charger les livres depuis ta base MySQL selon la catégorie
        //    Exemple : chargerLivresParCategorie(categorie);
    }

    @FXML
    public void initialize() {
        // Initialisation FXML si nécessaire
    }
}
