package com.in28minutes.services;

import org.springframework.stereotype.Service;

//Login function is handled by Spring Security now, so this userValidationService method is useless now
@Service    // also work if using @Component as @Service is a special case of @Component to indicate @Service beans are holding business logic
public class UserValidationService {
    public boolean isUserValid(String user, String password){
        return user.equals("test") && password.equals("pw");
    }
}
