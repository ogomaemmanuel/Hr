package com.ogoma.vue_starter.vue_starter.boundaries.company.models;

import javax.validation.constraints.NotBlank;

public class EmailSettingModel {
    private Long id;
    @NotBlank(message = "Name is required")
    private String name;
    @NotBlank(message = "Email Address is required")
    private String address;
    @NotBlank(message = "SMTP Host is required")
    private String smtpHost;
    @NotBlank(message = "SMTP Port is required")
    private String smtpPort;
    @NotBlank(message = "SMTP Name is required")
    private String smtpUser;
    @NotBlank(message = "SMTP Password is required")
    private String smtpPassword;
    private String smtpSecurity;
    @NotBlank(message = "Domain Authentication is required")
    private String domainAuthentication;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }

    public String getSmtpHost() {
        return smtpHost;
    }
    public void setSmtpHost(String smtpHost) {
        this.smtpHost = smtpHost;
    }

    public String getSmtpPort() {
        return smtpPort;
    }
    public void setSmtpPort(String smtpPort) {
        this.smtpPort = smtpPort;
    }

    public String getSmtpUser() {
        return smtpUser;
    }
    public void setSmtpUser(String smtpUser) {
        this.smtpUser = smtpUser;
    }

    public String getSmtpPassword() {
        return smtpPassword;
    }
    public void setSmtpPassword(String smtpPassword) {
        this.smtpPassword = smtpPassword;
    }

    public String getSmtpSecurity() {
        return smtpSecurity;
    }
    public void setSmtpSecurity(String smtpSecurity) {
        this.smtpSecurity = smtpSecurity;
    }

    public String getDomainAuthentication() {
        return domainAuthentication;
    }
    public void setDomainAuthentication(String domainAuthentication) {
        this.domainAuthentication = domainAuthentication;
    }
}
