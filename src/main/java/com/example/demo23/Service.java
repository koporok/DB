package com.example.demo23;

public class Service {
    private String lastName;
    private String CustomerNumber;
    private String ClientAddress;
    private String Service;

    public Service(String lastName, String customerNumber, String clientAddress, String service) {
        this.lastName = lastName;
        CustomerNumber = customerNumber;
        ClientAddress = clientAddress;
        Service = service;
    }

    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {this.lastName = lastName;}
    public String getCustomerNumber() {
        return CustomerNumber;
    }
    public void setCustomerNumber(String customerNumber) {
        CustomerNumber = customerNumber;
    }
    public String getClientAddress() {
        return ClientAddress;
    }
    public void setClientAddress(String clientAddress) {
        ClientAddress = clientAddress;
    }
    public String getService() {return Service;}
    public void setService(String service) {Service = service;}
}