package fr.ece.projetlogna.service;

import fr.ece.projetlogna.dao.AvisDAO;
import fr.ece.projetlogna.model.Avis;
import fr.ece.projetlogna.model.User;

import java.util.List;

public class AvisService {

    private final AvisDAO avisDAO;

    public AvisService(AvisDAO avisDAO) {
        this.avisDAO = avisDAO;
    }

    public Avis creerAvis(User user, int livreId, int note, String commentaire) {
        verifierConnecte(user);
        verifierNote(note);

        Avis avis = new Avis(user.getId(), livreId, note, commentaire);
        return avisDAO.save(avis);
    }

    public Avis modifierAvis(User user, int avisId, int note, String commentaire) {
        verifierNote(note);

        Avis avis = avisDAO.findById(avisId)
                .orElseThrow(() -> new IllegalArgumentException("Avis introuvable"));

        verifierProprietaireOuAdmin(user, avis.getUserId());

        avis.setNote(note);
        avis.setCommentaire(commentaire);
        return avisDAO.save(avis);
    }

    public void supprimerAvis(User user, int avisId) {
        Avis avis = avisDAO.findById(avisId)
                .orElseThrow(() -> new IllegalArgumentException("Avis introuvable"));

        verifierProprietaireOuAdmin(user, avis.getUserId());
        avisDAO.deleteById(avisId);
    }

    public List<Avis> getAvisPourLivre(int livreId) {
        return avisDAO.findByLivreId(livreId);
    }

    private void verifierNote(int note) {
        if (note < 1 || note > 5) throw new IllegalArgumentException("Note 1 à 5.");
    }

    private void verifierConnecte(User user) {
        if (user == null) throw new SecurityException("Non connecté.");
    }

    private void verifierProprietaireOuAdmin(User u, int owner) {
        if (u.getId() != owner && !u.isAdmin())
            throw new SecurityException("Non autorisé.");
    }
}
{
}
