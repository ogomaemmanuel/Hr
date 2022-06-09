package com.ogoma.hr_core.utils;

import com.ogoma.hr_core.models.requests.PagedDataRequest;

import java.util.List;

public class DataFilter extends PagedDataRequest {
    public enum QueryOperator {
        EQUALS, NOT_EQUALS,
        GREATER_THAN, LESS_THAN, LIKE, IN
    }
    private String field;
    private QueryOperator operator;
    private String value;
    private List<String> values;//Used in case of IN operator

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public QueryOperator getOperator() {
        return operator;
    }

    public void setOperator(QueryOperator operator) {
        this.operator = operator;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public List<String> getValues() {
        return values;
    }

    public void setValues(List<String> values) {
        this.values = values;
    }
}
