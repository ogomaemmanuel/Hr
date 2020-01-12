package com.ogoma.vue_starter.vue_starter.models.requests;

import io.swagger.models.auth.In;

public class PagedDataRequest {
    private Integer page;
    private Integer pageSize;
    private String searchTearm;

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

    public String getSearchTearm() {
        return searchTearm;
    }

    public PagedDataRequest setSearchTearm(String searchTearm) {
        this.searchTearm = searchTearm;
        return this;
    }
}
