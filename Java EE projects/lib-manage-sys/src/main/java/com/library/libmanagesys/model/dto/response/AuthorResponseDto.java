package com.library.libmanagesys.model.dto.response;

import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class AuthorResponseDto {
    private long id;
    private String name;
    private String surname;
    private String description;
    private List<BookResponseDto> books;
}
