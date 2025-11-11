package io.caelusresearch.aqrspringbootworkshop.apis;

import io.caelusresearch.aqrspringbootworkshop.dtos.AuthorCreateRequest;
import io.caelusresearch.aqrspringbootworkshop.dtos.AuthorResponse;
import io.caelusresearch.aqrspringbootworkshop.dtos.AuthorUpdateRequest;
import io.caelusresearch.aqrspringbootworkshop.services.AuthorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/authors")
public class AuthorApi {
    private final AuthorService authorService;


    public AuthorApi(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping
    public ResponseEntity<List<AuthorResponse>> getAll() {
        return ResponseEntity.ok(authorService.getAll());
    }

    @GetMapping("{authorId}")
    public ResponseEntity<AuthorResponse> getById(@PathVariable int authorId) {
        return ResponseEntity.ok(authorService.getById(authorId));
    }

    @PostMapping
    public ResponseEntity<AuthorResponse> create(@RequestBody AuthorCreateRequest request) {
        return ResponseEntity.ok(authorService.create(request));
    }

    @PutMapping("{authorId}")
    public ResponseEntity<AuthorResponse> update(@PathVariable int authorId, @RequestBody AuthorUpdateRequest request) {
        return ResponseEntity.ok(authorService.update(authorId, request));
    }

    @DeleteMapping("{authorId}")
    public ResponseEntity<Void> deleteById(@PathVariable int authorId) {
        authorService.deleteById(authorId);
        return ResponseEntity.noContent().build();
    }
}
