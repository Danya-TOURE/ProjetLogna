package fr.ece.projetlogna.controller;

import fr.ece.projetlogna.dao.UserDAO;
import fr.ece.projetlogna.model.User;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import org.mindrot.jbcrypt.BCrypt;

public class RegisterController {

    @FXML private TextField usernameField;
    @FXML private TextField emailField;
    @FXML private PasswordField passwordField;
    @FXML private PasswordField confirmPasswordField;

    @FXML private Hyperlink loginLink;
    @FXML private Label errorLabel;

    private final UserDAO userDAO = new UserDAO();

    @FXML
    public void initialize() {
        errorLabel.setText("");
        errorLabel.setStyle("-fx-text-fill: red;");
    }

    @FXML
    private void handleRegister() {

        String username = usernameField.getText();
        String email = emailField.getText();
        String password = passwordField.getText();
        String confirmPassword = confirmPasswordField.getText();

        // -------------------
        // VALIDATIONS
        // -------------------
        if (username.isEmpty() || email.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
            errorLabel.setText("Veuillez remplir tous les champs");
            return;
        }


        if (!password.equals(confirmPassword)) {
            errorLabel.setText("Les mots de passe ne correspondent pas");
            return;
        }
        if (password.length() < 6) {
            errorLabel.setText("Mot de passe trop court");
            return;
        }
        if (!email.contains("@")) {
            errorLabel.setText("Email invalide");
            return;
        }

        // -------------------
        // HASHAGE PASSWORD (IMPORTANT)
        // -------------------
        String hashedPassword = BCrypt.hashpw(password, BCrypt.gensalt());

        // -------------------
        // CRÉATION DU USER
        // -------------------
        User newUser = new User();
        newUser.setUsername(username);
        newUser.setEmail(email);
        newUser.setPasswordHash(hashedPassword);
        newUser.setNiveau("Débutant");
        newUser.setRole("user");
        newUser.setLivresLus(0);

        // -------------------
        // ENREGISTREMENT
        // -------------------
        if (userDAO.register(newUser)) {   // <<< ICI LE FIX !
            errorLabel.setStyle("-fx-text-fill: green;");
            errorLabel.setText("Inscription réussie !");

            System.out.println("Utilisateur créé : " + username);

            // redirection après 1 seconde
            new Thread(() -> {
                try { Thread.sleep(1000); } catch (Exception ignored) {}
                javafx.application.Platform.runLater(this::goToLogin);
            }).start();

        } else {
            errorLabel.setStyle("-fx-text-fill: red;");
            errorLabel.setText("Erreur lors de l'inscription");
        }
    }

    @FXML
    private void goToLogin() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Views/login.fxml"));
            Parent root = loader.load();
            Stage stage = (Stage) loginLink.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
            errorLabel.setText("Erreur chargement login");
        }
    }
}
