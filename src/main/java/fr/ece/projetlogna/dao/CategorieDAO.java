package fr.ece.projetlogna.dao;

import fr.ece.projetlogna.database.Database;
import fr.ece.projetlogna.model.categorie;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CategorieDAO {

    // 👍 CREATE
    public boolean create(categorie categorie) {
        String sql = "INSERT INTO categories (name) VALUES (?)";

        try (Connection conn = Database.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, categorie.getNom());

            return stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("Erreur create categorie : " + e.getMessage());
            return false;
        }
    }

    // 👍 READ (all)
    public List<categorie> findAll() {

        List<categorie> list = new ArrayList<>();
        String sql = "SELECT id, name FROM categories";

        try (Connection conn = Database.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                categorie c = new categorie(
                        rs.getInt("id"),
                        rs.getString("name")
                );
                list.add(c);
            }

        } catch (SQLException e) {
            System.out.println("Erreur findAll categorie : " + e.getMessage());
        }

        return list;
    }

    // 👍 DELETE
    public boolean delete(int id) {

        String sql = "DELETE FROM categories WHERE id = ?";

        try (Connection conn = Database.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);

            return stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("Erreur delete categorie : " + e.getMessage());
            return false;
        }
    }
}
