package kz.healthcity.medbox.services.bonus_system;

import kz.healthcity.medbox.entities.bonus_system.Patient;
import kz.healthcity.medbox.repositories.bonus_system.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Service
public class PatientService {

    PatientRepository patientRepository;

    @Autowired
    public void setPatientRepository(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public Optional<Patient> findById(Long id){
        return patientRepository.findById(id);
    }

    public List<Patient> findAll(){
        return patientRepository.findAll();
    }


    public void saveOrUpdate(Patient patient){
        patient.setIsActive(true);
        patientRepository.save(patient);
    }

    @Transactional
    public void deleteById(Long id){
        patientRepository.deleteById(id);
    }

    @Transactional
    public void include(Long id) {
        try {
            Patient patient = findById(id).orElseThrow(SQLException::new);
            patient.setIsActive(true);
            patientRepository.save(patient);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    @Transactional
    public void decline(Long id) {
        try {
            Patient patient = findById(id).orElseThrow(SQLException::new);
            patient.setIsActive(false);
            patientRepository.save(patient);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
