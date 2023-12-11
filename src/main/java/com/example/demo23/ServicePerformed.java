package com.example.demo23;

public class ServicePerformed {
    private String name;
    private String Registered;
    private String Address;
    private String Phone;

    public ServicePerformed(String name, String registered, String address, String phone, String term, String cost) {
        this.name = name;
        Registered = registered;
        Address = address;
        Phone = phone;
        Term = term;
        Cost = cost;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getRegistered() {
        return Registered;
    }
    public void setRegistered(String registered) {
        Registered = registered;
    }
    public String getAddress() {
        return Address;
    }
    public void setAddress(String address) {
        Address = address;
    }
    public String getPhone() {
        return Phone;
    }
    public void setPhone(String phone) {
        Phone = phone;
    }
    public String getTerm() {
        return Term;
    }
    public void setTerm(String term) {
        Term = term;
    }
    public String getCost() {
        return Cost;
    }
    public void setCost(String cost) {
        Cost = cost;
    }
    private String Term;
    private String Cost;
}
