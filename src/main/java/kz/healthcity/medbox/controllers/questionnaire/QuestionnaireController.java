package kz.healthcity.medbox.controllers.questionnaire;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/questionnaires")
public class QuestionnaireController {

    @GetMapping
    public String getQuestionnairesPage(Model model){
        return "questionnaires/questionnaire";
    }
}
