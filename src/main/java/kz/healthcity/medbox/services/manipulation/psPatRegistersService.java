package kz.healthcity.medbox.services.manipulation;

import kz.healthcity.medbox.entities.manipulation.psPatRegisters;
import kz.healthcity.medbox.repositories.manipulation.psPatRegistersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class psPatRegistersService {

    psPatRegistersRepository patRegistersRepository;

    @Autowired
    public void setPatRegistersRepository(psPatRegistersRepository patRegistersRepository) {
        this.patRegistersRepository = patRegistersRepository;
    }

    public Optional<psPatRegisters> findById(Integer id){
        return patRegistersRepository.findById(id);
    }

    @Transactional
    public void update(psPatRegisters patRegisters){
        patRegistersRepository.save(patRegisters);
    }
}
