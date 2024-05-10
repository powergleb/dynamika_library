package com.powergleb.dynamika.dto.reservation;

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
    public long bookId;
    @NotNull(message = "Введите ваш id")
    public long clientId;

}