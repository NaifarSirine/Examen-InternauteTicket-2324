package tn.esprit.spring.RestControllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring.Entities.Enum.TrancheAge;
import tn.esprit.spring.Entities.Enum.TypeTicket;
import tn.esprit.spring.Entities.Evenement;
import tn.esprit.spring.Entities.Internaute;
import tn.esprit.spring.Entities.Ticket;
import tn.esprit.spring.Services.IService;

import java.time.LocalDate;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("rest")
public class RestControllerClass {
    IService service;

    @PostMapping("ajouterInternaute")
    Internaute ajouterInternaute(@RequestBody Internaute internaute) {
        return service.ajouterInternaute(internaute);
    }

    @PostMapping("ajouterEvenement")
    Evenement ajouterEvenement(@RequestBody Evenement evenement) {
        return service.ajouterEvenement(evenement);
    }

    @PostMapping("ajouterTicketsEtAffecterAEvenementEtInternaute")
    List<Ticket> ajouterTicketsEtAffecterAEvenementEtInternaute(@RequestBody List<Ticket> tickets, @RequestParam Long idEvenement, @RequestParam Long idInternaute) {
        return service.ajouterTicketsEtAffecterAEvenementEtInternaute(tickets, idEvenement, idInternaute);
    }

    @GetMapping("montantRecupereParEvtEtTypeTicket")
    Double montantRecupereParEvtEtTypeTicket(@RequestParam String nomEvt, @RequestParam TypeTicket typeTicket) {
        return service.montantRecupereParEvtEtTypeTicket(nomEvt, typeTicket);
    }

    @GetMapping("internauteLePlusActif")
    String internauteLePlusActif() {
        return service.internauteLePlusActif();
    }

    @GetMapping("nbInternauteParTrancheAgeEtDateEvenement")
    Long nbInternauteParTrancheAgeEtDateEvenement(@RequestParam TrancheAge trancheAge, @RequestParam LocalDate dateMin,@RequestParam LocalDate dateMax){
        return service.nbInternauteParTrancheAgeEtDateEvenement(trancheAge,dateMin,dateMax);
    }

}
