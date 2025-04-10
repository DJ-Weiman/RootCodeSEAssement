package com.djw.rootcodeSEAssessment.services;

import com.djw.rootcodeSEAssessment.domain.dto.BookDto;

import java.util.List;

public interface BookService {
    BookDto createBook(BookDto bookDto);
    List<BookDto> getAllAvailableBooks();
    List<BookDto> getAllBooks();
    List<BookDto> getBooksByAuthor(String authorName);
    List<BookDto> getBooksPublishedInYear(String publishedYear);
}
