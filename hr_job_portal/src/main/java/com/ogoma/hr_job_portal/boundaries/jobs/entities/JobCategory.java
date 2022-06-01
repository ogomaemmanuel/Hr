package com.ogoma.hr_job_portal.boundaries.jobs.entities;

import com.ogoma.hr_job_portal.common.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "job_categories")
@Setter
@Getter
public class JobCategory  extends BaseEntity {
    private String name;

}
