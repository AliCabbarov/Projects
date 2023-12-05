package com.library.libmanagesys.model.dto.response;

import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class BookResponseDto {
    private long id;
    private String name;
    private String genre;
    private String description;
    private List<AuthorResponseDto> authors;
}
