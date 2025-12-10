package fr.ece.projetlogna.model;

import java.time.LocalDateTime;

public class ForumPost {

    private int id;
    private int userId;
    private Integer livreId;
    private String contenu;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private boolean deleted;

    public ForumPost() {}

    public ForumPost(int userId, Integer livreId, String contenu) {
        this.userId = userId;
        this.livreId = livreId;
        this.contenu = contenu;
    }

    // Getters / Setters

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getUserId() { return userId; }
    public void setUserId(int userId) { this.userId = userId; }

    public Integer getLivreId() { return livreId; }
    public void setLivreId(Integer livreId) { this.livreId = livreId; }

    public String getContenu() { return contenu; }
    public void setContenu(String contenu) { this.contenu = contenu; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }

    public LocalDateTime getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }

    public boolean isDeleted() { return deleted; }
    public void setDeleted(boolean deleted) { this.deleted = deleted; }
}
