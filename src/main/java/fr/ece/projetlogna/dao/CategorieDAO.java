package fr.ece.projetlogna.dao;


import fr.ece.projetlogna.model.Categorie;
import java.util.List;
import java.util.Optional;

public interface CategorieDAO {

    Categorie save(Categorie categorie);

    Optional<Categorie> findById(int id);

    List<Categorie> findAll();

    void deleteById(int id);
                               }

