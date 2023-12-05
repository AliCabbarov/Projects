package com.library.libmanagesys.service;

import com.library.libmanagesys.model.dto.request.BookRequestDto;
import com.library.libmanagesys.model.dto.request.FilterBookRequestDto;
import com.library.libmanagesys.model.dto.response.BookResponseDto;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;

public interface BookService {
    ResponseEntity<Page<BookResponseDto>> getAll(FilterBookRequestDto request, int size, int page);

    ResponseEntity<BookResponseDto> getById(long id);

    ResponseEntity<Void> deleteById(long id);

    ResponseEntity<Void> updateById(BookRequestDto request);

    ResponseEntity<Void> updateDescriptionById(long id, String desc);

    ResponseEntity<BookResponseDto> createBook(BookRequestDto request);
}
