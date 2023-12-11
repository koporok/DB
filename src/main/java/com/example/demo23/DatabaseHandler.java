package com.example.demo23;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;


public class DatabaseHandler extends Configs {
    Connection dbConnection;

    public Connection getDbConnection()
            throws ClassNotFoundException, SQLException {
                String connectionString = "jdbc:mysql://" + dbHost + ":" + dbPort + "/" + dbName;
                Class.forName("com.mysql.cj.jdbc.Driver");
                dbConnection = DriverManager.getConnection(connectionString, dbUser, dbPass);
                return dbConnection;
    }

    public void signUser(User user) {
        String insert = "INSERT INTO " + Const.USER_TABLE + "(" + Const.USER_FIRSTNAME + ","
                + Const.USER_LASTNAME + "," + Const.USER_USERNAME + "," + Const.USER_PASSWORD + ")" + "VALUES(?,?,?,?)";

        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(insert);
            prSt.setString(1, user.getFirstName());
            prSt.setString(2, user.getLastName());
            prSt.setString(3, user.getUserName());
            prSt.setString(4, user.getPassword());
            prSt.executeUpdate();
        }
        catch (SQLException e) {throw new RuntimeException(e);}
        catch (ClassNotFoundException e) {throw new RuntimeException(e);}
    }

    public ResultSet getUser(User user) {
        ResultSet reSet = null;

        String select = "SELECT * FROM " + Const.USER_TABLE + " WHERE "+ Const.USER_USERNAME+"=? AND "+Const.USER_PASSWORD+"=?";
        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(select);
            prSt.setString(1, user.getUserName());
            prSt.setString(2, user.getPassword());

            reSet = prSt.executeQuery();
        }
        catch (SQLException e){throw new RuntimeException(e);}
        catch (ClassNotFoundException e) {throw new RuntimeException(e);}
        return reSet;
    }
    public void signService (Service service){
        String insert = "INSERT INTO " + Const.Service_TABLE + "("+Const.Service_LASTNAME + "," +
                Const.Service_customerNumber + "," + Const.Service_clientAddress + "," +Const.Service_service + ")" + "VALUES(?,?,?,?)";

        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(insert);
            prSt.setString(1, service.getLastName());
            prSt.setString(2, service.getCustomerNumber());
            prSt.setString(3, service.getClientAddress());
            prSt.setString(4, service.getService());
            prSt.executeUpdate();
        }
        catch (SQLException e) {throw new RuntimeException(e);}
        catch (ClassNotFoundException e) {throw new RuntimeException(e);}

    }
    public void signServiceAdmin (ServicePerformed ServicePerformed){
        String insert = "INSERT INTO " + Const.ServiceAdmin_TABLE + "("+Const.ServiceAdmin_LASTNAME + "," +
                Const.ServiceRegistered + "," + Const.UserAddressService + "," +Const.UserPhoneService + "," +Const.UserTermService + "," +Const.UserCostService + ")" + "VALUES(?,?,?,?,?,?)";

        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(insert);
            prSt.setString(1, ServicePerformed.getName());
            prSt.setString(2, ServicePerformed.getRegistered());
            prSt.setString(3, ServicePerformed.getAddress());
            prSt.setString(4, ServicePerformed.getPhone());
            prSt.setString(5, ServicePerformed.getTerm());
            prSt.setString(6, ServicePerformed.getCost());
            prSt.executeUpdate();
        }
        catch (SQLException e) {throw new RuntimeException(e);}
        catch (ClassNotFoundException e) {throw new RuntimeException(e);}

    }
    public void signService(ServicePerformed ServicePerformed){
        String insert = "INSERT INTO " + Const.ServiceAdmin_TABLE_1 + "("+Const.ServiceAdmin_LASTNAME_1 + "," +
                Const.ServiceRegistered_1 + "," + Const.UserAddressService_1 + "," +Const.UserPhoneService_1 + "," +Const.UserTermService_1 + "," +Const.UserCostService_1 + ")" + "VALUES(?,?,?,?,?,?)";

        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(insert);
            prSt.setString(1, ServicePerformed.getName());
            prSt.setString(2, ServicePerformed.getRegistered());
            prSt.setString(3, ServicePerformed.getAddress());
            prSt.setString(4, ServicePerformed.getPhone());
            prSt.setString(5, ServicePerformed.getTerm());
            prSt.setString(6, ServicePerformed.getCost());
            prSt.executeUpdate();
        }
        catch (SQLException e) {throw new RuntimeException(e);}
        catch (ClassNotFoundException e) {throw new RuntimeException(e);}

    }
    public void deletingLine ( deleting deleting) throws SQLException, ClassNotFoundException {
        String insert = "DELETE FROM " + deleting.getName() + " WHERE "+ deleting.getNameId()+" = " + deleting.getID() +";";

        PreparedStatement prSt = getDbConnection().prepareStatement(insert);
        prSt.executeUpdate();
    }

    public ObservableList<users> Get_All_Users() {
        String select = "SELECT * FROM useraccounts";
        ObservableList<users> list_users = FXCollections.observableArrayList();

        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(select);

            ResultSet resultSet = prSt.executeQuery();

            while (resultSet.next()){
                System.out.println(resultSet.getString("idUserAccounts"));
                //System.out.println();

                list_users.add(new users(resultSet.getInt("idUserAccounts"), resultSet.getString("UserLlastName"),
                        resultSet.getString("UserName"), resultSet.getString("UserLogin"), resultSet.getString("UserPassword")));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return list_users;
    }
    public ObservableList<Applications> Get_All_Applications() {
        String select = "SELECT * FROM userrequests";
        ObservableList<Applications> list_Applications = FXCollections.observableArrayList();

        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(select);

            ResultSet resultSet = prSt.executeQuery();

            while (resultSet.next()){
                list_Applications.add(new Applications(resultSet.getInt("idUserRequests"), resultSet.getString("ClientName"),
                        resultSet.getString("ClientAddress"), resultSet.getString("CustomerNumber"), resultSet.getString("ApplicationService")));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return list_Applications;
    }
    public ObservableList<Service__Table> Get_All_Service() {
        String select = "SELECT * FROM RegisteredService";
        ObservableList<Service__Table> list_Service = FXCollections.observableArrayList();

        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(select);

            ResultSet resultSet = prSt.executeQuery();

            while (resultSet.next()){
                list_Service.add(new Service__Table(resultSet.getInt("idRegisteredService"), resultSet.getString("UserNameService"),
                        resultSet.getString("ServiceRegistered"),resultSet.getString("UserAddressService"), resultSet.getString("UserPhoneService"), resultSet.getString("UserTermService"),resultSet.getString("UserCostService")));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return list_Service;
    }
    public ObservableList<Service__Table> Get_All_Service_1() {
        String select = "SELECT * FROM registeredservice_copy1";
        ObservableList<Service__Table> list_Service = FXCollections.observableArrayList();

        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(select);

            ResultSet resultSet = prSt.executeQuery();

            while (resultSet.next()){
                list_Service.add(new Service__Table(resultSet.getInt("idRegisteredService_1"), resultSet.getString("UserNameService_1"),
                        resultSet.getString("ServiceRegistered_1"),resultSet.getString("UserAddressService_1"), resultSet.getString("UserPhoneService_1"), resultSet.getString("UserTermService_1"),resultSet.getString("UserCostService_1")));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return list_Service;
    }

}
