package com.library.libmanagesys.model.dto.request;

import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class BookRequestDto {
    private long id;
    private String name;
    private String genre;
    private String description;
    private List<Long> authors;
}
