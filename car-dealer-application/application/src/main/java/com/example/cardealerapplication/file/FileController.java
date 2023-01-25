package com.example.cardealerapplication.file;

import com.example.cardealerapplication.file.dto.CreateFileRequest;
import com.example.cardealerapplication.file.dto.GetFileResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.ByteArrayInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;


@RestController
@RequestMapping("/file")
public class FileController {
    // private static final String UPLOADED_FILES_FOLDER = Paths.get("").toAbsolutePath().toString() + "/files/";
    private static final String UPLOADED_FILES_FOLDER = "/app/uploaded_files/";
    @Autowired
    private FileService fileService;

    @PostMapping()
    public ResponseEntity<String> handleFileUpload(@RequestParam("file") MultipartFile multipartFile, @RequestParam("description") String description, @RequestParam("author") String author) {
        try {
             // Save the file to the file system
            byte[] bytes =multipartFile.getBytes();
            String filename =  multipartFile.getOriginalFilename();
            Path path = Paths.get(UPLOADED_FILES_FOLDER + multipartFile.getOriginalFilename());
            System.out.println("Request contains, File: " + filename + path + ' ' + description + ' ' + author);
            Files.write(path, bytes);
            System.out.println("Działa? "+ multipartFile+ " " + description + " " + author);
            CreateFileRequest request = new CreateFileRequest(bytes, filename, description, author);

            File file = CreateFileRequest.dtoToEntityMapper().apply(request);
            fileService.create(file);

            return ResponseEntity.ok("File uploaded successfully, id: " + file.getId());
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("{id}")
    public ResponseEntity<byte[]> getFile(@PathVariable("id") long id) {
        File file = fileService.find(id).orElse(null);
        if (file  == null) {
            return ResponseEntity.notFound().build();
        }
        try {
            Path path = Paths.get(UPLOADED_FILES_FOLDER + file.getFilename());
            System.out.println("path:" + path);

            byte[] fileContent = Files.readAllBytes(path);

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
            headers.setContentLength(fileContent.length);
            headers.setContentDispositionFormData("attachment", file.getFilename());

            return new ResponseEntity<>(fileContent, headers, HttpStatus.OK);
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }


}


