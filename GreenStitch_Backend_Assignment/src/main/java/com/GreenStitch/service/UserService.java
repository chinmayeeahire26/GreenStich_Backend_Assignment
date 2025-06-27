package com.GreenStitch.service;

import com.GreenStitch.exceptions.UserException;
import com.GreenStitch.model.UserData;

public interface UserService {

    public UserData registerUser(UserData user) throws UserException;

    @Override
    public UserData loginUser(String email, String password) throws UserException {
        UserData user = userRepo.findByEmail(email);
        if (user != null && user.getPassword().equals(password)) {
            return user;
        } else {
            throw new UserException("Invalid username or password");
        }
    }
}
