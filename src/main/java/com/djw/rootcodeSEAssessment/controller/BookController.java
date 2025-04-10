package com.djw.rootcodeSEAssessment.controller;

import com.djw.rootcodeSEAssessment.domain.dto.BookDto;
import com.djw.rootcodeSEAssessment.domain.dto.UserDto;
import com.djw.rootcodeSEAssessment.services.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/library/books")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping()
    public ResponseEntity<BookDto> createBook(@RequestBody BookDto book){
        BookDto savedBook = bookService.createBook(book);
        return new ResponseEntity<>(savedBook, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<BookDto>> getAllUsers(){
        List<BookDto> savedBooks = bookService.getAllAvailableBooks();
        return new ResponseEntity<>(savedBooks, HttpStatus.OK);
    }

    @GetMapping(path = "/{authorName}")
    public ResponseEntity<List<BookDto>> getBooksByAuthor(@PathVariable("authorName") String authorName){
        List<BookDto> booksByAuthor = bookService.getBooksByAuthor(authorName);
        return new ResponseEntity<>(booksByAuthor, HttpStatus.OK);
    }

    @GetMapping(path = "/{publishedYear}")
    public ResponseEntity<List<BookDto>> getBooksFromYear(@PathVariable("publishedYear") String publishedYear){
        List<BookDto> booksFromPublishedYear = bookService.getBooksPublishedInYear(publishedYear);
        return new ResponseEntity<>(booksFromPublishedYear, HttpStatus.OK);
    }
}
