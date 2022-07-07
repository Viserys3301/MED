package kz.healthcity.medbox.services.manipulation;

import kz.healthcity.medbox.entities.security.Role;
import kz.healthcity.medbox.repositories.manipulation.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoleService {

    RoleRepository roleRepository;

    @Autowired
    public void setRoleRepository(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public Optional<Role> findById(Byte id){
        return roleRepository.findById(id);
    }

    public List<Role> findAll(){
        return roleRepository.findAll();
    }

    public void updateOrSave(Role role){
        roleRepository.save(role);
    }
}
