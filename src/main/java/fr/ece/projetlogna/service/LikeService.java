package fr.ece.projetlogna.service;

import fr.ece.projetlogna.dao.LikeLivreDAO;
import fr.ece.projetlogna.model.User;

public class LikeService {

    private final LikeLivreDAO likeLivreDAO;

    public LikeService(LikeLivreDAO likeLivreDAO) {
        this.likeLivreDAO = likeLivreDAO;
    }

    /**
     * Si l'utilisateur a déjà liké le livre -> on enlève le like.
     * Sinon -> on ajoute le like.
     * @return true si le livre est liké après l'appel, false sinon.
     */
    public boolean toggleLike(User currentUser, int livreId) {
        if (currentUser == null) {
            throw new SecurityException("Vous devez être connecté pour liker un livre.");
        }

        int userId = currentUser.getId();
        boolean alreadyLiked = likeLivreDAO.hasUserLiked(userId, livreId);

        if (alreadyLiked) {
            likeLivreDAO.removeLike(userId, livreId);
            return false;
        } else {
            likeLivreDAO.addLike(userId, livreId);
            return true;
        }
    }

    public int getNombreLikesLivre(int livreId) {
        return likeLivreDAO.countLikesForLivre(livreId);
    }
}
