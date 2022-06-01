package com.ogoma.hr_job_portal.boundaries.jobs.dtos;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
public class JobInput {
    private String title;
    private String description;
    private Integer vacancies;
    private LocalDateTime deadline;
}
