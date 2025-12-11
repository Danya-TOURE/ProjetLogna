package fr.ece.projetlogna.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class HomeController {

    @FXML
    private TextField searchField;

    @FXML
    private Button accountButton;

    @FXML
    private Button catalogueButton;

    @FXML
    private Button categoriesButton;

    @FXML
    private Button forumButton;

    @FXML
    private Button avisButton;

    @FXML
    private Button utilisateursButton;

    @FXML
    private Button voirCatalogueButton;

    @FXML
    private Button parcourirCategorieButton;

    @FXML
    public void initialize() {
        // Initialisation si nécessaire
    }

    @FXML
    private void goToAccount() {
        loadPage("/Views/compte.fxml");
    }

    @FXML
    private void goToCategories() {
        loadPage("/Views/categories.fxml");
    }

    @FXML
    private void goToForum() {
        loadPage("/Views/forum.fxml");
    }


    private void loadPage(String fxmlPath) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlPath));
            Parent root = loader.load();

            Stage stage = (Stage) catalogueButton.getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();

        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Erreur lors du chargement de la page : " + fxmlPath);
        }
    }
}