package com.jpmc.midascore;

import com.jpmc.midascore.component.DatabaseConduit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.jpmc.midascore.entity.User;

@Component
public class UserPopulator {
    @Autowired
    private FileLoader fileLoader;

    @Autowired
    private DatabaseConduit databaseConduit;

    public void populate() {
        String[] userLines = fileLoader.loadStrings("/test_data/lkjhgfdsa.hjkl");
        long userId = 1L;
        for (String userLine : userLines) {
            String[] userData = userLine.split(", ");
            User user = new User(userId++, userData[0], Float.parseFloat(userData[1]));
            databaseConduit.save(user);
        }
    }
}
