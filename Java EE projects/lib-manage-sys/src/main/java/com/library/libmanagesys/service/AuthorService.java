package com.library.libmanagesys.service;


import com.library.libmanagesys.model.dto.request.AuthorRequestDto;
import com.library.libmanagesys.model.dto.response.AuthorResponseDto;
import com.library.libmanagesys.model.entity.Author;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface AuthorService {
    ResponseEntity<Page<AuthorResponseDto>> findAll(int size,int page);

    ResponseEntity<AuthorResponseDto> finById(long id);

    ResponseEntity<AuthorResponseDto> create(AuthorRequestDto authorRequestDto);
}
