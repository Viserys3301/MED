package kz.healthcity.medbox.services.bonus_system;

import kz.healthcity.medbox.entities.manipulation.psPatLedgers;
import kz.healthcity.medbox.services.manipulation.psPatLedgersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class FindNewBonusPatientService {

    psPatLedgersService PatLedgersService;

    @Autowired
    public void setPatLedgersService(psPatLedgersService patLedgersService) {
        PatLedgersService = patLedgersService;
    }

    Timestamp timestampStart;
    Timestamp timestampEnd;

    SimpleDateFormat simpleDateFormatAM = new SimpleDateFormat("yyyy-MM-dd  HH:mm:ss");

    public void find(){
        timestampStart = Timestamp.valueOf(LocalDateTime.now().minusMinutes(50));
        timestampEnd = Timestamp.valueOf(LocalDateTime.now());
        //List<psPatLedgers> payments = PatLedgersService.find(timestampStart,timestampEnd);
       // List<psPatLedgers> payments = PatLedgersService.findAll();
        psPatLedgers payments = new ArrayList<>();
        try {
            payments = PatLedgersService.findById(141259L).orElseThrow(ChangeSetPersister.NotFoundException::new);
        } catch (ChangeSetPersister.NotFoundException e) {
            throw new RuntimeException(e);
        }

        for (psPatLedgers p:payments) {
            System.out.println("============================================================");
            System.out.println(p.getDocdate());
            System.out.println("============================================================");
        }
    }



}
