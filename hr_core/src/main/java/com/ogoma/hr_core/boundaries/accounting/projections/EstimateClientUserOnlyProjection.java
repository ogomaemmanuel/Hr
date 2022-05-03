package com.ogoma.hr_core.boundaries.accounting.projections;

public interface EstimateClientUserOnlyProjection {

    public Long getId();

    public ClientDetails getClient();

    public static interface ClientDetails {
        Long getClientId();

        public UserDetails getUser();
    }

    public static interface UserDetails {
        Long getId();
    }
}


