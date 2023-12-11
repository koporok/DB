package com.example.demo23;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class Registration {
    @FXML
    private Button Back;
    @FXML
    private Button Register;
    @FXML
    private TextField UserLlastName;
    @FXML
    private PasswordField UserLogin;
    @FXML
    private TextField UserName;
    @FXML
    private TextField UserPasswor;
    @FXML
    protected void MouseCliked(MouseEvent event) throws IOException {SceneLoader.loadNewScene("Authorization.fxml",Back);}
    @FXML
    void initialize(){Register.setOnAction(event -> {signUpNewUser();});}
    private void signUpNewUser() {
        DatabaseHandler dbHandler = new DatabaseHandler();

        String firstName = UserLlastName.getText();
        String lastName = UserName.getText();
        String userName = UserLogin.getText();
        String password = UserPasswor.getText();

        if (!firstName.equals("")&&!lastName.equals("")&&!userName.equals("")&&!password.equals("")){
            User user = new User(firstName,lastName,userName,password);
            dbHandler.signUser(user);
            Register.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setHeaderText("Регистрация прошла успешно. Перейдите на окно авторизации.");
                    alert.showAndWait();
                }
            });
        }
        else {
            Register.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setHeaderText("Проверьте введённые данные");
                    alert.showAndWait();
                }
            });
        }

    }
}