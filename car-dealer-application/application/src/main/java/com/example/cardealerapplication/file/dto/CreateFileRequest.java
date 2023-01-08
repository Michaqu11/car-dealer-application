package com.example.cardealerapplication.file.dto;


import com.example.cardealerapplication.file.File;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.function.Function;


@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class CreateFileRequest {

    private byte[] file;
    private String filename;
    private String description;
    private String author;

    public CreateFileRequest(byte[] file, String filename, String description, String author){
        this.file = file;
        this.filename = filename;
        this.description = description;
        this.author = author;
    }
    public static Function<CreateFileRequest, File> dtoToEntityMapper() {
        return request -> {
            return File.builder()
                    .file(request.getFile())
                    .filename(request.getFilename())
                    .description(request.getDescription())
                    .author(request.getAuthor())
                    .build();
        };
    }


}
