package com.library.libmanagesys.service.impl;

import com.library.libmanagesys.model.dto.request.BookRequestDto;
import com.library.libmanagesys.model.dto.request.FilterBookRequestDto;
import com.library.libmanagesys.model.dto.response.BookResponseDto;
import com.library.libmanagesys.model.entity.Author;
import com.library.libmanagesys.model.entity.Book;
import com.library.libmanagesys.model.enums.Status;
import com.library.libmanagesys.model.exceptions.ApplicationException;
import com.library.libmanagesys.model.mapper.BookMapper;
import com.library.libmanagesys.repository.AuthorRepository;
import com.library.libmanagesys.service.AutonomusBookService;
import com.library.libmanagesys.repository.BookRepository;
import com.library.libmanagesys.service.BookService;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.cfg.EJB3DTDEntityResolver;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

import static com.library.libmanagesys.model.enums.Exceptions.NOT_FOUND;

@RequiredArgsConstructor
@Service // repository
@Slf4j
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;
    private final BookMapper bookMapper;
    private final AuthorRepository authorRepository;
    private final AutonomusBookService autonomusBookService;

    @Override
    public ResponseEntity<Page<BookResponseDto>> getAll(FilterBookRequestDto request, int size, int page) {
        Pageable pageable = PageRequest.of(page, size);

        if (request == null) {


            Page<BookResponseDto> bookResponseDtosPage = bookRepository.findAll(pageable)
                    .map(bookMapper::map);

            return ResponseEntity.ok(bookResponseDtosPage);

        } else {
            //Fixme: how to use Pageable?
            List<BookResponseDto> collect = bookRepository.findBy(request.getName(), request.getGenre(), request.getDescription(), request.getAuthorName(), request.getAuthorSurname()).stream()
                    .map(bookMapper::map)
                    .collect(Collectors.toList());
            Page<BookResponseDto> bookResponseDtos = new PageImpl<>(collect, pageable, bookRepository.count());

            return ResponseEntity.ok(bookResponseDtos);
        }
    }

    @Override
    public ResponseEntity<BookResponseDto> getById(long id) {
        Book book = findBookById(id);
        log.info("book cap et 572 => {}",book.toString());
        BookResponseDto bookResponseDto = bookMapper.map(book);
        log.info("mapper kecirildi 571");

        return ResponseEntity.ok(bookResponseDto);
    }

    @Override
    public ResponseEntity<Void> deleteById(long id) {
        findBookById(id);

        bookRepository.deleteById(id);

        return ResponseEntity.noContent().build();
    }

    @Override
    @Transactional
    public ResponseEntity<Void> updateById(BookRequestDto request) {
        Book book = findBookById(request.getId());
        Book newBook = bookMapper.map(request);
        newBook.setAuthors(book.getAuthors());

        bookRepository.save(newBook);


        return ResponseEntity.noContent().build();
    }

    @Override
    @Transactional()
    public ResponseEntity<Void> updateDescriptionById(long id, String desc) {
        Book book = findBookById(id);
        book.setDescription(desc);

        return ResponseEntity.noContent().build();
    }

    /**
     * here use propagation
     **/
    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public ResponseEntity<BookResponseDto> createBook(BookRequestDto request) {
        Book book = bookMapper.map(request);
        List<Author> authors = request.getAuthors().stream()
                .map(authorRepository::findById)
                .map(authorOptional -> authorOptional.orElseThrow(() -> new ApplicationException(NOT_FOUND))).collect(Collectors.toList());


        book.setAuthors(authors);

        Book saved = autonomusBookService.saveBook(book, Status.PROGRESS);

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        Book saveBook = autonomusBookService.saveBook(saved, Status.READY);

        BookResponseDto bookResponseDto = bookMapper.map(saveBook);

        return ResponseEntity.ok(bookResponseDto);
    }


    @SneakyThrows
    private Book findBookById(long id) {
        return bookRepository.findById(id).orElseThrow(() -> new ApplicationException(NOT_FOUND));
    }


}
