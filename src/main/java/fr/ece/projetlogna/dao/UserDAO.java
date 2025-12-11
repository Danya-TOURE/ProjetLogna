package fr.ece.projetlogna.dao;

import config.DatabaseConfig;
import fr.ece.correction.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {

    // REGISTER
    public boolean register(User user) {
        String sql = "INSERT INTO user (username, email, password, role, niveau, livres_lus) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, user.getUsername());
            stmt.setString(2, user.getEmail());
            stmt.setString(3, user.getPassword());
            stmt.setString(4, user.getRole());
            stmt.setString(5, user.getNiveau());
            stmt.setInt(6, user.getLivresLus());

            return stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("Erreur register user : " + e.getMessage());
            return false;
        }
    }

    // LOGIN
    public User login(String email, String password) {
        String sql = "SELECT * FROM user WHERE email = ? AND password = ?";

        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, email);
            stmt.setString(2, password);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return extractUser(rs);
            }

        } catch (SQLException e) {
            System.out.println("Erreur login : " + e.getMessage());
        }

        return null;
    }

    // GET ALL
    public List<User> findAll() {
        List<User> list = new ArrayList<>();
        String sql = "SELECT * FROM user";

        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                list.add(extractUser(rs));
            }

        } catch (SQLException e) {
            System.out.println("Erreur findAll : " + e.getMessage());
        }

        return list;
    }

    // GET BY ID
    public User findById(int id) {
        String sql = "SELECT * FROM user WHERE id = ?";

        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return extractUser(rs);
            }

        } catch (SQLException e) {
            System.out.println("Erreur findById : " + e.getMessage());
        }

        return null;
    }

    // UPDATE
    public boolean update(User user) {
        String sql = "UPDATE user SET username = ?, email = ?, role = ?, niveau = ?, livres_lus = ? WHERE id = ?";

        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, user.getUsername());
            stmt.setString(2, user.getEmail());
            stmt.setString(3, user.getRole());
            stmt.setString(4, user.getNiveau());
            stmt.setInt(5, user.getLivresLus());
            stmt.setInt(6, user.getId());

            return stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("Erreur update user : " + e.getMessage());
            return false;
        }
    }

    // DELETE
    public boolean delete(int id) {
        String sql = "DELETE FROM user WHERE id = ?";

        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            return stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("Erreur delete user : " + e.getMessage());
            return false;
        }
    }

    // Convertir un ResultSet -> User
    private User extractUser(ResultSet rs) throws SQLException {
        return new User(
                rs.getInt("id"),
                rs.getString("username"),
                rs.getString("email"),
                rs.getString("password"),
                rs.getString("role"),
                rs.getString("niveau"),
                rs.getInt("livres_lus")
        );
    }
}