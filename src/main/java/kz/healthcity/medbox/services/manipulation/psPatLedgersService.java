package kz.healthcity.medbox.services.manipulation;

import kz.healthcity.medbox.entities.manipulation.psPatLedgers;
import kz.healthcity.medbox.repositories.manipulation.psPatLedgersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.NotActiveException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Optional;

@Service
public class psPatLedgersService {
    psPatLedgersRepository patLedgersRepository;


    @Autowired
    public void setPatLedgersRepository(psPatLedgersRepository patLedgersRepository) {
        this.patLedgersRepository = patLedgersRepository;
    }

    public Optional<psPatLedgers> findById(Long id){
        return patLedgersRepository.findById(id);
    }

    @Transactional
    public void update(psPatLedgers patLedgers){
        patLedgersRepository.save(patLedgers);
    }

    public List<psPatLedgers> find(Timestamp start, Timestamp end ){

        return     patLedgersRepository.findByDocdateBetween(start,end);
    }

    public List<psPatLedgers> findAll() {
        return patLedgersRepository.findAll();
    }
}
