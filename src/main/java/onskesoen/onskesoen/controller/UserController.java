package onskesoen.onskesoen.controller;

import onskesoen.onskesoen.model.User;
import onskesoen.onskesoen.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/register")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public String showRegistrationForm() {
        return "register";
    }

    @PostMapping
    public String registerUser(@RequestParam String username, @RequestParam String password, @RequestParam String email) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setEmail(email);
        userService.registerUser(user);
        return "redirect:/login";
    }

    @PostMapping("/login")
    public String loginUser(@RequestParam String username, @RequestParam String password) {
        if (userService.loginUser(username, password)) {
            return "redirect:/forside";
        } else {
            return "redirect:/login?error=true";
        }
    }
}

