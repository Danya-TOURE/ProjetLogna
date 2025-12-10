package fr.ece.projetlogna.model;

public class livre {
    public class Livre {

        private int id;
        private String titre;
        private String auteur;
        private String description;
        private String lienAchat;
        private int categorieId;

        private Double noteMoyenne;
        private int nombreAvis;

        public Livre() {}

        public Livre(String titre, String auteur, String description, String lienAchat, int categorieId) {
            this.titre = titre;
            this.auteur = auteur;
            this.description = description;
            this.lienAchat = lienAchat;
            this.categorieId = categorieId;
        }

        // Getters et Setters (Alt + Insert pour générer)
    }

}
