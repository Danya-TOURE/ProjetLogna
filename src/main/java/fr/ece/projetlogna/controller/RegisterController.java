package fr.ece.projetlogna.controller;

import fr.ece.projetlogna.model.User;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

public class RegisterController {

    @FXML
    private TextField usernameField;

    @FXML
    private TextField emailField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private PasswordField confirmPasswordField;

    @FXML
    private ComboBox<String> niveauComboBox;

    @FXML
    private Button registerButton;

    @FXML
    private Hyperlink loginLink;

    @FXML
    private Label errorLabel;

    @FXML
    public void initialize() {
        errorLabel.setText("");

        // Remplir le ComboBox avec les niveaux
        niveauComboBox.getItems().addAll("Débutant", "Intermédiaire", "Avancé", "Expert");
    }

    @FXML
    private void handleRegister() {
        String username = usernameField.getText();
        String email = emailField.getText();
        String password = passwordField.getText();
        String confirmPassword = confirmPasswordField.getText();
        String niveau = niveauComboBox.getValue();

        // Validation des champs
        if (username.isEmpty() || email.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
            errorLabel.setText("Veuillez remplir tous les champs");
            return;
        }

        if (niveau == null) {
            errorLabel.setText("Veuillez sélectionner un niveau");
            return;
        }

        if (!password.equals(confirmPassword)) {
            errorLabel.setText("Les mots de passe ne correspondent pas");
            return;
        }

        if (password.length() < 6) {
            errorLabel.setText("Le mot de passe doit contenir au moins 6 caractères");
            return;
        }

        if (!email.contains("@")) {
            errorLabel.setText("Email invalide");
            return;
        }

        // Créer un nouvel utilisateur
        User newUser = new User();
        newUser.setUsername(username);
        newUser.setEmail(email);
        newUser.setPassword(password);
        newUser.setNiveau(niveau);
        newUser.setRole("user");
        newUser.setLivresLus(0);

        // Enregistrer l'utilisateur
        if (registerUser(newUser)) {
            errorLabel.setStyle("-fx-text-fill: green;");
            errorLabel.setText("Inscription réussie !");
            System.out.println("Utilisateur créé : " + username);
            // Rediriger vers la page de login après inscription
        } else {
            errorLabel.setStyle("-fx-text-fill: red;");
            errorLabel.setText("Erreur lors de l'inscription");
        }
    }

    private boolean registerUser(User user) {
        // TODO: Ajouter la logique pour enregistrer l'utilisateur dans la base de données
        // Exemple temporaire :
        return true;
    }

    @FXML
    private void goToLogin() {
        try {
            // Charger le fichier FXML de login
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Views/login.fxml"));
            Parent root = loader.load();

            // Obtenir la scène actuelle
            Stage stage = (Stage) loginLink.getScene().getWindow();

            // Créer et afficher la nouvelle scène
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();

        } catch (Exception e) {
            e.printStackTrace();
            errorLabel.setText("Erreur lors du chargement de la page");
        }
    }
}