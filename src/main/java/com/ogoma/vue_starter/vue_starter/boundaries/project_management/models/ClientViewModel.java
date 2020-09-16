package com.ogoma.vue_starter.vue_starter.boundaries.project_management.models;

public interface ClientViewModel {
    public Long getId();
    public String getCompanyName();
    //contact person
    public  String getFirstName();
    //contact person
    public String getLastName();
    public String getPhone();
    default String getFullName() {
        String lastName = null;
        if (null != getLastName()) {
            lastName = getLastName();
        }
        if (null != getFirstName()) {
            return getFirstName().concat(" ").concat(lastName);
        }
        return "";
    }
}
