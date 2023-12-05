package com.library.libmanagesys.service.impl;

import com.library.libmanagesys.model.entity.Book;
import com.library.libmanagesys.model.enums.Status;
import com.library.libmanagesys.service.AutonomusBookService;
import com.library.libmanagesys.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
@Service
@RequiredArgsConstructor
public class AutonomusBookServiceImpl implements AutonomusBookService {
    private final BookRepository bookRepository;
    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public Book saveBook(Book book, Status status) {
        book.setStatus(status);
        return bookRepository.save(book);
    }
}
