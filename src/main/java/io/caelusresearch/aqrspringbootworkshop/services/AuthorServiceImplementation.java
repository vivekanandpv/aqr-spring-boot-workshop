package io.caelusresearch.aqrspringbootworkshop.services;

import io.caelusresearch.aqrspringbootworkshop.dtos.*;
import io.caelusresearch.aqrspringbootworkshop.entities.Author;
import io.caelusresearch.aqrspringbootworkshop.entities.Author;
import io.caelusresearch.aqrspringbootworkshop.exceptions.RecordNotFoundException;
import io.caelusresearch.aqrspringbootworkshop.repositories.AuthorRepository;
import io.caelusresearch.aqrspringbootworkshop.repositories.PublisherRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorServiceImplementation implements AuthorService {
    private final AuthorRepository authorRepository;

    public AuthorServiceImplementation(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public List<AuthorResponse> getAll() {
        return authorRepository
                .findAll()
                .stream()
                .map(this::toResponse)
                .toList();
    }

    @Override
    public AuthorResponse getById(int AuthorId) {
        return toResponse(getEntityById(AuthorId));
    }

    @Override
    public AuthorResponse create(AuthorCreateRequest request) {
        return toResponse(authorRepository.saveAndFlush(toEntity(request)));
    }

    @Override
    public AuthorResponse update(int AuthorId, AuthorUpdateRequest request) {
        Author entityDb = getEntityById(AuthorId);

        BeanUtils.copyProperties(request, entityDb);

        return toResponse(authorRepository.saveAndFlush(entityDb));
    }

    @Override
    public void deleteById(int AuthorId) {
        authorRepository.delete(getEntityById(AuthorId));
    }

    private AuthorResponse toResponse(Author entity) {
        AuthorResponse response = new AuthorResponse();
        BeanUtils.copyProperties(entity, response);
        return response;
    }

    private Author toEntity(AuthorCreateRequest request) {
        Author entity = new Author();
        BeanUtils.copyProperties(request, entity);
        return entity;
    }

    private Author getEntityById(int authorId) {
        return authorRepository.findById(authorId)
                .orElseThrow(() -> new RecordNotFoundException("Could not find the author: " + authorId));
    }
}
