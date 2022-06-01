package com.ogoma.hr_job_portal.common;

import com.ogoma.hr_job_portal.boundaries.QueryBuilder;
import com.querydsl.core.types.EntityPath;
import graphql.schema.DataFetchingFieldSelectionSet;

import javax.persistence.EntityManager;
import java.util.List;

public class CustomRepo <T>{
    private EntityManager entityManager;

    protected QueryBuilder<T> createQueryBuilder(DataFetchingFieldSelectionSet selectionSet, EntityPath<T> entityPathFrom) {
        return new QueryBuilder<>(getEntityManager(), selectionSet, entityPathFrom);
    }
    protected EntityManager getEntityManager(){
        return entityManager;
    }
}
