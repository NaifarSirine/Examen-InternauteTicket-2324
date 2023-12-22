package tn.esprit.spring.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.spring.Entities.Enum.TrancheAge;
import tn.esprit.spring.Entities.Internaute;

import java.time.LocalDate;

public interface InternauteRepository extends JpaRepository<Internaute,Long > {
    Long countByTrancheAgeAndTicketsEvenementDateEvenementBetween(TrancheAge trancheAge, LocalDate dateMin,
                                                                  LocalDate dateMax);
}