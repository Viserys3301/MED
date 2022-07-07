package kz.healthcity.medbox.services.bonus_system;

import kz.healthcity.medbox.entities.bonus_system.Discount;
import kz.healthcity.medbox.entities.bonus_system.Patient;
import kz.healthcity.medbox.repositories.bonus_system.DiscountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Service
@Scope("prototype")
public class DiscountService {

    DiscountRepository discountRepository;

    @Autowired
    public void setDiscountRepository(DiscountRepository discountRepository) {
        this.discountRepository = discountRepository;
    }

    public Optional<Discount> findById(Long id){
        return discountRepository.findById(id);
    }

    public List<Discount> findAll(){
        return discountRepository.findAll();
    }

    @Transactional
    public void declineBuId(Long id){
        //TODO реализовать
    }

    @Transactional
    public void includeById(Long id){
        //TODO реализовать
    }


    public void saveOrUpdate(Discount discount){
        discount.setIsActive(true);
        discountRepository.save(discount);
    }

    @Transactional
    public void deleteById(Long id){
        discountRepository.deleteById(id);
    }

    public void decline(Long id) {
        try {
            Discount discount = findById(id).orElseThrow(SQLException::new);
            discount.setIsActive(false);
            discountRepository.save(discount);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void include(Long id) {
        try {
            Discount discount = findById(id).orElseThrow(SQLException::new);
            discount.setIsActive(true);
            discountRepository.save(discount);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
