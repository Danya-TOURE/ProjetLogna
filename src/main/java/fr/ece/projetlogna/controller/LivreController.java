package fr.ece.projetlogna.controller;

import fr.ece.projetlogna.database.DatabaseConnection;
import fr.ece.projetlogna.model.Livre;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class LivreController {

    @FXML
    private Label categorieLabel;

    @FXML
    private VBox livresContainer;

    @FXML
    private ScrollPane scrollPane;

    private String categorieActuelle;

    @FXML
    public void initialize() {
        System.out.println("✅ LivreController initialisé");
        // Configuration du ScrollPane
        if (scrollPane != null) {
            scrollPane.setFitToWidth(true);
        }
    }

    /**
     * Définit la catégorie et charge les livres correspondants
     */
    public void setCategorie(String categorie) {
        this.categorieActuelle = categorie;
        categorieLabel.setText(categorie);
        chargerLivres(categorie);
    }

    /**
     * Charge les livres de la catégorie depuis la base de données
     */
    private void chargerLivres(String categorie) {
        List<Livre> livres = getLivresParCategorie(categorie);

        // Vider le conteneur
        livresContainer.getChildren().clear();

        if (livres.isEmpty()) {
            Label noBooks = new Label("Aucun livre disponible dans cette catégorie");
            noBooks.setStyle("-fx-font-size: 16; -fx-text-fill: #666;");
            livresContainer.getChildren().add(noBooks);
        } else {
            System.out.println("📚 Affichage de " + livres.size() + " livre(s)");
            // Afficher chaque livre
            for (Livre livre : livres) {
                livresContainer.getChildren().add(creerCarteLivre(livre));
            }
        }
    }

    /**
     * Récupère les livres depuis la base de données selon la catégorie
     */
    private List<Livre> getLivresParCategorie(String categorie) {
        List<Livre> livres = new ArrayList<>();

        String query = "SELECT id, titre, auteur, description, categorie FROM books WHERE categorie = ? ORDER BY titre";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, categorie);

            System.out.println("🔍 Requête SQL : " + query);
            System.out.println("🔍 Catégorie recherchée : " + categorie);

            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Livre livre = new Livre(
                            rs.getInt("id"),
                            rs.getString("titre"),
                            rs.getString("auteur"),
                            rs.getString("description"),
                            rs.getString("categorie")
                    );
                    livres.add(livre);
                }
            }

            System.out.println("✅ " + livres.size() + " livre(s) chargé(s) pour la catégorie : " + categorie);

        } catch (Exception e) {
            System.err.println("❌ Erreur lors du chargement des livres pour : " + categorie);
            e.printStackTrace();
        }

        return livres;
    }

    /**
     * Crée une carte visuelle pour un livre
     */
    private VBox creerCarteLivre(Livre livre) {
        VBox carte = new VBox(15);
        carte.setAlignment(Pos.TOP_LEFT);
        carte.setStyle("-fx-background-color: white; " +
                "-fx-background-radius: 15; " +
                "-fx-padding: 25; " +
                "-fx-effect: dropshadow(gaussian, rgba(0,0,0,0.1), 10, 0, 0, 2);");
        carte.setPrefWidth(650);

        // Titre du livre
        Label titre = new Label(livre.getTitre());
        titre.setStyle("-fx-font-size: 22; -fx-font-weight: bold; -fx-text-fill: #3B1414;");
        titre.setWrapText(true);

        // Auteur
        Label auteur = new Label("Par " + livre.getAuteur());
        auteur.setStyle("-fx-font-size: 16; -fx-font-style: italic; -fx-text-fill: #666;");

        // Description
        Label description = new Label(livre.getDescription());
        description.setStyle("-fx-font-size: 14; -fx-text-fill: #444;");
        description.setWrapText(true);
        description.setMaxWidth(600);

        // Boutons d'action
        HBox boutons = new HBox(15);
        boutons.setAlignment(Pos.CENTER_LEFT);

        Button lireBtn = new Button("📖 Lire");
        lireBtn.setStyle("-fx-background-color: #8B2929; " +
                "-fx-text-fill: white; " +
                "-fx-font-size: 14; " +
                "-fx-font-weight: bold; " +
                "-fx-padding: 10 20; " +
                "-fx-background-radius: 8; " +
                "-fx-cursor: hand;");
        lireBtn.setOnAction(e -> lireLivre(livre));

        Button detailsBtn = new Button("ℹ️ Détails");
        detailsBtn.setStyle("-fx-background-color: transparent; " +
                "-fx-border-color: #8B2929; " +
                "-fx-border-width: 2; " +
                "-fx-border-radius: 8; " +
                "-fx-text-fill: #8B2929; " +
                "-fx-font-size: 14; " +
                "-fx-font-weight: bold; " +
                "-fx-padding: 10 20; " +
                "-fx-background-radius: 8; " +
                "-fx-cursor: hand;");
        detailsBtn.setOnAction(e -> afficherDetails(livre));

        boutons.getChildren().addAll(lireBtn, detailsBtn);

        carte.getChildren().addAll(titre, auteur, description, boutons);
        return carte;
    }

    /**
     * Action pour lire un livre
     */
    private void lireLivre(Livre livre) {
        System.out.println("📖 Ouverture du livre : " + livre.getTitre());
        // TODO: Implémenter l'ouverture du lecteur de livre
    }

    /**
     * Action pour afficher les détails d'un livre
     */
    private void afficherDetails(Livre livre) {
        System.out.println("ℹ️ Affichage des détails de : " + livre.getTitre());
        // TODO: Implémenter la page de détails du livre
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
     * Redirige vers la page des catégories (categorie.fxml)
     */
    @FXML
    private void goToCategories(ActionEvent event) {
        System.out.println("📚 Navigation vers Catégories");
        loadPage(event, "/Views/categorie.fxml");
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
     * Redirige vers la page de compte (compte.fxml)
     */
    @FXML
    private void goToCompte(ActionEvent event) {
        System.out.println("👤 Navigation vers Mon Compte");
        loadPage(event, "/Views/compte.fxml");
    }

    /**
     * Méthode générique pour charger une page FXML
     */
    private void loadPage(ActionEvent event, String fxmlPath) {
        try {
            System.out.println("🔍 Chargement de : " + fxmlPath);

            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlPath));
            Parent root = loader.load();

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();

            System.out.println("✅ Page chargée avec succès");

        } catch (Exception e) {
            System.err.println("❌ Erreur lors du chargement : " + fxmlPath);
            e.printStackTrace();
        }
    }
}