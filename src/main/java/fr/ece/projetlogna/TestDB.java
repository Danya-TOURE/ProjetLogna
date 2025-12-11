package fr.ece.projetlogna;

import fr.ece.projetlogna.database.Database;

import java.sql.Connection;

public class TestDB {

    public static void main(String[] args) {

        Connection conn = Database.getConnection();

        if (conn != null) {
            System.out.println("🔥 Test réussi : connexion établie !");
        } else {
            System.out.println("❌ Test échoué : aucune connexion.");
        }
    }
}

