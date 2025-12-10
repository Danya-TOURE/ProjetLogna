package fr.ece.projetlogna.model;

import java.time.LocalDateTime;

    public class Avis {

        private int id;
        private int userId;
        private int livreId;
        private int note;
        private String commentaire;
        private LocalDateTime createdAt;
        private LocalDateTime updatedAt;

        public Avis() {}

        public Avis(int userId, int livreId, int note, String commentaire) {
            this.userId = userId;
            this.livreId = livreId;
            this.note = note;
            this.commentaire = commentaire;
        }

        // Getters / Setters
    }


