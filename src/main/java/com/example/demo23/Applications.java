package com.example.demo23;

public class Applications {
    int idUserRequests;
    String ClientName, ClientAddress,CustomerNumber,ApplicationService;

    public Applications(int idUserRequests, String clientName, String clientAddress, String customerNumber, String applicationService) {
        this.idUserRequests = idUserRequests;
        ClientName = clientName;
        ClientAddress = clientAddress;
        CustomerNumber = customerNumber;
        ApplicationService = applicationService;
    }

    public int getIdUserRequests() {
        return idUserRequests;
    }

    public void setIdUserRequests(int idUserRequests) {
        this.idUserRequests = idUserRequests;
    }

    public String getClientName() {
        return ClientName;
    }

    public void setClientName(String clientName) {
        ClientName = clientName;
    }

    public String getClientAddress() {
        return ClientAddress;
    }

    public void setClientAddress(String clientAddress) {
        ClientAddress = clientAddress;
    }

    public String getCustomerNumber() {
        return CustomerNumber;
    }

    public void setCustomerNumber(String customerNumber) {
        CustomerNumber = customerNumber;
    }

    public String getApplicationService() {
        return ApplicationService;
    }

    public void setApplicationService(String applicationService) {
        ApplicationService = applicationService;
    }
}
