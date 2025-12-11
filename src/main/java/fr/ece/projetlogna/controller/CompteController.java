package fr.ece.projetlogna.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class CompteController {

    @FXML
    private Button homeButton;

    @FXML
    private Label usernameLabel;

    @FXML
    private Label emailLabel;

    @FXML
    private Label niveauLabel;

    @FXML
    private Label livresLusLabel;

    @FXML
    private Button editButton;

    @FXML
    private Button logoutButton;

    @FXML
    public void initialize() {
        loadUserInfo();
    }


    /**
     * Méthode qui calcule automatiquement le niveau selon le nombre de livres lus.
     */
    private String calculerNiveau(int livresLus) {

        if (livresLus >= 25) {
            return "Expert ++++";
        } else if (livresLus >= 20) {
            return "Expert";
        } else if (livresLus >= 13) {
            return "Excellent";
        } else if (livresLus >= 6) {
            return "Moyen";
        } else if (livresLus >= 1) {
            return "Débutant";
        } else {
            return "Aucun niveau";
        }
    }


    /**
     * Charge les informations de l'utilisateur dans les labels
     */
    private void loadUserInfo() {

        // TODO : remplacer par ton système pour récupérer l’utilisateur connecté
        // User currentUser = SessionManager.getCurrentUser();

        // 🔽 Exemple temporaire pour test (à remplacer)
        String username = "utilisateur_demo";
        String email = "demo@exemple.com";
        int livresLus = 12; // Mets ici le vrai nombre venant de ta base

        // Calcul du niveau automatiquement
        String niveau = calculerNiveau(livresLus);

        // Mise à jour de l’affichage
        usernameLabel.setText(username);
        emailLabel.setText(email);

        livresLusLabel.setText(livresLus + (livresLus > 1 ? " livres" : " livre"));
        niveauLabel.setText(niveau);
    }


    @FXML
    private void editProfile() {
        System.out.println("Modification du profil");
    }

    @FXML
    private void logout() {
        System.out.println("Déconnexion de l'utilisateur");
        loadPage("/Views/login.fxml");
    }

    @FXML
    private void goToHome() {
        loadPage("/Views/home.fxml");
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

            Stage stage = (Stage) homeButton.getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();

        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Erreur lors du chargement de la page : " + fxmlPath);
        }
    }
}
