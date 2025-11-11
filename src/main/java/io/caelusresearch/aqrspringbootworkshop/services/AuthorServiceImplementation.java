package io.caelusresearch.aqrspringbootworkshop.services;

import io.caelusresearch.aqrspringbootworkshop.dtos.AuthorCreateRequest;
import io.caelusresearch.aqrspringbootworkshop.dtos.AuthorResponse;
import io.caelusresearch.aqrspringbootworkshop.dtos.AuthorUpdateRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorServiceImplementation implements AuthorService {
    @Override
    public List<AuthorResponse> getAll() {
        return List.of();
    }

    @Override
    public AuthorResponse getById(int AuthorId) {
        return null;
    }

    @Override
    public AuthorResponse create(AuthorCreateRequest request) {
        return null;
    }

    @Override
    public AuthorResponse update(int AuthorId, AuthorUpdateRequest request) {
        return null;
    }

    @Override
    public void deleteById(int AuthorId) {

    }
}
