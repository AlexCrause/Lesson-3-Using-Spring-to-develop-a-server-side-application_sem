package com.example.sem3hometask.servicies;

import com.example.sem3hometask.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class RegistrationService {

    @Autowired
    private UserService userService;
    @Autowired
    private DataProcessingService dataProcessingService;
    @Autowired
    private NotificationService notificationService;

    public void processRegistration(String name, int age, String email) {
        User user = userService.createUser(name, age, email);
        dataProcessingService.addUserToList(user);
        notificationService.notifyUser(user);
    }

    public DataProcessingService getDataProcessingService() {
        return dataProcessingService;
    }
}
