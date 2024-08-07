package com.Bank.managementSystem.Security;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AdminConfig {

    @Value("${admin.username}")
    private String adminUsername;

    @Value("${admin.password}")
    private String adminPassword;

    public String getAdminUsername() {
        return "admin";
    }

    public String getAdminPassword() {
        return "adminPass";
    }
}
