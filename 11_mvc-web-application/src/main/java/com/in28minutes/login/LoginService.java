package com.in28minutes.login;

import org.springframework.stereotype.Service;

@Service
public class LoginService {
    public boolean isUserValid(String user, String password) {
        return user.equals("user") && password.equals("password");
    }
}
