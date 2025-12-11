package fr.ece.projetlogna.model;

public class categorie {
    private int id;
    private String name;

    public categorie(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public categorie(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    public String getNom() {
        return name;
    }
}

