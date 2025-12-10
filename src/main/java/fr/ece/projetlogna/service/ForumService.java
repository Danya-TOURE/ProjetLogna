package fr.ece.projetlogna.service;

import fr.ece.projetlogna.dao.ForumPostDAO;
import fr.ece.projetlogna.model.ForumPost;
import fr.ece.projetlogna.model.User;

import java.util.List;

public class ForumService {

    private final ForumPostDAO forumPostDAO;

    public ForumService(ForumPostDAO forumPostDAO) {
        this.forumPostDAO = forumPostDAO;
    }

    public ForumPost creerPost(User currentUser, Integer livreId, String contenu) {
        verifierUtilisateurConnecte(currentUser);
        if (contenu == null || contenu.isBlank()) {
            throw new IllegalArgumentException("Le contenu ne peut pas être vide.");
        }

        ForumPost post = new ForumPost(currentUser.getId(), livreId, contenu);
        return forumPostDAO.save(post);
    }

    public ForumPost modifierPost(User currentUser, int postId, String nouveauContenu) {
        ForumPost post = forumPostDAO.findById(postId)
                .orElseThrow(() -> new IllegalArgumentException("Post introuvable"));

        verifierProprietaireOuAdmin(currentUser, post.getUserId());

        post.setContenu(nouveauContenu);
        return forumPostDAO.save(post);
    }

    public void supprimerPost(User currentUser, int postId) {
        ForumPost post = forumPostDAO.findById(postId)
                .orElseThrow(() -> new IllegalArgumentException("Post introuvable"));

        verifierProprietaireOuAdmin(currentUser, post.getUserId());
        forumPostDAO.deleteById(postId);
    }

    public List<ForumPost> getTousLesPosts() {
        return forumPostDAO.findAll();
    }

    public List<ForumPost> getPostsPourLivre(int livreId) {
        return forumPostDAO.findByLivreId(livreId);
    }

    private void verifierUtilisateurConnecte(User currentUser) {
        if (currentUser == null) {
            throw new SecurityException("Vous devez être connecté.");
        }
    }

    private void verifierProprietaireOuAdmin(User currentUser, int ownerId) {
        if (currentUser == null) {
            throw new SecurityException("Vous devez être connecté.");
        }
        boolean estProprietaire = currentUser.getId() == ownerId;
        boolean estAdmin = currentUser.isAdmin();
        if (!estProprietaire && !estAdmin) {
            throw new SecurityException("Action non autorisée.");
        }
    }
}
