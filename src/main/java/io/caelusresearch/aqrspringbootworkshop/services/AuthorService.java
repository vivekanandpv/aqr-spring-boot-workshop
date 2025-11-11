package io.caelusresearch.aqrspringbootworkshop.services;

import io.caelusresearch.aqrspringbootworkshop.dtos.AuthorCreateRequest;
import io.caelusresearch.aqrspringbootworkshop.dtos.AuthorResponse;
import io.caelusresearch.aqrspringbootworkshop.dtos.AuthorUpdateRequest;

import java.util.List;

public interface AuthorService {
    List<AuthorResponse> getAll();
    AuthorResponse getById(int AuthorId);
    AuthorResponse create(AuthorCreateRequest request);
    AuthorResponse update(int AuthorId, AuthorUpdateRequest request);
    void deleteById(int AuthorId);
}
