package com.example.demo23;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

public class Administrator {
    //1 таблица****** **************************************************8
    @FXML
    private TableView<users> TableUserData;
    @FXML
    private TableColumn<users, Integer> IDTableData;
    @FXML
    private TableColumn<users, String> UserLlastNameTableData;
    @FXML
    private TableColumn<users, String> UserNameTableData;
    @FXML
    private TableColumn<users, String> UserLoginTableData;
    @FXML
    private TableColumn<users, String> UserPasswordTableData;
    //относится к окну аккаунты
    @FXML
    private Button Exit;
    @FXML
    private Button Removce;
    @FXML
    private TextField UserAddressService;
    @FXML
    private TextField UserLlastName;
    @FXML
    private TextField UserLogin;
    @FXML
    private TextField UserName;
    @FXML
    private TextField UsersID;
    @FXML
    private Button Add;
    @FXML
    private TextField UserPassword;
    //2 таблица************************************************
    @FXML
    private TableView<Applications> TadleApplications;
    @FXML
    private TableColumn<Applications, Integer> IDTableApplications;
    @FXML
    private TableColumn<Applications, String> ClientNameApplications;
    @FXML
    private TableColumn<Applications, String> CustomerNumberApplications;
    @FXML
    private TableColumn<Applications, String> ClientAddressApplications;
    @FXML
    private TableColumn<Applications, String> ServiceApplications;
    //относится к оену заявлений*******************************
    @FXML
    private TextField IDApplications;
    @FXML
    private Button UpdateApplications;
    @FXML
    private Button DeleteApplications;
    //3 таблица**********************************************
    @FXML
    private TableView<Service__Table> TableServices;
    @FXML
    private TableColumn<Service__Table, Integer> IDTableServices;
    @FXML
    private TableColumn<Service__Table, String> UserNameServiceTable;
    @FXML
    private TableColumn<Service__Table,String> ServiceRegisteredTable;
    @FXML
    private TableColumn<Service__Table, String> UserAddressServiceTable;
    @FXML
    private TableColumn<Service__Table, String> UserPhoneServiceTable;
    @FXML
    private TableColumn<Service__Table, String> UserTermServiceTable;
    @FXML
    private TableColumn<Service__Table, String> UserCostServiceTable;

    //окно зарегистрированных заявок
    @FXML
    private Button ObService;
    @FXML
    private Button UpdateUser;
    @FXML
    private Button Addservices;
    @FXML
    private TextField CostPerformingService;
    @FXML
    private Button DeleteServices;
    @FXML
    private TextField Id;
    @FXML
    private TextField ServiceRegistered;
    @FXML
    private TextField TermOfServiceCompletion;
    @FXML
    private TextField UserNameService;
    @FXML
    private TextField UserPhoneService;

    //4 таблица
    @FXML
    private TableView<Service__Table> TableServ;
    @FXML
    private TableColumn<Service__Table, Integer> IDTab;
    @FXML
    private TableColumn<Service__Table, String> NameServiceTable;
    @FXML
    private TableColumn<Service__Table, String> ServiceReg;
    @FXML
    private TableColumn<Service__Table, String> AddressServ;

    @FXML
    private TableColumn<Service__Table, String> Crok;
    @FXML
    private TableColumn<Service__Table, String> PhoneServic;

    @FXML
    private TableColumn<Service__Table, String> CostSer;

    @FXML
    protected void MouseCliked(MouseEvent event) throws IOException {SceneLoader.loadNewScene("Authorization.fxml",Exit);}
    @FXML
    protected void UpdateUser(MouseEvent event){ClikUpdateUser();}
    @FXML
    protected void UpdateApplications(MouseEvent event){ClikUpdateApplications();}
    @FXML
    protected void UpdateService(MouseEvent event){ClikUpdateService();}
    @FXML
    protected void UpdateService_1(MouseEvent event){ClikUpdateService_1();}

    private void ClikUpdateService_1() {
        DatabaseHandler dbHandler = new DatabaseHandler();

        ObservableList<Service__Table> list_Service = dbHandler.Get_All_Service_1();

        IDTab.setCellValueFactory(new PropertyValueFactory<Service__Table,Integer>("idRegisteredService"));
        NameServiceTable.setCellValueFactory(new PropertyValueFactory<Service__Table,String>("UserNameService"));
        ServiceReg.setCellValueFactory(new PropertyValueFactory<Service__Table,String>("ServiceRegistered"));
        AddressServ.setCellValueFactory(new PropertyValueFactory<Service__Table,String>("UserAddressService"));
        Crok.setCellValueFactory(new PropertyValueFactory<Service__Table,String>("UserPhoneService"));
        PhoneServic.setCellValueFactory(new PropertyValueFactory<Service__Table,String>("UserTermService"));
        CostSer.setCellValueFactory(new PropertyValueFactory<Service__Table,String>("UserCostService"));

        TableServ.setItems(list_Service);
    }

    private void ClikUpdateService() {
        DatabaseHandler dbHandler = new DatabaseHandler();

        ObservableList<Service__Table> list_Service = dbHandler.Get_All_Service();

        IDTableServices.setCellValueFactory(new PropertyValueFactory<Service__Table,Integer>("idRegisteredService"));
        UserNameServiceTable.setCellValueFactory(new PropertyValueFactory<Service__Table,String>("UserNameService"));
        ServiceRegisteredTable.setCellValueFactory(new PropertyValueFactory<Service__Table,String>("ServiceRegistered"));
        UserAddressServiceTable.setCellValueFactory(new PropertyValueFactory<Service__Table,String>("UserAddressService"));
        UserPhoneServiceTable.setCellValueFactory(new PropertyValueFactory<Service__Table,String>("UserPhoneService"));
        UserTermServiceTable.setCellValueFactory(new PropertyValueFactory<Service__Table,String>("UserTermService"));
        UserCostServiceTable.setCellValueFactory(new PropertyValueFactory<Service__Table,String>("UserCostService"));

        TableServices.setItems(list_Service);
    }

    private void ClikUpdateApplications() {
        DatabaseHandler dbHandler = new DatabaseHandler();

        ObservableList<Applications> list_Applications = dbHandler.Get_All_Applications();

        IDTableApplications.setCellValueFactory(new PropertyValueFactory<Applications,Integer>("idUserRequests"));
        ClientNameApplications.setCellValueFactory(new PropertyValueFactory<Applications,String>("ClientName"));
        CustomerNumberApplications.setCellValueFactory(new PropertyValueFactory<Applications,String>("ClientAddress"));
        ClientAddressApplications.setCellValueFactory(new PropertyValueFactory<Applications,String>("CustomerNumber"));
        ServiceApplications.setCellValueFactory(new PropertyValueFactory<Applications,String>("ApplicationService"));

        TadleApplications.setItems(list_Applications);
    }

    private void ClikUpdateUser() {
        DatabaseHandler dbHandler = new DatabaseHandler();

        ObservableList<users> list_users = dbHandler.Get_All_Users();

        IDTableData.setCellValueFactory(new PropertyValueFactory<users,Integer>("IDTableData"));
        UserLlastNameTableData.setCellValueFactory(new PropertyValueFactory<users,String>("userUserLlastNameTableDataname"));
        UserNameTableData.setCellValueFactory(new PropertyValueFactory<users,String>("UserNameTableData"));
        UserLoginTableData.setCellValueFactory(new PropertyValueFactory<users,String>("UserLoginTableData"));
        UserPasswordTableData.setCellValueFactory(new PropertyValueFactory<users,String>("UserPasswordTableData"));

        TableUserData.setItems(list_users);
    }
    @FXML
    void initialize(){
        Add.setOnAction(event -> {signUser();});
        Addservices.setOnAction(event -> {signService();});
        Removce.setOnAction(event -> {
            try {deletingId();}
            catch (SQLException e) {throw new RuntimeException(e);}
            catch (ClassNotFoundException e) {throw new RuntimeException(e);}
        });
        DeleteApplications.setOnAction(event -> {
            try {deletingRemoval();}
            catch (SQLException e) {throw new RuntimeException(e);}
            catch (ClassNotFoundException e) {throw new RuntimeException(e);}
        });
        DeleteServices.setOnAction(event -> {
            try {deletingAdmin();}
            catch (SQLException e) {throw new RuntimeException(e);}
            catch (ClassNotFoundException e) {throw new RuntimeException(e);}
        });
    }
    //зарегистрирование услуги
    private void signService() {
        DatabaseHandler dbHandler = new DatabaseHandler();

        String Name = UserNameService.getText();
        String Registered = ServiceRegistered.getText();
        String Address = UserAddressService.getText();
        String Phone = UserPhoneService.getText();
        String Term = TermOfServiceCompletion.getText();
        String Cost = CostPerformingService.getText();

        if(!Name.equals("")&&!Registered.equals("")&&!Address.equals("")&&!Phone.equals("")&&!Term.equals("")&&!Cost.equals("")){
            ServicePerformed ServicePerformed = new ServicePerformed(Name,Registered,Address,Phone,Term,Cost);
            dbHandler.signServiceAdmin(ServicePerformed);
            dbHandler.signService(ServicePerformed);

            Addservices.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setHeaderText("Услуга зарегистрирована.");
                    alert.showAndWait();
                }
            });
        }
        else {
            Addservices.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setHeaderText("Проверьте коректность данных." +
                            "(Поле с ID должн бысть пустым)");
                    alert.showAndWait();
                }
            });

        }

    }
    // Добавление пользователя
    private void signUser() {
        DatabaseHandler dbHandler = new DatabaseHandler();

        String firstName = UserLlastName.getText();
        String lastName = UserName.getText();
        String userName = UserPassword.getText();
        String password = UserLogin.getText();
        if(!firstName.equals("")&&!lastName.equals("")&&!userName.equals("")&&!password.equals("")){
            User user = new User(firstName,lastName,userName,password);
            dbHandler.signUser(user);

            Add.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setHeaderText("Пользователь добавлен.");
                    alert.showAndWait();
                }
            });
        }
        else {
            Add.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setHeaderText("Проверьте коректность данных." +
                            "(Поле с ID должн бысть пустым)");
                    alert.showAndWait();
                }
            });

        }

    }
    //удаление зарегистрированой заявки
    private void deletingAdmin() throws SQLException, ClassNotFoundException {// Тут
        DatabaseHandler dbHandler = new DatabaseHandler();

        String name = " registeredservice ";
        String nameId= " idRegisteredService ";
        String ID = Id.getText();

        if(!Id.equals("")){

            deleting deleting = new deleting(name,nameId, ID);
            dbHandler.deletingLine(deleting);

            DeleteServices.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setHeaderText("Заявка удалена.");
                    alert.showAndWait();
                }
            });
        }
        else {
            DeleteServices.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setHeaderText("Проверьте коректность данных." +
                            "(Только поле с ID должно быть заполнено)");
                    alert.showAndWait();
                }
            });

        }

    }


    //удаление аккаунта
    private void deletingId() throws SQLException, ClassNotFoundException {
        DatabaseHandler dbHandler = new DatabaseHandler();

        String name = "useraccounts";
        String nameId= "idUserAccounts";
        String ID = UsersID.getText();

        if(!UsersID.equals("")){

            deleting deleting = new deleting(name,nameId, ID);
            dbHandler.deletingLine(deleting);

            Removce.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setHeaderText("Пользователь удалён.");
                    alert.showAndWait();
                }
            });
        }
        else {
            Removce.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setHeaderText("Проверьте коректность данных." +
                            "(Только поле с ID должно быть заполнено)");
                    alert.showAndWait();
                }
            });
        }
    }
    //удаление заявки
    private void deletingRemoval() throws SQLException, ClassNotFoundException {
        DatabaseHandler dbHandler = new DatabaseHandler();

        String name = "userrequests";
        String nameId= "idUserRequests";
        String ID = IDApplications.getText();

        if(!IDApplications.equals("")){

            deleting deleting = new deleting(name, nameId, ID);
            dbHandler.deletingLine(deleting);

            DeleteApplications.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setHeaderText("Заявка удалена.");
                    alert.showAndWait();
                }
            });
        }
        else {
            DeleteApplications.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setHeaderText("Проверьте коректность данных.");
                    alert.showAndWait();
                }
            });

        }
    }

}
