package fr.ece.projetlogna.controller;

import fr.ece.projetlogna.dao.UserDAO;
import fr.ece.projetlogna.model.User;
import fr.ece.projetlogna.utils.SecurityUtils;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

public class AuthController {

    @FXML
    private TextField emailField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Label errorLabel;

    private final UserDAO userDAO = new UserDAO();

    @FXML
    public void initialize() {
        errorLabel.setText("");
    }

    @FXML
    private void handleLogin() {

        String email = emailField.getText();
        String password = passwordField.getText();

        // --- Validation simple ---
        if (email.isEmpty() || password.isEmpty()) {
            errorLabel.setText("Veuillez remplir tous les champs.");
            return;
        }

        if (!email.contains("@")) {
            errorLabel.setText("Email invalide.");
            return;
        }

        // Hashage du mot de passe côté Java
        String passwordHash = SecurityUtils.hashPassword(password);

        // ---- Tentative de connexion ----
        User user = userDAO.login(email, passwordHash);

        if (user == null) {
            errorLabel.setText("Email ou mot de passe incorrect.");
            return;
        }

        // ---- Succès ----
        errorLabel.setStyle("-fx-text-fill: green;");
        errorLabel.setText("Connexion réussie ! Bienvenue " + user.getUsername());

        // Redirection après 700ms
        new Thread(() -> {
            try { Thread.sleep(700); } catch (InterruptedException ignored) {}
            javafx.application.Platform.runLater(() -> loadDashboard());
        }).start();
    }

    private void loadDashboard() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Views/dashboard.fxml"));
            Parent root = loader.load();

            Stage stage = (Stage) emailField.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("Tableau de bord");
            stage.show();

        } catch (Exception e) {
            errorLabel.setText("Erreur chargement du dashboard.");
            e.printStackTrace();
        }
    }

    @FXML
    private void goToRegister() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Views/register.fxml"));
            Parent root = loader.load();

            Stage stage = (Stage) emailField.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("Inscription - Lôgna");
            stage.show();

        } catch (Exception e) {
            errorLabel.setText("Erreur chargement de l'inscription.");
            e.printStackTrace();
        }
    }
}

