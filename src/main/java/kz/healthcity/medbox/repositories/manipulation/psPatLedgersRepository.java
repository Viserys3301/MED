package kz.healthcity.medbox.repositories.manipulation;

import kz.healthcity.medbox.entities.manipulation.psPatLedgers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;

@Repository
public interface psPatLedgersRepository extends JpaRepository<psPatLedgers,Long> {

    List<psPatLedgers> findByDocdateBetween(Timestamp timestampStart,Timestamp timestampEnd);
}
