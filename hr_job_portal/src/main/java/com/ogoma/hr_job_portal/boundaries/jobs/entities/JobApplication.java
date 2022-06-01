package com.ogoma.hr_job_portal.boundaries.jobs.entities;

import com.ogoma.hr_job_portal.boundaries.access_control.entities.User;
import com.ogoma.hr_job_portal.common.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "job_applications")
@Setter
@Getter
public class JobApplication extends BaseEntity {
    @ManyToOne(fetch = FetchType.LAZY)
    private User applicant;
    @ManyToOne(fetch = FetchType.LAZY)
    private Job job;
}
