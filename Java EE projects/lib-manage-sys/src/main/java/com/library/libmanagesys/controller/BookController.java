package com.library.libmanagesys.controller;

import com.library.libmanagesys.model.dto.request.BookRequestDto;
import com.library.libmanagesys.model.dto.request.FilterBookRequestDto;
import com.library.libmanagesys.model.dto.response.BookResponseDto;
import com.library.libmanagesys.model.dto.response.ExceptionResponse;
import com.library.libmanagesys.service.BookService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/books")
@RequiredArgsConstructor
@Tag(name = "Book controller", description = "Book operations")
@Slf4j
public class BookController {

    private final BookService bookService;

    @Operation(summary = "find all books", description = "lorem ipsum")
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = BookResponseDto.class)))),
            @ApiResponse(responseCode = "404", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ExceptionResponse.class)))
    })
    @GetMapping
    public ResponseEntity<Page<BookResponseDto>> getAllBooks(@RequestParam("page") int page,
                                                             @RequestParam("size") int size,
                                                             @RequestBody(required = false) FilterBookRequestDto request) {
        log.info("request - GET: size: {}, page: {}, Filter request body: {}", size, page, request);
        return bookService.getAll(request, size, page);

    }

    @GetMapping("/{id}")
    public ResponseEntity<BookResponseDto> getById(@PathVariable long id) {
        return bookService.getById(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable long id) {
        return bookService.deleteById(id);
    }

    @PutMapping
    public ResponseEntity<Void> updateById(@RequestBody BookRequestDto request) {
        return bookService.updateById(request);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Void> updateDescriptionById(@PathVariable long id, @RequestParam("desc") String desc) {
        return bookService.updateDescriptionById(id, desc);
    }

    @PostMapping
    public ResponseEntity<BookResponseDto> createBook(@RequestBody BookRequestDto request) {
        return bookService.createBook(request);
    }
}
