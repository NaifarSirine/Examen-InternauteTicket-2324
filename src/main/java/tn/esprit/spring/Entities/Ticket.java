package tn.esprit.spring.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import tn.esprit.spring.Entities.Enum.TypeTicket;

@Entity
@Table(name = "t-ticket")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idTicket;
    String codeTicket;
    Double prixTicket;
    @Enumerated(EnumType.STRING)
    TypeTicket typeTicket;
    @ManyToOne(cascade = CascadeType.ALL)
    @JsonIgnore
    Internaute internaute;
    @ManyToOne(cascade = CascadeType.ALL)
    @JsonIgnore
    Evenement evenement;

}
