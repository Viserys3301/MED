package kz.healthcity.medbox.repositories.bonus_system;

import kz.healthcity.medbox.entities.bonus_system.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction,Long> {
}
