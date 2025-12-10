package fr.ece.projetlogna.dao;

import fr.ece.projetlogna.model.ForumPost;
import java.util.List;
import java.util.Optional;

public interface ForumPostDAO {

    ForumPost save(ForumPost post);
    Optional<ForumPost> findById(int id);
    List<ForumPost> findAll();
    List<ForumPost> findByLivreId(int livreId);
    void deleteById(int id);
}
