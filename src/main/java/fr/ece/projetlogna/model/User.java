package fr.ece.projetlogna.model;

public class User {

    private int id;
    private String username;
    private String email;
    private String passwordHash; // IMPORTANT : correspond à password_hash en BDD
    private String role;
    private String niveau;
    private int livresLus;

    public User() {}

    public User(int id, String username, String email, String passwordHash,
                String role, String niveau, int livresLus) {

        this.id = id;
        this.username = username;
        this.email = email;
        this.passwordHash = passwordHash;
        this.role = role;
        this.niveau = niveau;
        this.livresLus = livresLus;
    }

    // ----------- Getters / Setters -------------

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getPasswordHash() {
        return passwordHash;
    }
    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public String getRole() {
        return role;
    }
    public void setRole(String role) {
        this.role = role;
    }

    public String getNiveau() {
        return niveau;
    }
    public void setNiveau(String niveau) {
        this.niveau = niveau;
    }

    public int getLivresLus() {
        return livresLus;
    }
    public void setLivresLus(int livresLus) {
        this.livresLus = livresLus;
    }

    public void setPassword(String password) {
        this.passwordHash = password;
    }

}
