package com.patika.kitapyurdum.repository;

import com.patika.kitapyurdum.model.Magazine;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class MagazineRepository {

    private List<Magazine> magazines = new ArrayList<>();
    private long nextId = 1L;

    public Magazine save(Magazine magazine) {
        if (magazine.getId() == null) {
            magazine.setId(nextId++);
            magazines.add(magazine);
        } else {
            magazines = magazines.stream()
                    .map(b -> b.getId().equals(magazine.getId()) ? magazine : b)
                    .collect(Collectors.toList());
        }
        return magazine;
    }

    public Magazine findById(Long id) {
        return magazines.stream()
                .filter(book -> book.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public List<Magazine> findAll() {
        return new ArrayList<>(magazines);
    }


}