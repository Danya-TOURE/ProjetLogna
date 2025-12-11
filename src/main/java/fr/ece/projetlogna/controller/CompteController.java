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
        // Les valeurs par défaut sont déjà dans le FXML
        // Si vous avez un utilisateur connecté, mettez à jour ici
        // loadUserInfo();
    }

    private void loadUserInfo() {
        // TODO: Récupérer l'utilisateur connecté depuis votre système d'authentification
        // Exemple :
        // User currentUser = SessionManager.getCurrentUser();
        // usernameLabel.setText(currentUser.getUsername());
        // emailLabel.setText(currentUser.getEmail());
        // niveauLabel.setText(currentUser.getNiveau());
        // livresLusLabel.setText(currentUser.getLivresLus() + " livres");
    }

    @FXML
    private void editProfile() {
        System.out.println("Modification du profil");
        // TODO: Ouvrir une fenêtre ou page pour modifier le profil
    }

    @FXML
    private void logout() {
        System.out.println("Déconnexion de l'utilisateur");
        // TODO: Nettoyer la session utilisateur
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