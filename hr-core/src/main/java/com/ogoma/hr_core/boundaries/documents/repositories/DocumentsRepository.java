package com.ogoma.vue_starter.vue_starter.boundaries.documents.repositories;

import com.ogoma.vue_starter.vue_starter.boundaries.documents.entities.Document;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DocumentsRepository extends JpaRepository<Document,Long> {
}
