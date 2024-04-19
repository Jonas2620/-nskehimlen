package onskesoen.onskesoen.controller;

import onskesoen.onskesoen.logik.logikken;
import onskesoen.onskesoen.model.Ønske;
import onskesoen.onskesoen.model.Ønskeliste;
import onskesoen.onskesoen.service.ØnskeService;
import onskesoen.onskesoen.service.ønskelisteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class myController {


    @Autowired
    ønskelisteService ønskelisteService;
    @Autowired
    logikken logikken;
    @Autowired
    private ØnskeService ønskeService;

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
        int nextId = logikken.findNextAvailableId();
        ønskeliste.setWishlist_id(nextId); // Indstil id'et for den nye ønskeliste
        ønskelisteService.addØnskelist(ønskeliste);
        return "redirect:/onskeliste";
    }


@GetMapping("/viewOne/{id}")
public String viewOne(@PathVariable("id") int id, Model model){
    model.addAttribute("ønskeliste", ønskelisteService.findØnskelisteId(id));
    return "viewone";
}
@GetMapping("/deleteOne/{wishlist_id}")
public String deleteOne(@PathVariable("wishlist_id") int wishlist_id){
    boolean deleted = ønskelisteService.deleteØnskeliste(wishlist_id);
    if (deleted){
        return "redirect:/onskeliste";
    }else {
        return "redirect:/forside";
    }
}
@GetMapping("/updateOne/{wishlist_id}")
public String updateOne(@PathVariable("wishlist_id") int wishlist_id, Model model){
    Ønskeliste ønskeliste = ønskelisteService.findØnskelisteId(wishlist_id);
    model.addAttribute("ønskeliste",ønskeliste);
    model.addAttribute("wishlist_id", wishlist_id); // Tilføj wishlist_id til modellen

    return "updateOne";
}
    @PostMapping("/updateØnskeliste")
    public String updateØnskeliste(@ModelAttribute Ønskeliste ønskeliste) {
        ønskelisteService.updateØnskeliste(ønskeliste.getWishlist_id(), ønskeliste);
        return "redirect:/onskeliste";
    }
    @GetMapping("/updateØnskelisteForm/{wishlist_id}")
    public String updateØnskelisteForm(@PathVariable("wishlist_id") int id, Model model) {
        Ønskeliste ønskeliste = ønskelisteService.findØnskelisteId(id);
        model.addAttribute("ønskeliste", ønskeliste);
        return "updateOne";
    }

    @PostMapping("/tilføjØnske")
    public String tilføjØnske(@ModelAttribute Ønske ønske, @RequestParam("wishlist_id") int wishlist_id) {
        ønske.setWishlist_id(wishlist_id); // Sæt ønskets wishlist_id
        ønskeService.tilføjØnske(ønske);
        return "redirect:/onskeliste";
    }


}
