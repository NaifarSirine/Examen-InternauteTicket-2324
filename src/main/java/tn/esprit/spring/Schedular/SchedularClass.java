package tn.esprit.spring.Schedular;


import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import tn.esprit.spring.Services.IService;

@AllArgsConstructor
@Component
public class SchedularClass {

    IService service;

    //    @Scheduled(cron = "*/15 * * * * *" )
    @Scheduled(fixedRate = 15000)
    public void method() {
        service.listeEvenementsParCategorie();
    }
}
