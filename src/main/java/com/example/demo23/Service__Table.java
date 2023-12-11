package com.example.demo23;

public class Service__Table {
    int idRegisteredService;
    String UserNameService,ServiceRegistered,UserAddressService,UserPhoneService,UserTermService,UserCostService;

    public Service__Table(int idRegisteredService, String userNameService, String serviceRegistered, String userAddressService, String userPhoneService, String userTermService, String userCostService) {
        this.idRegisteredService = idRegisteredService;
        UserNameService = userNameService;
        ServiceRegistered = serviceRegistered;
        UserAddressService = userAddressService;
        UserPhoneService = userPhoneService;
        UserTermService = userTermService;
        UserCostService = userCostService;
    }

    public int getIdRegisteredService() {
        return idRegisteredService;
    }

    public void setIdRegisteredService(int idRegisteredService) {
        this.idRegisteredService = idRegisteredService;
    }

    public String getUserNameService() {
        return UserNameService;
    }

    public void setUserNameService(String userNameService) {
        UserNameService = userNameService;
    }

    public String getServiceRegistered() {
        return ServiceRegistered;
    }

    public void setServiceRegistered(String serviceRegistered) {
        ServiceRegistered = serviceRegistered;
    }

    public String getUserAddressService() {
        return UserAddressService;
    }

    public void setUserAddressService(String userAddressService) {
        UserAddressService = userAddressService;
    }

    public String getUserPhoneService() {
        return UserPhoneService;
    }

    public void setUserPhoneService(String userPhoneService) {
        UserPhoneService = userPhoneService;
    }

    public String getUserTermService() {
        return UserTermService;
    }

    public void setUserTermService(String userTermService) {
        UserTermService = userTermService;
    }

    public String getUserCostService() {
        return UserCostService;
    }

    public void setUserCostService(String userCostService) {
        UserCostService = userCostService;
    }
}
