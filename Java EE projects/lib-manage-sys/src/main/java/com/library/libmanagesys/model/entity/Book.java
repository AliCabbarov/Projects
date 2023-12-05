package com.library.libmanagesys.model.entity;

import com.library.libmanagesys.model.enums.Status;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity(name = "books")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String genre;
    private String description;
    @Enumerated(EnumType.STRING)
    private Status status;
    @ManyToMany(cascade = CascadeType.PERSIST,fetch = FetchType.EAGER)
    private List<Author> authors;
}
