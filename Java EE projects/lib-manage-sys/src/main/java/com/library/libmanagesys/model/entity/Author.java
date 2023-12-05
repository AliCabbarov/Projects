package com.library.libmanagesys.model.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity(name = "authors")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String surname;
    private String description;
    @ManyToMany(mappedBy = "authors",fetch = FetchType.EAGER)
    private List<Book> books;
}
