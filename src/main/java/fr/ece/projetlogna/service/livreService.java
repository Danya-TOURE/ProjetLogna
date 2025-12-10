package fr.ece.projetlogna.service;

import fr.ece.projetlogna.dao.AvisDAO;
import fr.ece.projetlogna.dao.LivreDAO;
import fr.ece.projetlogna.model.Livre;
import fr.ece.projetlogna.model.User;

import java.util.List;

public class LivreService {

    private final LivreDAO livreDAO;
    private final AvisDAO avisDAO;

    public LivreService(LivreDAO livreDAO, AvisDAO avisDAO) {
        this.livreDAO = livreDAO;
        this.avisDAO = avisDAO;
    }

    public Livre creerLivre(User user, Livre livre) {
        verifierAdmin(user);
        return livreDAO.save(livre);
    }

    public Livre mettreAJourLivre(User user, Livre livre) {
        verifierAdmin(user);
        return livreDAO.save(livre);
    }

    public void supprimerLivre(User user, int id) {
        verifierAdmin(user);
        livreDAO.deleteById(id);
    }

    public List<Livre> getTousLesLivresAvecStats() {
        var livres = livreDAO.findAll();
        for (Livre l : livres) remplirStats(l);
        return livres;
    }

    public Livre getLivreAvecStats(int id) {
        var livre = livreDAO.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Livre introuvable"));
        remplirStats(livre);
        return livre;
    }

    private void remplirStats(Livre livre) {
        livre.setNoteMoyenne(avisDAO.getMoyennePourLivre(livre.getId()));
        livre.setNombreAvis(avisDAO.countAvisForLivre(livre.getId()));
    }

    private void verifierAdmin(User user) {
        if (user == null || !user.isAdmin())
            throw new SecurityException("Action réservée à l'admin");
    }
}
