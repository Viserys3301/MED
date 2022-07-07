package kz.healthcity.medbox.controllers.bonus_system;

import kz.healthcity.medbox.entities.bonus_system.Patient;
import kz.healthcity.medbox.services.bonus_system.DiscountService;
import kz.healthcity.medbox.services.bonus_system.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/bonus_system/patient")
public class BonusSystemPatientController {

    PatientService patientService;

    DiscountService discountService;

    @Autowired
    public void setDiscountService(DiscountService discountService) {
        this.discountService = discountService;
    }

    @Autowired
    public void setPatientService(PatientService patientService) {
        this.patientService = patientService;
    }

    @GetMapping
    public String getBonusSystemPatientPage(Model model){
        model.addAttribute("patients",patientService.findAll());
        return "bonus-system/patient/patients";
    }

    @GetMapping("/{id}")
    public String getBonusPatientByIdPage(@PathVariable(value = "id") Long id, Model model){
        model.addAttribute("patient",patientService.findById(id));
        model.addAttribute("discounts",discountService.findAll());
        return "bonus-system/patient/patient";
    }

    @GetMapping("/new")
    public String getNewBonusPatientPage(Model model){
        model.addAttribute("patient",new Patient());
        model.addAttribute("discounts",discountService.findAll());
        return "bonus-system/patient/patient";
    }

    @PostMapping("/new_patient")
    public String addNewPatient(Patient patient){
        patientService.saveOrUpdate(patient);
        return "redirect:/bonus_system/patient";
    }

    @GetMapping("/decline/{id}")
    public String decline(@PathVariable(value = "id") Long id, Model model){
        patientService.decline(id);
        return "redirect:/bonus_system/patient";
    }

    @GetMapping("/include/{id}")
    public String include(@PathVariable(value = "id") Long id, Model model){
        patientService.include(id);
        return "redirect:/bonus_system/patient";
    }
}
