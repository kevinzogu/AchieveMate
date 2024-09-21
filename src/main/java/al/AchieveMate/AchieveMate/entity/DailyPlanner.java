package al.AchieveMate.AchieveMate.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "daily_planner")
public class DailyPlanner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private LocalDate date;
    private String gratitude1;
    private String gratitude2;
    private String gratitude3;
    private String goal;
    private String notes;
    private String mood;
    private int waterCups;
    private int sleepHours;
}
