package tn.esprit.spring.Entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "t-evenement")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Evenement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idEvenement;
    String nomEvenement;
    Long nbPlacesRestants;
    LocalDate dateEvenement;
    @OneToMany(mappedBy = "evenement")
    List<Ticket> tickets;
    @ManyToMany(cascade = CascadeType.ALL)
    List<Categorie> categories= new ArrayList<>();
}
