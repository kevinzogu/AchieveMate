package al.AchieveMate.AchieveMate.controller;

import al.AchieveMate.AchieveMate.service.UserService;
import al.AchieveMate.AchieveMate.entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class SignUpController {
    
    @Autowired
    private UserService userService;
    
    // GET Sign Up Page
    @GetMapping("/signup")
    public String signupPage() {
        return "signup"; // Kthe faqen e regjistrimit
    }
    
    // POST Sign Up Handler
    @PostMapping("/signup")
    public String signup(@ModelAttribute Users user, Model model) {
        if (userService.existsByUsername(user.getUsername())) {
            model.addAttribute("error", "Username already exists");
            return "signup"; // Kthe në faqen e regjistrimit nëse username-i ekziston
        }
        
        userService.save(user); // Ruaj përdoruesin e ri
        return "redirect:/login"; // Pas regjistrimit, kthe në faqen e login-it
    }
}
