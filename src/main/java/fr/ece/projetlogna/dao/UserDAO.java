package fr.ece.projetlogna.dao;

import fr.ece.projetlogna.database.Database;
import fr.ece.projetlogna.model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {

    // --------------------------- //
    // CREATE (Register)
    // --------------------------- //
    public boolean register(User user) {

        // ⚠️ IMPORTANT : niveau et livres_lus ont des valeurs par défaut dans MySQL !
        String sql = "INSERT INTO users (username, email, password_hash, role) VALUES (?, ?, ?, ?)";

        try (Connection conn = Database.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, user.getUsername());
            stmt.setString(2, user.getEmail());
            stmt.setString(3, user.getPasswordHash());
            stmt.setString(4, user.getRole()); // ex: "user"

            return stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("❌ Erreur register user : " + e.getMessage());
            return false;
        }
    }


    // --------------------------- //
    // LOGIN
    // --------------------------- //
    public User login(String email, String passwordHash) {
        String sql = "SELECT * FROM users WHERE email = ? AND password_hash = ?";

        try (Connection conn = Database.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, email);
            stmt.setString(2, passwordHash);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return extractUser(rs);
            }

        } catch (SQLException e) {
            System.out.println("❌ Erreur login : " + e.getMessage());
        }

        return null;
    }


    // --------------------------- //
    // FIND ALL
    // --------------------------- //
    public List<User> findAll() {
        List<User> users = new ArrayList<>();
        String sql = "SELECT * FROM users";

        try (Connection conn = Database.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                users.add(extractUser(rs));
            }

        } catch (SQLException e) {
            System.out.println("❌ Erreur findAll : " + e.getMessage());
        }

        return users;
    }


    // --------------------------- //
    // FIND BY username
    // --------------------------- //
    public User findByUsername(String username) {
        String sql = "SELECT * FROM users WHERE username = ?";

        try (Connection conn = Database.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, username);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return extractUser(rs);
            }

        } catch (SQLException e) {
            System.out.println("❌ Erreur findByUsername : " + e.getMessage());
        }

        return null;
    }




    // --------------------------- //
    // UPDATE
    // --------------------------- //
    public boolean update(User user) {
        String sql = "UPDATE users SET username = ?, email = ?, role = ?, niveau = ?, livres_lus = ? WHERE id = ?";

        try (Connection conn = Database.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, user.getUsername());
            stmt.setString(2, user.getEmail());
            stmt.setString(3, user.getRole());
            stmt.setString(4, user.getNiveau());
            stmt.setInt(5, user.getLivresLus());
            stmt.setInt(6, user.getId());

            return stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("❌ Erreur update user : " + e.getMessage());
            return false;
        }
    }


    // --------------------------- //
    // DELETE
    // --------------------------- //
    public boolean delete(int id) {
        String sql = "DELETE FROM users WHERE id = ?";

        try (Connection conn = Database.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            return stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("❌ Erreur delete user : " + e.getMessage());
            return false;
        }
    }


    // --------------------------- //
    // METHODE UTILITAIRE
    // --------------------------- //
    private User extractUser(ResultSet rs) throws SQLException {
        return new User(
                rs.getInt("id"),
                rs.getString("username"),
                rs.getString("email"),
                rs.getString("password_hash"),
                rs.getString("role"),
                rs.getString("niveau"),
                rs.getInt("livres_lus")
        );
    }
}


