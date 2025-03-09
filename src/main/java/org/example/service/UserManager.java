package org.example.service;

import org.example.model.User;

import java.util.HashMap;
import java.util.Map;

public class UserManager {

    private Map<String, User> users = new HashMap<>();
    private User loggedInUser;

    public boolean register(String email, String password, String name) {
        if (users.containsKey(email)) {
            System.out.println("Email already registered.");
            return false;
        }
        users.put(email, new User(email, password, name));
        System.out.println("User registered successfully.");
        return true;
    }

    public boolean login(String email, String password) {
        User user = users.get(email);
        if (user != null && user.getPassword().equals(password)) {
            loggedInUser = user;
            System.out.println("Login successful.");
            return true;
        }
        System.out.println("Invalid email or password.");
        return false;
    }

    public User getLoggedInUser() {
        return loggedInUser;
    }

    public void logout() {
        loggedInUser = null;
        System.out.println("Logged out successfully.");
    }

    public boolean deleteAccount() {
        if (loggedInUser != null) {
            users.remove(loggedInUser.getEmail());
            System.out.println("Account deleted successfully.");
            loggedInUser = null;
            return true;
        }
        return false;
    }

    public boolean updateUserProfile(String name, String email, String password) {
        if (loggedInUser == null) {
            System.out.println("No user logged in.");
            return false;
        }
        loggedInUser.setName(name);
        loggedInUser.setEmail(email);
        loggedInUser.setPassword(password);
        System.out.println("Profile updated successfully.");
        return true;
    }

}
