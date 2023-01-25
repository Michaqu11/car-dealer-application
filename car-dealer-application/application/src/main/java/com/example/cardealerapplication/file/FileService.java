package com.example.cardealerapplication.file;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@RequiredArgsConstructor
@Service
public class FileService {

    private final FileRepository repository;

    public File create(File file) {
        return repository.save(file);
    }

    public Optional<File> find(long id) {
        return repository.findById(id);
    }
}
