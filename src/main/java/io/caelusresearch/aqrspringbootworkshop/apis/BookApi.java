package io.caelusresearch.aqrspringbootworkshop.apis;

import io.caelusresearch.aqrspringbootworkshop.dtos.BookCreateRequest;
import io.caelusresearch.aqrspringbootworkshop.dtos.BookResponse;
import io.caelusresearch.aqrspringbootworkshop.dtos.BookUpdateRequest;
import io.caelusresearch.aqrspringbootworkshop.services.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/books")
public class BookApi {
    private final BookService bookService;


    public BookApi(BookService bookService) {
        this.bookService = bookService;
    }
    
    @GetMapping
    public ResponseEntity<List<BookResponse>> getAll() {
        return ResponseEntity.ok(bookService.getAll());
    }
    
    @GetMapping("{bookId}")
    public ResponseEntity<BookResponse> getById(@PathVariable int bookId) {
        return ResponseEntity.ok(bookService.getById(bookId));
    }
    
    @PostMapping
    public ResponseEntity<BookResponse> create(@RequestBody BookCreateRequest request) {
        return ResponseEntity.ok(bookService.create(request));
    }
    
    @PutMapping("{bookId}")
    public ResponseEntity<BookResponse> update(@PathVariable int bookId, @RequestBody BookUpdateRequest request) {
        return ResponseEntity.ok(bookService.update(bookId, request));
    }
    
    @DeleteMapping("{bookId}")
    public ResponseEntity<Void> deleteById(@PathVariable int bookId) {
        bookService.deleteById(bookId);
        return ResponseEntity.noContent().build();
    }
}
