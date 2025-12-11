package app;

import config.DatabaseConfig;

import java.sql.Connection;

public class TestDB {
    public static void main(String[] args) {

        Connection conn = DatabaseConfig.getConnection();

        if (conn != null) {
            System.out.println("Connexion réussie !");
        } else {
            System.out.println("Échec de la connexion.");
        }
    }
}
