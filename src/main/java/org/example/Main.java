package org.example;

import org.example.model.User;
import org.example.service.UserManager;

import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);
    private static UserManager user;

    public static void main(String[] args) {


        while (true) {
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Очистка буфера после nextInt()

            switch (choice) {
                case 1:
                    registerUser();
                    break;
                case 2:
                    loginUser();
                    break;
                case 3:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

    }

    private static void registerUser() {
        System.out.print("Enter email: ");
        String email = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();
        System.out.print("Enter name: ");
        String name = scanner.nextLine();

        if (user.register(email, password, name)) {
            System.out.println("User registered successfully!");
        } else {
            System.out.println("User with this email already exists.");
        }
    }

    private static void loginUser() {
        System.out.print("Enter email: ");
        String email = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        if (user.login(email, password)) {
            System.out.println("Login successful!");
            userMenu(email);
        } else {
            System.out.println("Invalid email or password.");
        }
    }

    private  static void userMenu(String email) {
        while (true) {
            System.out.println("1. Edit Profile");
            System.out.println("2. Delete Account");
            System.out.println("3. Logout");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Очистка буфера после nextInt()

            switch (choice) {
                case 1:
                    editProfile(email);
                    break;
                case 2:
                    deleteAccount(email);
                    return; // Выход из меню после удаления аккаунта
                case 3:
                    System.out.println("Logging out...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void editProfile(String email) {
        System.out.print("Enter new name: ");
        String newName = scanner.nextLine();
        System.out.print("Enter new password: ");
        String newPassword = scanner.nextLine();

        if (user.updateUserProfile(email, newName, newPassword)) {
            System.out.println("Profile updated successfully!");
        } else {
            System.out.println("Failed to update profile.");
        }
    }

    private static void deleteAccount(String email) {

        if (user.deleteAccount()) {
            System.out.println("Account deleted successfully!");
        } else {
            System.out.println("Failed to delete account.");
        }
    }


}