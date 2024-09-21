package al.AchieveMate.AchieveMate.repository;

import al.AchieveMate.AchieveMate.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users, Long> {
    Users findByUsername(String username);
    boolean existsByUsername(String username);
}