package kz.healthcity.medbox.repositories.bonus_system;

import kz.healthcity.medbox.entities.bonus_system.Discount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DiscountRepository extends JpaRepository<Discount,Long> {
}
