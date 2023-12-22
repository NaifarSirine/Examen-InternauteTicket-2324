package tn.esprit.spring.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.spring.Entities.Evenement;

import java.util.List;

public interface EvenementRepository extends JpaRepository<Evenement,Long > {
}