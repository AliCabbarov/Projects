package com.library.libmanagesys.service.impl;

import com.library.libmanagesys.model.dto.request.AuthorRequestDto;
import com.library.libmanagesys.model.dto.response.AuthorResponseDto;
import com.library.libmanagesys.model.entity.Author;
import com.library.libmanagesys.model.enums.Exceptions;
import com.library.libmanagesys.model.exceptions.ApplicationException;
import com.library.libmanagesys.model.mapper.AuthorMapper;
import com.library.libmanagesys.repository.AuthorRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Slf4j
@RequiredArgsConstructor
public class AuthorService implements com.library.libmanagesys.service.AuthorService {
    private final AuthorRepository authorRepository;
    private final AuthorMapper authorMapper;

    @Override
    public ResponseEntity<Page<AuthorResponseDto>> findAll(int size, int page) {
        Pageable pageable = PageRequest.of(page, size);

        Page<AuthorResponseDto> all = authorRepository.findAll(pageable).map(authorMapper::map);

        return ResponseEntity.ok(all);
    }

    @Override
    public ResponseEntity<AuthorResponseDto> finById(long id) {
        Author author = authorRepository.findById(id).orElseThrow(() -> new ApplicationException(Exceptions.NOT_FOUND));
        AuthorResponseDto authorResponseDto = authorMapper.map(author);
        return ResponseEntity.ok(authorResponseDto);
    }

    @Override
    @Transactional
    public ResponseEntity<AuthorResponseDto> create(AuthorRequestDto authorRequestDto) {
        Author author = authorMapper.map(authorRequestDto);
        Author savedAuthor = authorRepository.save(author);
        AuthorResponseDto map = authorMapper.map(savedAuthor);
        return ResponseEntity.ok(map);
    }
}
