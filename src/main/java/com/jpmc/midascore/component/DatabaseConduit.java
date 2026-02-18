package com.jpmc.midascore.component;

import com.jpmc.midascore.repository.UserRepository;
import org.springframework.stereotype.Component;
import com.jpmc.midascore.entity.User;

@Component
public class DatabaseConduit {
    private final UserRepository userRepository;

    public DatabaseConduit(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void save(User userRecord) {
        userRepository.save(userRecord);
    }

}
