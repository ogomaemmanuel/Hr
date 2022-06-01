package com.ogoma.hr_job_portal.boundaries.jobs.entities;

import com.ogoma.hr_job_portal.common.BaseEntity;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "jobs")
@Data
@NoArgsConstructor
public class Job extends BaseEntity {
    private String description;
    private String title;
    private LocalDateTime deadline;
    private Integer vacancies;
    @ManyToOne(fetch = FetchType.LAZY)
    private JobCategory category;
}
