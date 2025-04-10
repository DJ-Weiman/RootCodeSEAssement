package com.djw.rootcodeSEAssessment.services;

import com.djw.rootcodeSEAssessment.domain.dto.BookDto;
import com.djw.rootcodeSEAssessment.domain.entities.BookEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BookService {
    BookDto createBook(BookDto bookDto);
    List<BookDto> getAllAvailableBooks();
    List<BookDto> getAllBooks();
    Page<BookDto> findAll(Pageable pageable);
    List<BookDto> getBooksByAuthor(String authorName);
    List<BookDto> getBooksPublishedInYear(String publishedYear);
}
