package fr.ece.projetlogna.model;

public class Livre {

    private int id;
    private String titre;
    private int categoryId;

    public Livre() {
    }

    public Livre(int id, String titre, int categoryId) {
        this.id = id;
        this.titre = titre;
        this.categoryId = categoryId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }
}


