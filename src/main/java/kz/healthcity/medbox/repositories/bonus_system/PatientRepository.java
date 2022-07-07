package kz.healthcity.medbox.repositories.bonus_system;

import kz.healthcity.medbox.entities.bonus_system.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends JpaRepository<Patient,Long>,CrudRepository<Patient,Long>{
//    @Modifying
//    @Query("update Patient p set p.isActive = true where p.id = :id")
//    void includePatient(@Param(value = "id") Long id);
//
//    @Modifying
//    @Query("update Patient p set p.isActive = false where p.id = :id")
//    void declinePatient(@Param(value = "id") Long id);
}
