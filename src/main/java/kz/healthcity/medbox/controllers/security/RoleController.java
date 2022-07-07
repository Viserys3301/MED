package kz.healthcity.medbox.controllers.security;

import kz.healthcity.medbox.services.manipulation.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/role")
public class RoleController {
    RoleService roleService;

    @Autowired
    public void setRoleService(RoleService roleService) {
        this.roleService = roleService;
    }

    @GetMapping
    public String getRolesPage(Model model){
        model.addAttribute("roles",roleService.findAll());
        return "/security/roles";
    }

    @GetMapping("/{id}")
    public String getRolePageById(@PathVariable(value = "id") Byte id,Model model){
        model.addAttribute("role",roleService.findById(id));
        return "/security/role";
    }
}
