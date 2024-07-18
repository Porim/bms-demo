package com.example.bms;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginController {

    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Label loginStatus;

    public void handleLogin(ActionEvent event) {
        String username = usernameField.getText();
        String password = passwordField.getText();

        if (authenticate(username, password)) {
            loginStatus.setText("Login successful!");
            // Load the main application view or proceed further
        } else {
            loginStatus.setText("Invalid credentials");
        }
    }

    private boolean authenticate(String username, String password) {
        // Placeholder for authentication logic
        return "admin".equals(username) && "password".equals(password);
    }
}
