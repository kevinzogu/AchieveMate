package al.AchieveMate.AchieveMate.repository;

import al.AchieveMate.AchieveMate.entity.DailyPlanner;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;

public interface DailyPlannerRepository extends JpaRepository<DailyPlanner, Long> {
    DailyPlanner findByDate(LocalDate date);
}