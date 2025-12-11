package fr.ece.projetlogna.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import java.util.HashMap;

public class HomeController {

    @FXML private Button catalogueButton;

    // Cache des pages déjà chargées
    private final HashMap<String, Parent> pageCache = new HashMap<>();

    @FXML
    public void initialize() {
        // Rien de spécial ici, c’est OK
    }

    @FXML
    private void goToAccount() {
        loadPage("/Views/compte.fxml");
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
            Parent root;

            // Vérifie si déjà en cache
            if (pageCache.containsKey(fxmlPath)) {
                root = pageCache.get(fxmlPath);
            } else {
                FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlPath));
                root = loader.load();
                pageCache.put(fxmlPath, root); // mise en cache
            }

            Stage stage = (Stage) catalogueButton.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();

        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Erreur lors du chargement : " + fxmlPath);
        }
    }
}
