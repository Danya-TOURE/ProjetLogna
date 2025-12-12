package fr.ece.projetlogna.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    private static final String URL = "jdbc:mysql://localhost:3306/lognadb";
    private static final String USER = "root"; // Changez si nécessaire
    private static final String PASSWORD = ""; // Mettez votre mot de passe MySQL

    private static Connection connection = null;

    /**
     * Obtient une connexion à la base de données
     */
    public static Connection getConnection() {
        try {
            if (connection == null || connection.isClosed()) {
                Class.forName("com.mysql.cj.jdbc.Driver");
                connection = DriverManager.getConnection(URL, USER, PASSWORD);
                System.out.println("✅ Connexion à la base de données réussie");
            }
        } catch (ClassNotFoundException e) {
            System.err.println("❌ Driver MySQL introuvable");
            e.printStackTrace();
        } catch (SQLException e) {
            System.err.println("❌ Erreur de connexion à la base de données");
            e.printStackTrace();
        }
        return connection;
    }

    /**
     * Ferme la connexion
     */
    public static void closeConnection() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
                System.out.println("✅ Connexion fermée");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}