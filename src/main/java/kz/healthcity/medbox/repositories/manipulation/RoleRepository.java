package kz.healthcity.medbox.repositories.manipulation;

import kz.healthcity.medbox.entities.security.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role,Byte> {
}
