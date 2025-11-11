package io.caelusresearch.aqrspringbootworkshop.services;

import io.caelusresearch.aqrspringbootworkshop.dtos.BookCreateRequest;
import io.caelusresearch.aqrspringbootworkshop.dtos.BookResponse;
import io.caelusresearch.aqrspringbootworkshop.dtos.BookUpdateRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImplementation implements BookService {
    @Override
    public List<BookResponse> getAll() {
        return List.of();
    }

    @Override
    public BookResponse getById(int bookId) {
        return null;
    }

    @Override
    public BookResponse create(BookCreateRequest request) {
        return null;
    }

    @Override
    public BookResponse update(int bookId, BookUpdateRequest request) {
        return null;
    }

    @Override
    public void deleteById(int bookId) {

    }
}
