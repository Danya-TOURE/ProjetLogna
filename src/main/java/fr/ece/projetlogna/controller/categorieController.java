package fr.ece.projetlogna.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class CategorieController {

    @FXML
    private TextField searchField;

    @FXML
    private Button accountButton;

    @FXML
    private Button litteratureAfricaineBtn;

    @FXML
    private Button romanBtn;

    @FXML
    private Button developpementBtn;

    @FXML
    private Button fantastiqueBtn;

    @FXML
    private Button philosophieBtn;

    @FXML
    public void initialize() {
        // Initialisation si nécessaire
    }

    @FXML
    private void showLitteratureAfricaine() {
        System.out.println("Affichage des livres : Littérature africaine");
        loadListeLivres("Littérature africaine");
    }

    @FXML
    private void showRoman() {
        System.out.println("Affichage des livres : Roman");
        loadListeLivres("Roman");
    }

    @FXML
    private void showDeveloppement() {
        System.out.println("Affichage des livres : Développement personnel");
        loadListeLivres("Développement personnel");
    }

    @FXML
    private void showFantastique() {
        System.out.println("Affichage des livres : Fantastique et science fiction");
        loadListeLivres("Fantastique et science fiction");
    }

    @FXML
    private void showPhilosophie() {
        System.out.println("Affichage des livres : Philosophie");
        loadListeLivres("Philosophie");
    }

    private void loadListeLivres(String categorie) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Views/livre.fxml"));
            Parent root = loader.load();

            // Passer la catégorie au contrôleur de la page livre
            LivreController controller = loader.getController();
            controller.setcategorieController(categorie);

            Stage stage = (Stage) litteratureAfricaineBtn.getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();

        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Erreur lors du chargement de la liste des livres pour : " + categorie);
        }
    }

    @FXML
    private void goToCompte() {
        loadPage("/Views/compte.fxml");
    }

    @FXML
    private void goToCatalogue() {
        System.out.println("Navigation vers Catalogue");
        // TODO: Créer catalogue.fxml puis décommenter
        // loadPage("/Views/catalogue.fxml");
    }

    @FXML
    private void goToForum() {
        loadPage("/Views/forum.fxml");
    }

    @FXML
    private void goToAvis() {
        System.out.println("Navigation vers Avis");
        // TODO: Créer avis.fxml puis décommenter
        // loadPage("/Views/avis.fxml");
    }

    @FXML
    private void goToUtilisateurs() {
        System.out.println("Navigation vers Utilisateurs");
        // TODO: Créer utilisateurs.fxml puis décommenter
        // loadPage("/Views/utilisateurs.fxml");
    }

    private void loadPage(String fxmlPath) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlPath));
            Parent root = loader.load();

            Stage stage = (Stage) accountButton.getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();

        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Erreur lors du chargement de la page : " + fxmlPath);
        }
    }
}