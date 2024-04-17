package onskesoen.onskesoen.controller;

import onskesoen.onskesoen.model.Ønskeliste;
import onskesoen.onskesoen.service.ønskelisteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class myController {


    @Autowired
    ønskelisteService ønskelisteService;

    @GetMapping("/")
    public String forside(){

        return "forside";
    }

    @GetMapping("/ønskeliste")
    public String ønskeliste(Model model){
        List<Ønskeliste> ønskeList = ønskelisteService.fetchAll();
        model.addAttribute("ønskeliste", ønskeList);
        return "onskeliste";
    }
    @GetMapping("/nyØnskesø")
    public String create(){
        return "nyØnskesø";
    }
    @PostMapping("/tilføj")
    public String createNew(@ModelAttribute Ønskeliste ønskeliste){
        ønskelisteService.addØnskelist(ønskeliste);
        return "redirect:/ønskeliste";
    }
}
