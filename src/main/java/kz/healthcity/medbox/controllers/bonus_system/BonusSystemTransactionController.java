package kz.healthcity.medbox.controllers.bonus_system;

import kz.healthcity.medbox.services.bonus_system.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/bonus_system/transaction")
public class BonusSystemTransactionController {

    TransactionService transactionService;

    @Autowired
    public void setTransactionService(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @GetMapping
    public String getBonusSystemTransactionPage(Model model){
        model.addAttribute("transactions",transactionService.findAll());
        return "/bonus-system/transaction/transactions";
    }
}
