package fr.ece.projetlogna.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.util.HashMap;

public class HomeController {

    // Cache des pages déjà chargées
    private final HashMap<String, Parent> pageCache = new HashMap<>();

    @FXML
    public void initialize() {
        // Rien de spécial ici
    }

    @FXML
    private void goToAccount(ActionEvent event) {
        loadPage(event, "/Views/compte.fxml");
    }

    @FXML
    private void goToCategories(ActionEvent event) {
        loadPage(event, "/Views/categorie.fxml");
    }

    @FXML
    private void goToForum(ActionEvent event) {
        loadPage(event, "/Views/forum.fxml");
    }

    private void loadPage(ActionEvent event, String fxmlPath) {
        try {
            System.out.println("Tentative de chargement : " + fxmlPath);
            System.out.println("URL trouvée : " + getClass().getResource(fxmlPath));

            Parent root;

            // Vérifie si déjà en cache
            if (pageCache.containsKey(fxmlPath)) {
                root = pageCache.get(fxmlPath);
            } else {
                FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlPath));
                root = loader.load();
                pageCache.put(fxmlPath, root); // mise en cache
            }

            // Récupérer la fenêtre depuis l'événement du bouton cliqué
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();

            System.out.println("✅ Page chargée avec succès");

        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("❌ Erreur lors du chargement : " + fxmlPath);
        }
    }
}