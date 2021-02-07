#!/bin/bash
function runDiff() {
  ./mvnw liquibase:diff -Dliquibase.diffExcludeObjects="table:spring_.*";
}
function runUpdate() {
    ./mvnw liquibase:update
}