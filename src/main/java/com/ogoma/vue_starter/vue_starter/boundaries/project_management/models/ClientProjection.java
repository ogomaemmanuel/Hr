package com.ogoma.vue_starter.vue_starter.boundaries.project_management.models;
public interface ClientProjection {
    public Long getId();

    public String getCompanyName();

    public String getDescription();

    public UserInfo getUser();

    interface UserInfo {
        Long getId();

        public String getFirstName();

        public String getLastName();

        public String getPhone();

        public String getEmail();

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
