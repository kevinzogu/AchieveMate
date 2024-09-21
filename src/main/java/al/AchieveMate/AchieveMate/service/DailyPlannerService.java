package al.AchieveMate.AchieveMate.service;

import al.AchieveMate.AchieveMate.entity.DailyPlanner;
import al.AchieveMate.AchieveMate.repository.DailyPlannerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class DailyPlannerService {
    
    @Autowired
    private DailyPlannerRepository dailyPlannerRepository;
    
    public DailyPlanner findByDate(LocalDate date) {
        return dailyPlannerRepository.findByDate(date);
    }
    
    public void save(DailyPlanner dailyPlanner) {
        dailyPlannerRepository.save(dailyPlanner);
    }
}