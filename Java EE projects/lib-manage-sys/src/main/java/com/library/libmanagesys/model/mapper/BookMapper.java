package com.library.libmanagesys.model.mapper;

import com.library.libmanagesys.model.dto.request.BookRequestDto;
import com.library.libmanagesys.model.dto.response.BookResponseDto;
import com.library.libmanagesys.model.entity.Book;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface BookMapper {
    BookResponseDto map(Book book);
    @Mapping(target = "authors",source = "authors",ignore = true)
    @Mapping(target = "status",ignore = true)
    Book map(BookRequestDto bookRequestDto);
}
