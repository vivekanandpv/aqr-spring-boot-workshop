package io.caelusresearch.aqrspringbootworkshop.services;

import io.caelusresearch.aqrspringbootworkshop.dtos.PublisherCreateRequest;
import io.caelusresearch.aqrspringbootworkshop.dtos.PublisherResponse;
import io.caelusresearch.aqrspringbootworkshop.dtos.PublisherUpdateRequest;
import io.caelusresearch.aqrspringbootworkshop.entities.Publisher;
import io.caelusresearch.aqrspringbootworkshop.exceptions.RecordNotFoundException;
import io.caelusresearch.aqrspringbootworkshop.repositories.PublisherRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PublisherServiceImplementation implements PublisherService {
    private final PublisherRepository publisherRepository;

    public PublisherServiceImplementation(PublisherRepository publisherRepository) {
        this.publisherRepository = publisherRepository;
    }

    @Override
    public List<PublisherResponse> getAll() {
        return publisherRepository
                .findAll()
                .stream()
                .map(this::toResponse)
                .toList();
    }

    @Override
    public PublisherResponse getById(int PublisherId) {
        return toResponse(getEntityById(PublisherId));
    }

    @Override
    public PublisherResponse create(PublisherCreateRequest request) {
        return toResponse(publisherRepository.saveAndFlush(toEntity(request)));
    }

    @Override
    public PublisherResponse update(int PublisherId, PublisherUpdateRequest request) {
        Publisher entityDb = getEntityById(PublisherId);
        
        BeanUtils.copyProperties(request, entityDb);
        
        return toResponse(publisherRepository.saveAndFlush(entityDb));
    }

    @Override
    public void deleteById(int PublisherId) {
        publisherRepository.delete(getEntityById(PublisherId));
    }
    
    private PublisherResponse toResponse(Publisher entity) {
        PublisherResponse response = new PublisherResponse();
        BeanUtils.copyProperties(entity, response);
        return response;
    }
    
    private Publisher toEntity(PublisherCreateRequest request) {
        Publisher entity = new Publisher();
        BeanUtils.copyProperties(request, entity);
        return entity;
    }
    
    private Publisher getEntityById(int publisherId) {
        return publisherRepository.findById(publisherId)
                .orElseThrow(() -> new RecordNotFoundException("Could not find the publisher: " + publisherId));
    }
}
