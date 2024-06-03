package com.patika.kitapyurdum.controller;

import com.patika.kitapyurdum.dto.request.PublisherSaveRequest;
import com.patika.kitapyurdum.dto.response.GenericResponse;
import com.patika.kitapyurdum.model.Author;
import com.patika.kitapyurdum.model.Publisher;
import com.patika.kitapyurdum.service.PublisherService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/publishers")
public class PublisherController {

    private final PublisherService publisherService;

    @PostMapping
    public ResponseEntity<Void> save(@RequestBody PublisherSaveRequest request) {
        publisherService.save(request);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping
    public List<Publisher> getAll() {
        return publisherService.getAllPublishers();
    }

    @GetMapping("/{id}")
    public GenericResponse<Publisher> getById(@PathVariable Long id) {

        Publisher publisher = publisherService.getById(id);

        return GenericResponse.success(publisher);
    }

    @GetMapping("/name/{name}")
    public GenericResponse<Optional<Publisher>> getByName(@PathVariable String name) {
        Optional<Publisher> publisher = publisherService.getByName(name);
        return GenericResponse.success(publisher);
    }

}
