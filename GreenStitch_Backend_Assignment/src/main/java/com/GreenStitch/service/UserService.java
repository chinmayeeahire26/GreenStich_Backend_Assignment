package com.GreenStitch.service;

import com.GreenStitch.exceptions.UserException;
import com.GreenStitch.model.UserData;

public interface UserService {

    public UserData registerUser(UserData user) throws UserException;

    @Override
    public UserData loginUser() throws UserException {
        SecurityContext sc = SecurityContextHolder.getContext();
        Authentication auth = sc.getAuthentication();
        if (auth == null || !auth.isAuthenticated()) {
            throw new UserException("User is not authenticated");
        }
        String userName = auth.getName();
        if (userName == null || userName.isEmpty()) {
            throw new UserException("Username is invalid");
        }
        UserData user = userRepo.findByEmail(userName);
        if (user == null) {
            throw new UserException("User not found");
        }
        return user;
    }
}
