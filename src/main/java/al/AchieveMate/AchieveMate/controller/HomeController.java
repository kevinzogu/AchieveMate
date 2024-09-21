package al.AchieveMate.AchieveMate.controller;

import al.AchieveMate.AchieveMate.entity.DailyPlanner;
import al.AchieveMate.AchieveMate.service.DailyPlannerService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;

@Controller
public class HomeController {
    
    @Autowired
    private DailyPlannerService dailyPlannerService;
    
    @GetMapping("/daily-planner")
    public String dailyPlanner(HttpSession session, Model model, @RequestParam(required = false) LocalDate date) {
        if (session.getAttribute("loggedInUser") == null) {
            return "redirect:/login";
        }
        
        if (date == null) {
            date = LocalDate.now();
        }
        
        DailyPlanner dailyPlanner = dailyPlannerService.findByDate(date);
        if (dailyPlanner == null) {
            dailyPlanner = new DailyPlanner();
            dailyPlanner.setDate(date);
        }
        
        model.addAttribute("dailyPlanner", dailyPlanner);
        return "daily-planner"; // return your daily planner HTML template
    }
    
    @GetMapping("/get-planner/{date}")
    public ResponseEntity<DailyPlanner> getPlannerByDate(@PathVariable LocalDate date) {
        DailyPlanner dailyPlanner = dailyPlannerService.findByDate(date);
        if (dailyPlanner == null) {
            dailyPlanner = new DailyPlanner();
            dailyPlanner.setDate(date);
        }
        return ResponseEntity.ok(dailyPlanner);
    }
    
    @PostMapping("/save-planner")
    public String savePlanner(DailyPlanner dailyPlanner) {
        dailyPlannerService.save(dailyPlanner);
        return "redirect:/daily-planner?date=" + dailyPlanner.getDate();
    }
}