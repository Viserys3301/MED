package kz.healthcity.medbox.services.bonus_system;

import kz.healthcity.medbox.entities.bonus_system.Transaction;
import kz.healthcity.medbox.repositories.bonus_system.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionService {

    TransactionRepository transactionRepository;

    @Autowired
    public void setTransactionRepository(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    public List<Transaction> findAll(){
        return transactionRepository.findAll();
    }

    public void saveOrUpdate(Transaction transaction){
        transactionRepository.save(transaction);
    }
}
