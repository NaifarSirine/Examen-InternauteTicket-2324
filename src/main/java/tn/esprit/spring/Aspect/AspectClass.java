package tn.esprit.spring.Aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Slf4j
public class AspectClass {
    @AfterThrowing ("execution(* tn.esprit.spring.Services.ServiceClass.ajouterTicketsEtAffecterAEvenementEtInternaute(..))")
    public void afficher(){
        log.warn("Le nombre de places restantes dépasse le nombre de tickets demandés");
    }
}
