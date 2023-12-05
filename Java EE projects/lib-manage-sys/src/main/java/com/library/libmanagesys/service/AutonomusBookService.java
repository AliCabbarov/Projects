package com.library.libmanagesys.service;

import com.library.libmanagesys.model.entity.Book;
import com.library.libmanagesys.model.enums.Status;

public interface AutonomusBookService {
    Book saveBook(Book book, Status status);
}
