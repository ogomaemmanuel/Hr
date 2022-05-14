package com.ogoma.hr_core.boundaries.project_management.models;

public interface ClientProjection {
    public Long getId();

    public String getCompanyName();

    public String getDescription();

    public UserInfo getUser();

    default String getEmail() {
        return this.getUser().getEmail();
    }

    interface UserInfo {
        Long getId();

        public String getFirstName();

        public String getLastName();

        public String getEmail();

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
}
