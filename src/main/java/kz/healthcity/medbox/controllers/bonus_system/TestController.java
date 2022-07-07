package kz.healthcity.medbox.controllers.bonus_system;

import kz.healthcity.medbox.services.bonus_system.FindNewBonusPatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/test")
public class TestController {
    FindNewBonusPatientService findNewBonusPatientService;

    @Autowired
    public void setFindNewBonusPatientService(FindNewBonusPatientService findNewBonusPatientService) {
        this.findNewBonusPatientService = findNewBonusPatientService;
    }

    @GetMapping
    public String find(){
        findNewBonusPatientService.find();
        return "bonus-system/patient/patients";
    }
}
