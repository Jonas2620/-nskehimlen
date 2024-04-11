package onskesoen.onskesoen.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class myController {

    @GetMapping("/")
        public String forside() {
        return "";
    }
}
