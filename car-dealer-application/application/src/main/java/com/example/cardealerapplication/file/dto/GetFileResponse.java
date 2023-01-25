package com.example.cardealerapplication.file.dto;

import com.example.cardealerapplication.file.File;
import lombok.*;

import java.util.List;
import java.util.function.Function;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@EqualsAndHashCode
public class GetFileResponse {

    private Long id;
    private byte[] file;
    private String filename;
    private String description;
    private String author;


    public static Function<File, GetFileResponse> entityToDtoMapper() {
        return file -> GetFileResponse.builder()
                .id(file.getId())
                .file(file.getFile())
                .filename(file.getFilename())
                .description(file.getDescription())
                .author(file.getAuthor())
                .build();
    }

}
