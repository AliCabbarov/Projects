package com.library.libmanagesys.model.dto.request;

import lombok.*;

@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class FilterBookRequestDto {
    String description;
    String name;
    String genre;
    String authorName;
    String authorSurname;
}
