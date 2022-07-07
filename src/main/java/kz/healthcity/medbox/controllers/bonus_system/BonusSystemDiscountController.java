package kz.healthcity.medbox.controllers.bonus_system;

import kz.healthcity.medbox.entities.bonus_system.Discount;
import kz.healthcity.medbox.entities.bonus_system.Patient;
import kz.healthcity.medbox.entities.bonus_system.Transaction;
import kz.healthcity.medbox.services.bonus_system.DiscountService;
import kz.healthcity.medbox.services.bonus_system.PatientService;
import kz.healthcity.medbox.services.bonus_system.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.math.BigDecimal;

@Controller
@RequestMapping("/bonus_system/discount")
public class BonusSystemDiscountController {

    DiscountService discountService;


    @Autowired
    public void setDiscountService(DiscountService discountService) {
        this.discountService = discountService;
    }

    @GetMapping
    public String getBonusSystemDiscountPage(Model model){
        model.addAttribute("discounts",discountService.findAll());
        return "/bonus-system/discount/discounts";
    }

    @GetMapping("/{id}")
    public String getBonusSystemUpdateDiscountPage(@PathVariable(value = "id") Long id,Model model){
        model.addAttribute("discount",discountService.findById(id));
        return "/bonus-system/discount/discount";
    }

    @GetMapping("new")
    public String getBonusSystemNewDiscountPage(Model model){
        model.addAttribute("discount",new Discount());
        return "/bonus-system/discount/discount";
    }

    @PostMapping("/new_discount")
    public String updateDiscount(Discount discount){
        discountService.saveOrUpdate(discount);
        return "redirect:/bonus_system/discount";
    }

    @GetMapping("/decline/{id}")
    public String decline(@PathVariable(value = "id") Long id, Model model){
        discountService.decline(id);
        return "redirect:/bonus_system/discount";
    }

    @GetMapping("/include/{id}")
    public String include(@PathVariable(value = "id") Long id, Model model){
        discountService.include(id);
        return "redirect:/bonus_system/discount";
    }
}
