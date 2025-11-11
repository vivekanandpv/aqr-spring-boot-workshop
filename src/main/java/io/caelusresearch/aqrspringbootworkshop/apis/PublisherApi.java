package io.caelusresearch.aqrspringbootworkshop.apis;

import io.caelusresearch.aqrspringbootworkshop.dtos.PublisherCreateRequest;
import io.caelusresearch.aqrspringbootworkshop.dtos.PublisherResponse;
import io.caelusresearch.aqrspringbootworkshop.dtos.PublisherUpdateRequest;
import io.caelusresearch.aqrspringbootworkshop.services.PublisherService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/publishers")
public class PublisherApi {
    private final PublisherService publisherService;


    public PublisherApi(PublisherService publisherService) {
        this.publisherService = publisherService;
    }

    @GetMapping
    public ResponseEntity<List<PublisherResponse>> getAll() {
        return ResponseEntity.ok(publisherService.getAll());
    }

    @GetMapping("{publisherId}")
    public ResponseEntity<PublisherResponse> getById(@PathVariable int publisherId) {
        return ResponseEntity.ok(publisherService.getById(publisherId));
    }

    @PostMapping
    public ResponseEntity<PublisherResponse> create(@RequestBody PublisherCreateRequest request) {
        return ResponseEntity.ok(publisherService.create(request));
    }

    @PutMapping("{publisherId}")
    public ResponseEntity<PublisherResponse> update(@PathVariable int publisherId, @RequestBody PublisherUpdateRequest request) {
        return ResponseEntity.ok(publisherService.update(publisherId, request));
    }

    @DeleteMapping("{publisherId}")
    public ResponseEntity<Void> deleteById(@PathVariable int publisherId) {
        publisherService.deleteById(publisherId);
        return ResponseEntity.noContent().build();
    }
}
