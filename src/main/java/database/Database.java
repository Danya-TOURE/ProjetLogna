package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {

    // ⚠️ Mets ici le nom de ta base
    private static final String URL = "jdbc:mysql://localhost:3306/lognadb?useSSL=false&serverTimezone=UTC";

    // ⚠️ Identifiants WampServer
    private static final String USER = "root";
    private static final String PASSWORD = "";

    // Méthode de connexion
    public static Connection getConnection() {
        try {
            Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Connexion MySQL OK ✔️");
            return conn;
        } catch (SQLException e) {
            System.out.println("❌ Erreur connexion MySQL : " + e.getMessage());
            return null;
        }
    }
}

