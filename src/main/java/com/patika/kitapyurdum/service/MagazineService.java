package com.patika.kitapyurdum.service;

import com.patika.kitapyurdum.converter.BookConverter;
import com.patika.kitapyurdum.converter.MagazineConverter;
import com.patika.kitapyurdum.dto.request.BookSaveRequest;
import com.patika.kitapyurdum.dto.request.MagazineSaveRequest;
import com.patika.kitapyurdum.dto.response.BookResponse;
import com.patika.kitapyurdum.model.*;
import com.patika.kitapyurdum.repository.BookRepository;
import com.patika.kitapyurdum.repository.MagazineRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@RequiredArgsConstructor
@Service
@Slf4j
public class MagazineService {

    private final MagazineRepository magazineRepository;
    private final MagazineConverter magazineConverter;

    public MagazineSaveRequest save(MagazineSaveRequest request, Publisher publisher, Category category, Author author) {
        Magazine magazine = magazineConverter.convertToEntity(request, publisher, category, author);
        magazine = magazineRepository.save(magazine);
        log.info("Magazine saved! : {}", magazine.toString());
        return magazineConverter.toMagazine(magazine);
    }

    public MagazineSaveRequest getMagazineById(Long id) {
        Magazine magazine = magazineRepository.findById(id);
        return magazine != null ? magazineConverter.toMagazine(magazine) : null;
    }

    public List<MagazineSaveRequest> getAllMagazine() {
        return magazineRepository.findAll().stream()
                .map(magazineConverter::toMagazine)
                .collect(Collectors.toList());
    }


}