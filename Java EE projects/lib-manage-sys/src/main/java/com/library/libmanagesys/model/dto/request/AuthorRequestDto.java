package com.library.libmanagesys.model.dto.request;


import lombok.*;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class AuthorRequestDto {
    private String name;
    private String surname;
    private String description;
}
