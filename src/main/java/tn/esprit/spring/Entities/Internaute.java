package tn.esprit.spring.Entities;


import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import tn.esprit.spring.Entities.Enum.TrancheAge;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "t-internaute")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Internaute {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idInternaute;
    String identifiant;
    @Enumerated(EnumType.STRING)
    TrancheAge trancheAge;
    @OneToMany(mappedBy = "internaute")
    List<Ticket> tickets= new ArrayList<>();
}
