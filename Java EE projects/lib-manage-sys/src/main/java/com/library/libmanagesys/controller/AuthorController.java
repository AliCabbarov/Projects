package com.library.libmanagesys.controller;

import com.library.libmanagesys.model.dto.request.AuthorRequestDto;
import com.library.libmanagesys.model.dto.response.AuthorResponseDto;
import com.library.libmanagesys.service.AuthorService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/authors")
@RequiredArgsConstructor
@Slf4j
public class AuthorController {
    private final AuthorService authorService;
    @GetMapping()
    public ResponseEntity<Page<AuthorResponseDto>> findAll(@RequestParam("size") int size, @RequestParam("page") int page) {
        log.info("GET - request mapping - @RequestParam size: {} , @RequestMapping page: {} , ",size,page);
        return authorService.findAll(size, page);
    }
    @GetMapping("/{id}")
    public ResponseEntity<AuthorResponseDto> findById(@PathVariable long id){
        log.info("GET - request mapping - @PathVariable {}",id);
        return authorService.finById(id);
    }
    @PostMapping
    public ResponseEntity<AuthorResponseDto> createAuthor(@RequestBody AuthorRequestDto authorRequestDto){
        log.info("POST - Request mapping - AuthorRequestDto: {}",authorRequestDto);
        return authorService.create(authorRequestDto);
    }

}
