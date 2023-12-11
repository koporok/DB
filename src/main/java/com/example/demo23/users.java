package com.example.demo23;

public class users extends User {
    int IDTableData;
    String userUserLlastNameTableDataname;
    String UserNameTableData;
    String UserLoginTableData;
    String UserPasswordTableData;

    public int getIDTableData() {
        return IDTableData;
    }

    public void setIDTableData(int IDTableData) {
        this.IDTableData = IDTableData;
    }

    public String getUserUserLlastNameTableDataname() {
        return userUserLlastNameTableDataname;
    }

    public void setUserUserLlastNameTableDataname(String userUserLlastNameTableDataname) {
        this.userUserLlastNameTableDataname = userUserLlastNameTableDataname;
    }

    public String getUserNameTableData() {
        return UserNameTableData;
    }

    public void setUserNameTableData(String userNameTableData) {
        UserNameTableData = userNameTableData;
    }

    public String getUserLoginTableData() {
        return UserLoginTableData;
    }

    public void setUserLoginTableData(String userLoginTableData) {
        UserLoginTableData = userLoginTableData;
    }

    public String getUserPasswordTableData() {
        return UserPasswordTableData;
    }

    public void setUserPasswordTableData(String userPasswordTableData) {
        UserPasswordTableData = userPasswordTableData;
    }

    public users(int IDTableData, String userUserLlastNameTableDataname, String userNameTableData, String userLoginTableData, String userPasswordTableData) {
        this.IDTableData = IDTableData;
        this.userUserLlastNameTableDataname = userUserLlastNameTableDataname;
        this.UserNameTableData = userNameTableData;
        this.UserLoginTableData = userLoginTableData;
        this.UserPasswordTableData = userPasswordTableData;
    }
}
