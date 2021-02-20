package com.ogoma.vue_starter.vue_starter.models.requests;

import com.ogoma.vue_starter.vue_starter.boundaries.accounting.entities.Estimate;
import com.ogoma.vue_starter.vue_starter.boundaries.accounting.specifications.EstimatesSpecification;
import com.ogoma.vue_starter.vue_starter.boundaries.project_management.entities.Project;
import com.ogoma.vue_starter.vue_starter.boundaries.project_management.specifications.ProjectsSpecifications;
import io.swagger.models.auth.In;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

public class PagedDataRequest {
    private Integer page;
    private Integer pageSize;
    private String searchTerm;

    public Integer getPage() {
        return page;
    }

    public PagedDataRequest setPage(Integer page) {
        this.page = page;
        return this;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public PagedDataRequest setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
        return this;
    }

    public String getSearchTerm() {
        return searchTerm;
    }

    public PagedDataRequest setSearchTerm(String searchTerm) {
        this.searchTerm = searchTerm;
        return this;
    }

    public Pageable toPageable() {
        PageRequest pageRequest = PageRequest.of(this.getPage(), this.getPageSize());
        return pageRequest;
    }

}
