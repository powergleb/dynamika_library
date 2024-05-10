package com.powergleb.dynamika.api;


import com.powergleb.dynamika.dto.book.BookCreateDto;
import com.powergleb.dynamika.dto.book.BookDto;
import com.powergleb.dynamika.entity.Book;
import com.powergleb.dynamika.mapper.BookMapper;
import com.powergleb.dynamika.service.BookService;
import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/rest-api-books")
@RequiredArgsConstructor
public class BookRestApi {

    private final BookService bookService;
    private BookMapper bookMapper = new BookMapper();

    @GetMapping("/getAllBooks")
    public ResponseEntity<List<BookDto>> getAllBooks() {
        return ResponseEntity.ok(bookMapper.toDtoList(bookService.getAllBooks()));
    }

    @PostMapping("/addBook")
    public ResponseEntity<BookDto> addBook(@Valid @RequestBody BookCreateDto bookDto) {
        Book addedBook = bookService.addBook(bookMapper.toEntity(bookDto));
        return ResponseEntity.status(HttpStatus.CREATED).body(bookMapper.toDto(addedBook));
    }

    @PutMapping("/updateBook")
    public ResponseEntity<BookDto> updateBook(@Valid @RequestBody BookCreateDto bookDto, @RequestParam("id") long id) {
        Book updatedBook = bookService.updateBook(bookMapper.toEntity(bookDto), id);
        return ResponseEntity.ok(bookMapper.toDto(updatedBook));
    }
}