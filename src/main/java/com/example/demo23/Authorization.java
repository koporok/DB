package com.example.demo23;


import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import animations.Shake;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class Authorization {
    @FXML
    private ResourceBundle resources;
    @FXML
    private URL location;
    @FXML
    private Button Entrance;
    @FXML
    private Button Registration;
    @FXML
    private TextField UserLogin;

    @FXML
    private PasswordField UserPasswords;
    @FXML
    protected void MouseCliked(MouseEvent event) throws IOException {SceneLoader.loadNewScene("Registration.fxml",Registration);}

    @FXML
    void initialize() {
        Entrance.setOnAction(event ->{
            String loginText = UserLogin.getText().trim();
            String loginPass = UserPasswords.getText().trim();
            if(!loginText.equals("")&&!loginPass.equals("")){
                try {loginUser(loginText,loginPass);}
                catch (IOException e) {throw new RuntimeException(e);}
            }
            else{
                Entrance.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent actionEvent) {
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setHeaderText("Проверьте коректность данных.");
                        alert.showAndWait();
                    }
                });
            }
        });
    }

    private void loginUser(String loginText, String loginPass) throws IOException{
        DatabaseHandler dbHandler = new DatabaseHandler();
        User user = new User();
        user.setUserName(loginText);
        user.setPassword(loginPass);
        ResultSet result = dbHandler.getUser(user);

        int counter = 0;

        while(true){
            try {if (!result.next()) break;}
            catch (SQLException e) {throw new RuntimeException(e);}
            counter++;
        }
        if (counter>=1){
            if (loginPass.equals("twprok")) {SceneLoader.loadNewScene("Administrator.fxml",Entrance);}
            else {SceneLoader.loadNewScene("Client.fxml",Entrance);}
        }
        else {
            Shake userLoginAnim = new Shake(UserLogin);
            Shake userPassAnim = new Shake(UserPasswords);
            userLoginAnim.playAnim();
            userPassAnim.playAnim();
        }

    }
}
