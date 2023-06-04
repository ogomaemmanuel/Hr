package com.ogoma.hr_core.boundaries.chat.projections;

import liquibase.pro.packaged.S;

import java.time.LocalDate;

public interface ChatConversationsProjection {
    public Long getUserId();

    public String getUsername();

    public String getFullName();

    public String getLastChatMessage();

    public LocalDate getLastChatTime();
}
