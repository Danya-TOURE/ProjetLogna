package fr.ece.projetlogna.controller;

import fr.ece.projetlogna.dao.UserDAO;
import fr.ece.projetlogna.model.User;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.mindrot.jbcrypt.BCrypt;

public class LoginController {

    @FXML private TextField usernameField;
    @FXML private PasswordField passwordField;
    @FXML private Label errorLabel;
    @FXML private Button loginButton;

    private final UserDAO userDAO = new UserDAO();

    @FXML
    private void handleLogin() {
        String username = usernameField.getText();
        String password = passwordField.getText();

        // Réinitialise le style
        errorLabel.setStyle("");
        errorLabel.setText("");

        // Champs vides
        if (username.isEmpty() || password.isEmpty()) {
            setError("Veuillez remplir tous les champs.");
            return;
        }

        User user = userDAO.findByUsername(username);

        if (user == null) {
            setError("Nom d'utilisateur incorrect.");
            return;
        }

        if (!BCrypt.checkpw(password, user.getPasswordHash())) {
            setError("Mot de passe incorrect.");
            return;
        }

        // Succès
        setSuccess("Connexion réussie !");
        loadHomePage();
    }

    private void setError(String msg) {
        errorLabel.setText(msg);
        errorLabel.setStyle("-fx-text-fill: red; -fx-font-weight: bold;");
    }

    private void setSuccess(String msg) {
        errorLabel.setText(msg);
        errorLabel.setStyle("-fx-text-fill: green; -fx-font-weight: bold;");
    }

    @FXML
    private void goToRegister() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Views/register.fxml"));
            Parent root = loader.load();
            Stage stage = (Stage) loginButton.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
            setError("Erreur lors du chargement de la page d'inscription.");
        }
    }

    private void loadHomePage() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Views/home.fxml"));
            Parent root = loader.load();
            Stage stage = (Stage) loginButton.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
            setError("Erreur lors du chargement de la page d'accueil.");
        }
    }
}


