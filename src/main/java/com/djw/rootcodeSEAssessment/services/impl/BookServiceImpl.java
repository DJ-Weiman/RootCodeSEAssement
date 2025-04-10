package com.djw.rootcodeSEAssessment.services.impl;

import com.djw.rootcodeSEAssessment.domain.dto.BookDto;
import com.djw.rootcodeSEAssessment.domain.entities.BookEntity;
import com.djw.rootcodeSEAssessment.mappers.Mapper;
import com.djw.rootcodeSEAssessment.repositories.BookRepository;
import com.djw.rootcodeSEAssessment.services.BookService;
import org.springframework.stereotype.Service;

import java.awt.print.Book;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final Mapper<BookEntity, BookDto> bookMapper;

    public BookServiceImpl(BookRepository bookRepository, Mapper<BookEntity, BookDto> bookMapper) {
        this.bookRepository = bookRepository;
        this.bookMapper = bookMapper;
    }

    @Override
    public BookDto createBook(BookDto bookDto) {
        BookEntity savedBook = bookRepository.save(bookMapper.mapFrom(bookDto));

        return bookMapper.mapTo(savedBook);
    }

    @Override
    public List<BookDto> getAllBooks() {
        Iterable<BookEntity> allBooksIterable = bookRepository.findAll();

        return StreamSupport
                .stream(allBooksIterable.spliterator(), false)
                .map(bookMapper::mapTo)
                .collect(Collectors.toList());
    }

    @Override
    public List<BookDto> getAllAvailableBooks() {
        Iterable<BookEntity> availableBookIterable = bookRepository.findAvailableBooks();

        return StreamSupport
                .stream(availableBookIterable.spliterator(), false)
                .map(bookMapper::mapTo)
                .collect(Collectors.toList());
    }

    @Override
    public List<BookDto> getBooksByAuthor(String authorName) {
        Iterable<BookEntity> booksByAuthorIterable = bookRepository.getBooksByAuthor(authorName);

        return StreamSupport
                .stream(booksByAuthorIterable.spliterator(), false)
                .map(bookMapper::mapTo)
                .collect(Collectors.toList());
    }

    @Override
    public List<BookDto> getBooksPublishedInYear(String publishedYear) {
        Iterable<BookEntity> booksPublishedInYearIterable = bookRepository.getBooksPublishedInYear(publishedYear);

        return StreamSupport
                .stream(booksPublishedInYearIterable.spliterator(), false)
                .map(bookMapper::mapTo)
                .collect(Collectors.toList());
    }


}
