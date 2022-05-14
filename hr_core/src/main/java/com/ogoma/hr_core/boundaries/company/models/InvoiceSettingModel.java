package com.ogoma.hr_core.boundaries.company.models;

import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotBlank;

public class InvoiceSettingModel {
    private Long id;
    @NotBlank(message = "Invoice prefix is required")
    private String prefix;
    private MultipartFile logoUrl;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getPrefix() {
        return prefix;
    }
    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public MultipartFile getLogoUrl() {
        return logoUrl;
    }
    public void setLogoUrl(MultipartFile logoUrl) {
        this.logoUrl = logoUrl;
    }
}
