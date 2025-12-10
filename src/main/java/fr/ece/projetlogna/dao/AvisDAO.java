package fr.ece.projetlogna.dao;

import fr.ece.projetlogna.model.Livre;
import java.util.List;
import java.util.Optional;

    public interface LivreDAO {

        Livre save(Livre livre);

        Optional<Livre> findById(int id);

        List<Livre> findAll();

        List<Livre> findByCategorieId(int categorieId);

        void deleteById(int id);
    }


