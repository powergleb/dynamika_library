package com.powergleb.dynamika.mapper;

import com.powergleb.dynamika.dto.BookDto;
import com.powergleb.dynamika.dto.BookCreateDto;
import com.powergleb.dynamika.entity.Book;


import java.util.ArrayList;
import java.util.List;

public class BookMapper {

    public static List<BookDto> toDtoList(List<Book> books) {
        List<BookDto> dtos = new ArrayList<>();
        for (Book book : books) {
            dtos.add(toDto(book));
        }
        return dtos;
    }

    public static Book toEntity(BookCreateDto dto) {
        Book book = new Book();
        book.setName(dto.getName());
        book.setAuthor(dto.getAuthor());
        book.setIsbn(dto.getIsbn());
        return book;
    }

    public static Book toEntity(BookDto dto) {
        Book book = new Book();
        book.setId(dto.getId());
        book.setName(dto.getName());
        book.setAuthor(dto.getAuthor());
        book.setIsbn(dto.getIsbn());
        return book;
    }

    public static BookDto toDto(Book book) {
        BookDto dto = new BookDto();
        dto.setId(book.getId());
        dto.setName(book.getName());
        dto.setAuthor(book.getAuthor());
        dto.setIsbn(book.getIsbn());
        return dto;
    }
}
