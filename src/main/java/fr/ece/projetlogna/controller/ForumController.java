package fr.ece.projetlogna.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ForumController {

    @FXML
    public void initialize() {
        System.out.println("✅ ForumController initialisé");
    }

    // ========== NAVIGATION VERS LES AUTRES PAGES ==========

    /**
     * Redirige vers la page d'accueil (home.fxml)
     */
    @FXML
    private void goToHome(ActionEvent event) {
        System.out.println("🏠 Navigation vers Accueil");
        loadPage(event, "/Views/home.fxml");
    }

    /**
     * Redirige vers la page des catégories (categorie.fxml)
     */
    @FXML
    private void goToCategories(ActionEvent event) {
        System.out.println("📚 Navigation vers Catégories");
        loadPage(event, "/Views/categorie.fxml");
    }

    /**
     * Redirige vers la page de compte (compte.fxml)
     */
    @FXML
    private void goToCompte(ActionEvent event) {
        System.out.println("👤 Navigation vers Mon Compte");
        loadPage(event, "/Views/compte.fxml");
    }

    /**
     * Méthode générique pour charger une page FXML
     * @param event L'événement déclenché par le bouton cliqué
     * @param fxmlPath Le chemin vers le fichier FXML à charger
     */
    private void loadPage(ActionEvent event, String fxmlPath) {
        try {
            System.out.println("🔍 Chargement de : " + fxmlPath);

            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlPath));
            Parent root = loader.load();

            // Récupérer la fenêtre depuis l'événement du bouton cliqué
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();

            System.out.println("✅ Page chargée avec succès");

        } catch (Exception e) {
            System.err.println("❌ Erreur lors du chargement : " + fxmlPath);
            e.printStackTrace();
        }
    }
}