package com.example.bms;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

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
            loadInventoryScreen();
        } else {
            loginStatus.setText("Invalid credentials");
        }
    }

    private boolean authenticate(String username, String password) {
        // Placeholder for authentication logic
        return "admin".equals(username) && "password".equals(password);
    }

    private void loadInventoryScreen() {
        try {
            Stage stage = (Stage) usernameField.getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/inventory.fxml"));
            Scene scene = new Scene(loader.load());
            stage.setScene(scene);
            stage.setTitle("Inventory Management");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
