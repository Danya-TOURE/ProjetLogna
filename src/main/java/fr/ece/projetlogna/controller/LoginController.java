package fr.ece.projetlogna.controller;

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

public class LoginController {

    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Button loginButton;

    @FXML
    private Label errorLabel;

    @FXML
    public void initialize() {
        errorLabel.setText("");
    }

    @FXML
    private void handleLogin() {
        String username = usernameField.getText();
        String password = passwordField.getText();

        // Validation simple
        if (username.isEmpty() || password.isEmpty()) {
            errorLabel.setText("Veuillez remplir tous les champs");
            return;
        }

        // Ici vous ajouterez la logique de vérification avec votre base de données
        // Pour l'instant, un exemple simple :
        if (authenticateUser(username, password)) {
            errorLabel.setText("");
            System.out.println("Connexion réussie pour : " + username);
            // Rediriger vers la page principale
            // loadMainPage();
        } else {
            errorLabel.setText("Nom d'utilisateur ou mot de passe incorrect");
        }
    }

    private boolean authenticateUser(String username, String password) {
        // TODO: Remplacer par votre logique de connexion à la base de données
        // Exemple temporaire :
        return username.equals("admin") && password.equals("admin");
    }

    @FXML
    private void goToRegister() {
        try {
            // Charger le fichier FXML de register
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Views/register.fxml"));
            Parent root = loader.load();

            // Obtenir la scène actuelle
            Stage stage = (Stage) loginButton.getScene().getWindow();

            // Créer et afficher la nouvelle scène
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();

        } catch (Exception e) {
            e.printStackTrace();
            errorLabel.setText("Erreur lors du chargement de la page");
        }
    }

    private void loadMainPage() {
        // TODO: Charger la page principale après connexion réussie
        // try {
        //     FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/main.fxml"));
        //     Parent root = loader.load();
        //     Stage stage = (Stage) loginButton.getScene().getWindow();
        //     Scene scene = new Scene(root);
        //     stage.setScene(scene);
        //     stage.show();
        // } catch (Exception e) {
        //     e.printStackTrace();
        // }
    }
}