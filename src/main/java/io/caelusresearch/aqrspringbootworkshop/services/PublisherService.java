package io.caelusresearch.aqrspringbootworkshop.services;

import io.caelusresearch.aqrspringbootworkshop.dtos.PublisherCreateRequest;
import io.caelusresearch.aqrspringbootworkshop.dtos.PublisherResponse;
import io.caelusresearch.aqrspringbootworkshop.dtos.PublisherUpdateRequest;

import java.util.List;

public interface PublisherService {
    List<PublisherResponse> getAll();
    PublisherResponse getById(int PublisherId);
    PublisherResponse create(PublisherCreateRequest request);
    PublisherResponse update(int PublisherId, PublisherUpdateRequest request);
    void deleteById(int PublisherId);
}
