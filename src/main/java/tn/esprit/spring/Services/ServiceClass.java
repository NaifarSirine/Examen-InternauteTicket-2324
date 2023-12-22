package tn.esprit.spring.Services;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import tn.esprit.spring.Entities.Categorie;
import tn.esprit.spring.Entities.Enum.TrancheAge;
import tn.esprit.spring.Entities.Enum.TypeTicket;
import tn.esprit.spring.Entities.Evenement;
import tn.esprit.spring.Entities.Internaute;
import tn.esprit.spring.Entities.Ticket;
import tn.esprit.spring.Repositories.CategorieRepository;
import tn.esprit.spring.Repositories.EvenementRepository;
import tn.esprit.spring.Repositories.InternauteRepository;
import tn.esprit.spring.Repositories.TicketRepository;

import java.time.LocalDate;
import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class ServiceClass implements IService {

    CategorieRepository categorieRepository;
    EvenementRepository evenementRepository;
    InternauteRepository internauteRepository;
    TicketRepository ticketRepository;

    @Override
    public Internaute ajouterInternaute(Internaute internaute) {
        return internauteRepository.save(internaute);
    }

    @Override
    public Evenement ajouterEvenement(Evenement evenement) {
        return evenementRepository.save(evenement); //Cascade
    }

    @Override
    public void listeEvenementsParCategorie() {
        for (Categorie categorie : categorieRepository.findAll()) {
            log.info("Categorie " + categorie.getNomCategorie());
            for (Evenement evenement : categorie.getEvenements()) {
                log.info("Evenement " + evenement.getNomEvenement() + " planifié le " + evenement.getDateEvenement());
            }
        }
    }

    @Override
    public List<Ticket> ajouterTicketsEtAffecterAEvenementEtInternaute(List<Ticket> tickets, Long idEvenement, Long idInternaute) {
        Evenement evenement = evenementRepository.findById(idEvenement).get();
        Internaute internaute = internauteRepository.findById(idInternaute).get();
        if(evenement.getNbPlacesRestants()<tickets.size()){
            throw new java.lang.UnsupportedOperationException("nombre de places demandées indisponibe");
        }
        else{
            // cascade
            for (Ticket ticket : tickets) {
                ticket.setEvenement(evenement);
                ticket.setInternaute(internaute);
                // Mise à jour
                evenement.setNbPlacesRestants(evenement.getNbPlacesRestants() - 1);
                evenement = evenementRepository.save(evenement);
            }
            return ticketRepository.saveAll(tickets);
        }
    }

    @Override
    public Long nbInternauteParTrancheAgeEtDateEvenement(TrancheAge trancheAge, LocalDate dateMin, LocalDate dateMax) {
        return internauteRepository.countByTrancheAgeAndTicketsEvenementDateEvenementBetween(trancheAge,dateMin,dateMax);
    }


    @Override
    public Double montantRecupereParEvtEtTypeTicket(String nomEvt, TypeTicket typeTicket) {
//        double somme = 0;
//        for (Ticket ticket : ticketRepository.findByEvenementNomEvenementAndTypeTicket(nomEvt, typeTicket)) {
//            somme += ticket.getPrixTicket();
//        }
//        return somme;
        return ticketRepository.montantRecupereParEvtEtTypeTicket(typeTicket,nomEvt);
    }

    @Override
    public String internauteLePlusActif() {
        String identifiant = "";
        int max = 0;
        for (Internaute internaute : internauteRepository.findAll()) {
            if (ticketRepository.countByInternauteIdInternaute(internaute.getIdInternaute()) > max) {
                max = ticketRepository.countByInternauteIdInternaute(internaute.getIdInternaute());
                identifiant = internaute.getIdentifiant();
            }
        }
        return identifiant;
    }
}
