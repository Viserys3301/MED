package kz.healthcity.medbox.services.manipulation;

import kz.healthcity.medbox.entities.manipulation.psPatinv;
import kz.healthcity.medbox.repositories.manipulation.psPatinvRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class psPatinvService {
    psPatinvRepository PatinvRepository;

    @Autowired
    public void setPatinvRepository(psPatinvRepository patinvRepository) {
        PatinvRepository = patinvRepository;
    }


    public Optional<psPatinv> findById(Long id){
        return PatinvRepository.findById(id);
    }
    @Transactional
    public void update(psPatinv patinv){
        PatinvRepository.save(patinv);
    }


}
