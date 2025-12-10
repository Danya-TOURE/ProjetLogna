package fr.ece.projetlogna.service;

import fr.ece.projetlogna.dao.CategorieDAO;
import fr.ece.projetlogna.model.Categorie;
import fr.ece.projetlogna.model.User;

import java.util.List;

public class CategorieService {

    private final CategorieDAO categorieDAO;

    public CategorieService(CategorieDAO categorieDAO) {
        this.categorieDAO = categorieDAO;
    }

    public Categorie creerCategorie(User user, Categorie c) {
        verifierAdmin(user);
        return categorieDAO.save(c);
    }

    public Categorie mettreAJourCategorie(User user, Categorie c) {
        verifierAdmin(user);
        return categorieDAO.save(c);
    }

    public void supprimerCategorie(User user, int id) {
        verifierAdmin(user);
        categorieDAO.deleteById(id);
    }

    public List<Categorie> getToutesCategories() {
        return categorieDAO.findAll();
    }

    private void verifierAdmin(User user) {
        if (!user.isAdmin()) throw new SecurityException("Admin uniquement.");
    }
}

