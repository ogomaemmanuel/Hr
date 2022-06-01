package com.ogoma.hr_job_portal.boundaries;

import com.querydsl.core.types.CollectionExpression;
import com.querydsl.core.types.EntityPath;
import com.querydsl.core.types.Expression;
import com.querydsl.core.types.Path;
import com.querydsl.jpa.impl.JPAQuery;
import graphql.schema.DataFetchingFieldSelectionSet;

import javax.persistence.EntityManager;

import java.util.ArrayList;
import java.util.List;

public class QueryBuilder<T> {
    private final DataFetchingFieldSelectionSet selectionSet;
    private final List<Expression<?>> pathList = new ArrayList<>();
    private JPAQuery<T> query;

    public <T> QueryBuilder(EntityManager entityManager, DataFetchingFieldSelectionSet selectionSet, EntityPath<T> entityPathFrom) {
        query = new JPAQuery<>(entityManager);
        this.selectionSet = selectionSet;
        this.from(entityPathFrom);
    }

    public JPAQuery<T> from(EntityPath<?> entityPath) {
        query = query.from(entityPath);
        return query;
    }

    public <P> JPAQuery<?> innerJoin(EntityPath<P> entityPath, Path<P> alias) {
        query = query.innerJoin(entityPath, alias);
        return query;
    }

    public <P> JPAQuery<?> innerJoin(CollectionExpression<?,P> target, Path<P> alias) {
        query = query.innerJoin(target, alias);
        return query;
    }

    public <P> JPAQuery<?> leftJoin(CollectionExpression<?,P> target, Path<P> alias) {
        query = query.leftJoin(target, alias);
        return query;
    }
    public <P> JPAQuery<?> leftJoin(EntityPath<P> entityPath, Path<P> alias) {
        query = query.innerJoin(entityPath, alias);
        return query;
    }

    public void select(List<Expression<?>> expressionList) {
        pathList.addAll(expressionList);
    }

    public void select(Expression<?> expression) {
        pathList.add(expression);
    }

    public JPAQuery<T> build() {
        return query;
    }

    public DataFetchingFieldSelectionSet getSelectionSet() {
        return selectionSet;
    }

}
