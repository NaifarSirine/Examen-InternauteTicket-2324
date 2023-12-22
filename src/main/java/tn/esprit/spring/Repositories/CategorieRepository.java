package tn.esprit.spring.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.spring.Entities.Categorie;
public interface CategorieRepository extends JpaRepository<Categorie,Long > {
}