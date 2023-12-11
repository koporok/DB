package com.example.demo23;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
        import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
        import javafx.scene.control.CheckBox;
        import javafx.scene.control.TextField;
        import javafx.scene.input.MouseEvent;

public class Client {

    @FXML
    private ResourceBundle resources;
    @FXML
    private URL location;
    @FXML
    private TextField ClientAddress;
    @FXML
    private TextField ClientName;
    @FXML
    private TextField CustomerNumber;
    @FXML
    private Button Exit;
    @FXML
    private CheckBox InstallingIntercom;
    @FXML
    private CheckBox IntercomRepair;
    @FXML
    private CheckBox Other;
    @FXML
    private CheckBox ReplacingIntercom;
    @FXML
    private Button SendRequest;
    @FXML
    protected void MouseCliked(MouseEvent event) throws IOException {SceneLoader.loadNewScene("Authorization.fxml",Exit);}
    @FXML
    void initialize() {
        SendRequest.setOnAction(event ->{
            DatabaseHandler dbHandler = new DatabaseHandler();

            String Name = ClientName.getText();
            String Phonr = CustomerNumber.getText();
            String AddreSS = ClientAddress.getText();
            String ysl = "";
            if (InstallingIntercom.isSelected()){ysl="Установка_домофона";}
            else if (IntercomRepair.isSelected()) {ysl = "Реионт_Домофона";}
            else if (ReplacingIntercom.isSelected()) {ysl="Замена_домофона";}
            else{ysl = "другая_услуга";}

            if(!Name.equals("")&&!Phonr.equals("")&&!AddreSS.equals("")&&!ysl.equals("")){
                Service Service = new Service(Name, Phonr,AddreSS,ysl);
                dbHandler.signService(Service);

                SendRequest.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent actionEvent) {
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setHeaderText("Заявка отправлена.");
                        alert.showAndWait();
                    }
                });
            }
            else {
                SendRequest.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent actionEvent) {
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setHeaderText("Все поля должны быть заполнены. Проверьте поля.");
                        alert.showAndWait();
                    }
                });
            }
        });}
}