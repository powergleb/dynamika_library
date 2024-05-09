package com.powergleb.dynamika.service;

import com.powergleb.dynamika.entity.Book;
import com.powergleb.dynamika.exception.BookNotFoundException;
import com.powergleb.dynamika.repo.BookRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepo bookRepository;

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Book addBook(Book book) {
        return bookRepository.saveAndFlush(book);
    }

    public Book updateBook(Book book, long id) {
        if (!bookRepository.existsById(id)) {
            throw new BookNotFoundException(id);
        }
        book.setId(id);

        return bookRepository.saveAndFlush(book);
    }
}