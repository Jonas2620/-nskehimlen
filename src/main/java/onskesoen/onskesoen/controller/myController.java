package onskesoen.onskesoen.controller;

import onskesoen.onskesoen.model.Ønskeliste;
import onskesoen.onskesoen.service.ønskelisteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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

    @GetMapping("/onskeliste")
    public String ønskeliste(Model model){
        List<Ønskeliste> ønskeList = ønskelisteService.fetchAll();
        System.out.println(ønskeList); // Tilføjet linje til udskrivning af ønskeliste
        model.addAttribute("onskelister", ønskeList);
        return "onskeliste";

    }
    @GetMapping("/nyØnskesø")
    public String create(){
        return "nyØnskesø";
    }
    @PostMapping("/tilføj")
    public String createNew(@ModelAttribute("ønskeliste") Ønskeliste ønskeliste){
        ønskelisteService.addØnskelist(ønskeliste);
        return "redirect:/onskeliste";
    }


@GetMapping("/viewOne/{id}")
public String viewOne(@PathVariable("id") int id, Model model){
    model.addAttribute("ønskeliste", ønskelisteService.findØnskelisteId(id));
    return "viewone";
}
@GetMapping("/deleteOne/{id}")
public String deleteOne(@PathVariable("id") int id){
    boolean deleted = ønskelisteService.deleteØnskeliste(id);
    if (deleted){
        return "redirect:/onskeliste";
    }else {
        return "redirect:/onskeliste";
    }
}
@GetMapping("/updateOne/{id}")
public String updateOne(@PathVariable("id") int id, Model model){
    model.addAttribute("ønskeliste", ønskelisteService.deleteØnskeliste(id));
    return "updateOne";
}
@PostMapping("/updateØnskeliste")
public String updatePerson(@ModelAttribute Ønskeliste ønskeliste){
    ønskelisteService.updateØnskeliste(ønskeliste.getWishlist_id(), ønskeliste);
    return "redirect:/onskeliste";
    }
}
