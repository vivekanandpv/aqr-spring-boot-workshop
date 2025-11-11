package io.caelusresearch.aqrspringbootworkshop.services;

import io.caelusresearch.aqrspringbootworkshop.dtos.PublisherCreateRequest;
import io.caelusresearch.aqrspringbootworkshop.dtos.PublisherResponse;
import io.caelusresearch.aqrspringbootworkshop.dtos.PublisherUpdateRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PublisherServiceImplementation implements PublisherService {
    @Override
    public List<PublisherResponse> getAll() {
        return List.of();
    }

    @Override
    public PublisherResponse getById(int PublisherId) {
        return null;
    }

    @Override
    public PublisherResponse create(PublisherCreateRequest request) {
        return null;
    }

    @Override
    public PublisherResponse update(int PublisherId, PublisherUpdateRequest request) {
        return null;
    }

    @Override
    public void deleteById(int PublisherId) {

    }
}
