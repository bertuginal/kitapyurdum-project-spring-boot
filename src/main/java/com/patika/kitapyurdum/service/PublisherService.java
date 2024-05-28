package com.patika.kitapyurdum.service;

import com.patika.kitapyurdum.converter.PublisherConverter;
import com.patika.kitapyurdum.dto.request.PublisherSaveRequest;
import com.patika.kitapyurdum.exception.ExceptionMessages;
import com.patika.kitapyurdum.exception.KitapYurdumException;
import com.patika.kitapyurdum.model.Publisher;
import com.patika.kitapyurdum.repository.PublisherRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
@Slf4j
public class PublisherService {

    private final PublisherRepository publisherRepository;

    public void save(PublisherSaveRequest request) {

        Publisher publisher = PublisherConverter.toPublisher(request);

        publisherRepository.save(publisher);

        log.info("Publisher saved! {}", publisher.toString());
    }

    public List<Publisher> getAllPublishers() {
        return publisherRepository.getAll();
    }

    public Publisher getById(Long id) {
        Optional<Publisher> foundPublisher = publisherRepository.findById(id);

        if (foundPublisher.isEmpty()) {
            log.error(ExceptionMessages.PUBLISHER_NOT_FOUND);
            throw new KitapYurdumException(ExceptionMessages.PUBLISHER_NOT_FOUND);
        }

        return foundPublisher.get();
    }

    public Optional<Publisher> getByName(String publisherName) {
        return getAllPublishers().stream()
                .filter(publisher -> publisher.getName().equals(publisherName))
                .findFirst();
    }
}
