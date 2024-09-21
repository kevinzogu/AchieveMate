import al.AchieveMate.AchieveMate.entity.DailyPlanner;
import al.AchieveMate.AchieveMate.service.DailyPlannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDate;

@Controller
public class DailyPlannerController {
    
    @Autowired
    private DailyPlannerService dailyPlannerService;
    
    @GetMapping("/daily-planner")
    public String showPlanner(Model model) {
        model.addAttribute("dailyPlanner", new DailyPlanner());
        return "daily-planner";
    }
    
    @PostMapping("/save-planner")
    public String savePlanner(@ModelAttribute DailyPlanner dailyPlanner) {
        dailyPlannerService.save(dailyPlanner);
        return "redirect:/daily-planner";
    }
    
    @GetMapping("/get-planner/{date}")
    public String getPlanner(@PathVariable String date, Model model) {
        DailyPlanner dailyPlanner = dailyPlannerService.findByDate(LocalDate.parse(date));
        model.addAttribute("dailyPlanner", dailyPlanner);
        return "daily-planner";
    }
}
