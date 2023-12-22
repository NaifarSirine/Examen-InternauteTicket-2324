package tn.esprit.spring.Services;

import tn.esprit.spring.Entities.*;
import tn.esprit.spring.Entities.Enum.*;

import java.time.LocalDate;
import java.util.List;

public interface IService {
    Internaute ajouterInternaute(Internaute internaute);
    Evenement ajouterEvenement(Evenement evenement);
    void listeEvenementsParCategorie();
    List<Ticket> ajouterTicketsEtAffecterAEvenementEtInternaute(List<Ticket> tickets, Long idEvenement, Long idInternaute );
    Long nbInternauteParTrancheAgeEtDateEvenement(TrancheAge trancheAge, LocalDate dateMin, LocalDate dateMax);
    Double montantRecupereParEvtEtTypeTicket(String nomEvt, TypeTicket typeTicket);
    String internauteLePlusActif();
}
