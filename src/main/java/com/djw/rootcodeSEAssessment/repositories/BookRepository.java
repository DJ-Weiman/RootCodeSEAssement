package com.djw.rootcodeSEAssessment.repositories;

import com.djw.rootcodeSEAssessment.domain.entities.BookEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface BookRepository extends CrudRepository<BookEntity, UUID> {

    @Query("SELECT b FROM BookEntity b WHERE b.available_copies > 0")
    Iterable<BookEntity> findAvailableBooks();

}
