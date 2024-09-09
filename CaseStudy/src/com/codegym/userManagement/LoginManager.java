package com.codegym.userManagement;

import com.codegym.entity.User;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class LoginManager {
    private List<User> users;
    private static final int MAX_USERS = 100; // Maximum number of users
    private static final String USER_FILE = "data/user.txt";

    public LoginManager() {
        users = new ArrayList<>();
        loadUsersFromFile();
    }

    public void registerUser(String username, String password) {
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                System.out.println("Username already exists.");
                return;
            }
        }

        if (users.size() >= MAX_USERS) {
            System.out.println("User limit reached. Cannot register more users.");
            return;
        }

        users.add(new User(username, password));
        System.out.println("Register Success!");
        saveUsersToFile();
    }

    public boolean loginUser(String username, String password) {
        for (User user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                System.out.println("Login Successful!");
                return true;
            }
        }
        System.out.println("Invalid Username or Password.");
        return false;
    }

    private void loadUsersFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(USER_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 2) {
                    users.add(new User(parts[0], parts[1]));
                }
            }
        } catch (IOException e) {
            System.out.println("Could not load users from file.");
        }
    }

    private void saveUsersToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(USER_FILE))) {
            for (User user : users) {
                writer.write(user.getUsername() + "," + user.getPassword());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Could not save users to file.");
        }
    }
}
