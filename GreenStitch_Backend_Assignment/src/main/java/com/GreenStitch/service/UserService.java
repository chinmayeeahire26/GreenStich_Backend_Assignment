package com.GreenStitch.service;

import com.GreenStitch.exceptions.UserException;
import com.GreenStitch.model.UserData;

public interface UserService {

    public UserData registerUser(UserData user) throws UserException;

    @Override
public UserData loginUser() {
    SecurityContext sc  = SecurityContextHolder.getContext();
    Authentication auth  = sc.getAuthentication();
    String userName = auth.getName();
    UserData user = userRepo.findByEmail(userName);
    return user;
}
    }

