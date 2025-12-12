package fr.ece.projetlogna.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
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
        System.out.println("✅ Page Catégories initialisée");
    }

    // ========== NAVIGATION VERS LES CATÉGORIES DE LIVRES ==========

    /**
     * Affiche les livres de la catégorie "Littérature africaine"
     */
    @FXML
    private void showLitteratureAfricaine(ActionEvent event) {
        System.out.println("📚 Affichage des livres : Littérature africaine");
        loadListeLivres(event, "Littérature africaine");
    }

    /**
     * Affiche les livres de la catégorie "Roman"
     */
    @FXML
    private void showRoman(ActionEvent event) {
        System.out.println("📚 Affichage des livres : Roman");
        loadListeLivres(event, "Roman");
    }

    /**
     * Affiche les livres de la catégorie "Développement personnel"
     */
    @FXML
    private void showDeveloppement(ActionEvent event) {
        System.out.println("📚 Affichage des livres : Développement personnel");
        loadListeLivres(event, "Développement personnel");
    }

    /**
     * Affiche les livres de la catégorie "Fantastique et science fiction"
     */
    @FXML
    private void showFantastique(ActionEvent event) {
        System.out.println("📚 Affichage des livres : Fantastique et science fiction");
        loadListeLivres(event, "Fantastique et science fiction");
    }

    /**
     * Affiche les livres de la catégorie "Philosophie"
     */
    @FXML
    private void showPhilosophie(ActionEvent event) {
        System.out.println("📚 Affichage des livres : Philosophie");
        loadListeLivres(event, "Philosophie");
    }

    /**
     * Charge la page des livres et lui passe la catégorie sélectionnée
     * @param event L'événement du bouton cliqué
     * @param categorie Le nom de la catégorie à afficher
     */
    private void loadListeLivres(ActionEvent event, String categorie) {
        try {
            System.out.println("🔍 Chargement de la page livre pour : " + categorie);

            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Views/livre.fxml"));
            Parent root = loader.load();

            // Récupérer le contrôleur de la page livre et lui passer la catégorie
            LivreController controller = loader.getController();
            controller.setCategorie(categorie);

            // Récupérer la fenêtre depuis l'événement
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();

            System.out.println("✅ Page livre chargée avec succès pour : " + categorie);

        } catch (Exception e) {
            System.err.println("❌ Erreur lors du chargement de la liste des livres pour : " + categorie);
            e.printStackTrace();
        }
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
     * Redirige vers la page de compte (compte.fxml)
     */
    @FXML
    private void goToCompte(ActionEvent event) {
        System.out.println("👤 Navigation vers Mon Compte");
        loadPage(event, "/Views/compte.fxml");
    }

    /**
     * Redirige vers la page du forum (forum.fxml)
     */
    @FXML
    private void goToForum(ActionEvent event) {
        System.out.println("💬 Navigation vers Forum");
        loadPage(event, "/Views/forum.fxml");
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
            System.err.println("❌ Erreur lors du chargement de la page : " + fxmlPath);
            e.printStackTrace();
        }
    }
}
