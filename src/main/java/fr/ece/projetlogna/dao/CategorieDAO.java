package fr.ece.projetlogna.dao;

import fr.ece.correction.config.DatabaseConfig;
import fr.ece.correction.model.Categorie;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategorieDAO {

    public boolean create(Categorie categorie) {
        String sql = "INSERT INTO categorie (nom) VALUES (?)";

        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, categorie.getNom());
            return stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("Erreur create categorie : " + e.getMessage());
            return false;
        }
    }

    public List<Categorie> findAll() {
        List<Categorie> list = new ArrayList<>();
        String sql = "SELECT * FROM categorie";

        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                list.add(new Categorie(
                        rs.getInt("id"),
                        rs.getString("nom")
                ));
            }

        } catch (SQLException e) {
            System.out.println("Erreur findAll categorie : " + e.getMessage());
        }

        return list;
    }

    public boolean delete(int id) {
        String sql = "DELETE FROM categorie WHERE id = ?";

        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            return stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("Erreur delete categorie : " + e.getMessage());
            return false;
        }
    }
}
