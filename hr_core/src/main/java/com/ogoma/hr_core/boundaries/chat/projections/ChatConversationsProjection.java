package com.ogoma.hr_core.boundaries.chat.projections;


import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;

public interface ChatConversationsProjection {
    public Long getUserId();

    public String getUsername();

    public String getFirstName();

    public String getLastName();
@JsonProperty
    public String getLastMessage();
@JsonProperty
    public LocalDate getTime();

    public default String getFullName(){
        return String.format("%s %s",getFirstName()==null?"":getFirstName(),getLastName()==null?"":getLastName());
    }
}
