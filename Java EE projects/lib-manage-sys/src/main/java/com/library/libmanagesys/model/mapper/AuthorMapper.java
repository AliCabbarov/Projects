package com.library.libmanagesys.model.mapper;

import com.library.libmanagesys.model.dto.request.AuthorRequestDto;
import com.library.libmanagesys.model.dto.response.AuthorResponseDto;
import com.library.libmanagesys.model.entity.Author;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AuthorMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "books", ignore = true)
    Author map(AuthorRequestDto authorRequestDto);
    AuthorResponseDto map(Author author);
}
