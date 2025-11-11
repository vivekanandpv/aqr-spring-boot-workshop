package io.caelusresearch.aqrspringbootworkshop.services;

import io.caelusresearch.aqrspringbootworkshop.dtos.BookCreateRequest;
import io.caelusresearch.aqrspringbootworkshop.dtos.BookResponse;
import io.caelusresearch.aqrspringbootworkshop.dtos.BookUpdateRequest;

import java.util.List;

public interface BookService {
    List<BookResponse> getAll();
    BookResponse getById(int bookId);
    BookResponse create(BookCreateRequest request);
    BookResponse update(int bookId, BookUpdateRequest request);
    void deleteById(int bookId);
}
