package fr.ece.projetlogna.model;


import java.time.LocalDateTime;

public class LikeLivre {

    private int userId;
    private int livreId;
    private LocalDateTime createdAt;

    public LikeLivre() {}

    public LikeLivre(int userId, int livreId) {
        this.userId = userId;
        this.livreId = livreId;
    }

    // Getters / Setters
}


