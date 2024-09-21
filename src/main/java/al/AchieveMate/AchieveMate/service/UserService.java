package al.AchieveMate.AchieveMate.service;

import al.AchieveMate.AchieveMate.entity.Users;
import al.AchieveMate.AchieveMate.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    
    @Autowired
    private UserRepository userRepository;
    
    public Users findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
    
    public void save(Users user) {
        userRepository.save(user);
    }
    
    public boolean existsByUsername(String username) {
        return userRepository.existsByUsername(username);
    }
}