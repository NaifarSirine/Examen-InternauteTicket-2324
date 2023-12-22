package tn.esprit.spring.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import tn.esprit.spring.Entities.Enum.TypeTicket;
import tn.esprit.spring.Entities.Ticket;

import java.util.List;

public interface TicketRepository extends JpaRepository<Ticket,Long > {
    List<Ticket> findByEvenementNomEvenementAndTypeTicket(String nomEvent, TypeTicket typeTicket);
    int countByInternauteIdInternaute(Long idInternaute);

    @Query("select SUM(t.prixTicket) from Ticket t where t.evenement.nomEvenement=?2 and t.typeTicket=?1")
    Double montantRecupereParEvtEtTypeTicket(TypeTicket typeTicket, String nomEvent);
}
