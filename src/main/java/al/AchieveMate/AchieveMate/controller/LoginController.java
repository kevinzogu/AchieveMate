package al.AchieveMate.AchieveMate.controller;

import al.AchieveMate.AchieveMate.entity.Users;
import al.AchieveMate.AchieveMate.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
    
    @Autowired
    private UserService userService;
    
    @GetMapping("/login")
    public String loginPage() {
        return "login"; // return your login HTML template
    }
    
    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password, Model model, HttpSession session) {
        Users user = userService.findByUsername(username);
        if (user != null && user.getPassword().equals(password)) {
            // On success, set user in session and redirect to a secured page
            session.setAttribute("loggedInUser", user);
            return "redirect:/daily-planner";
        } else {
            model.addAttribute("error", "Invalid credentials");
            return "login"; // return to login page with error
        }
    }
    
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/login";
    }
}