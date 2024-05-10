package com.powergleb.dynamika.dto.book;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class BookCreateDto {

    @NotNull(message = "У книги должно быть название!")
    @NotBlank(message = "У книги должно быть название!")
    private String name;
    @NotNull(message = "У книги должен быть автор!")
    @NotBlank(message = "У книги должен быть автор!")
    private String author;
    @NotNull(message = "У книги должен быть номер ISBN!")
    @NotBlank(message = "У книги должен быть номер ISBN!")
    private String isbn;
}