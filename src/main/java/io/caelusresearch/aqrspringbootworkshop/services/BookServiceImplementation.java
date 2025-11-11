package io.caelusresearch.aqrspringbootworkshop.services;

import io.caelusresearch.aqrspringbootworkshop.dtos.*;
import io.caelusresearch.aqrspringbootworkshop.entities.Author;
import io.caelusresearch.aqrspringbootworkshop.entities.Book;
import io.caelusresearch.aqrspringbootworkshop.entities.Publisher;
import io.caelusresearch.aqrspringbootworkshop.exceptions.RecordNotFoundException;
import io.caelusresearch.aqrspringbootworkshop.repositories.AuthorRepository;
import io.caelusresearch.aqrspringbootworkshop.repositories.BookRepository;
import io.caelusresearch.aqrspringbootworkshop.repositories.PublisherRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class BookServiceImplementation implements BookService {
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;
    private final AuthorRepository authorRepository;

    public BookServiceImplementation(BookRepository bookRepository, PublisherRepository publisherRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
        this.authorRepository = authorRepository;
    }

    @Override
    public List<BookResponse> getAll() {
        return bookRepository.findAll().stream().map(this::toResponse).toList();
    }

    @Override
    public BookResponse getById(int bookId) {
        return toResponse(getEntityById(bookId));
    }

    @Override
    public BookResponse create(BookCreateRequest request) {
        Book entity = new Book();
        
        BeanUtils.copyProperties(request, entity);
        
        
        
        entity.setPublisher(
                getPublisherById(request.getPublisherId())
        );

        entity.setAuthors(
                request.getAuthors()
                        .stream()
                        .map(this::getAuthorById)
                        .collect(Collectors.toSet())
        );

        return toResponse(bookRepository.saveAndFlush(entity));
    }

    @Override
    public BookResponse update(int bookId, BookUpdateRequest request) {
        Book entityDb = getEntityById(bookId);
        
        BeanUtils.copyProperties(request, entityDb);
        
        return toResponse(bookRepository.saveAndFlush(entityDb));
    }

    @Override
    public void deleteById(int bookId) {
        bookRepository.delete(getEntityById(bookId));
    }

    private PublisherResponse toResponse(Publisher entity) {
        PublisherResponse response = new PublisherResponse();
        BeanUtils.copyProperties(entity, response);
        return response;
    }

    private AuthorResponse toResponse(Author entity) {
        AuthorResponse response = new AuthorResponse();
        BeanUtils.copyProperties(entity, response);
        return response;
    }
    
    private BookResponse toResponse(Book entity) {
        BookResponse response = new BookResponse();
        
        BeanUtils.copyProperties(entity, response);
        response.setPublisherId(entity.getPublisher().getPublisherId());
        
        response.setPublisher(toResponse(entity.getPublisher()));
        
        response.setAuthors(
                entity.getAuthors()
                        .stream()
                        .map(this::toResponse)
                        .toList()
        );
        
        return response;
    }

    private Book getEntityById(int bookId) {
        return bookRepository.findById(bookId)
                .orElseThrow(() -> new RecordNotFoundException("Could not find the book: " + bookId));
    }

    private Publisher getPublisherById(int publisherId) {
        return publisherRepository.findById(publisherId)
                .orElseThrow(() -> new RecordNotFoundException("Could not find the publisher: " + publisherId));
    }

    private Author getAuthorById(int authorId) {
        return authorRepository.findById(authorId)
                .orElseThrow(() -> new RecordNotFoundException("Could not find the author: " + authorId));
    }
}
