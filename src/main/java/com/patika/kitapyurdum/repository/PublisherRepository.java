package com.patika.kitapyurdum.repository;

import com.patika.kitapyurdum.model.Publisher;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class PublisherRepository {
    private List<Publisher> publishers = new ArrayList<>();

    public void save(Publisher publisher) {
        publishers.add(publisher);
    }

    public List<Publisher> getAll() {
        return publishers;
    }

    public Optional<Publisher> findById(Long id) {
        return getAll().stream()
                .filter(publisher -> publisher.getId().equals(id))
                .findFirst();
    }

    public Optional<Publisher> findByName(String publisherName) {
        return getAll().stream()
                .filter(publisher -> publisher.getName().equals(publisherName))
                .findFirst();
    }
}
