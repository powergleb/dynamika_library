package com.powergleb.dynamika.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReservationCreateDto {

    @NotNull(message = "Введите id книги, которую хотите взять")
    @NotBlank(message = "Введите id книги, которую хотите взять")
    public long bookId;
    @NotNull(message = "Введите ваш id")
    @NotBlank(message = "Введите ваш id")
    public long clientId;

}