package com.example.cardealerapplication.file;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@Entity
@Table(name = "file")
public class File implements Serializable {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY)
    private Long id;
    @Lob
    private byte[] file;
    private String filename;
    private String description;
    private String author;
}
