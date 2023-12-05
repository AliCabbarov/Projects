package com.multicompany.java106bmultipart.service;

import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Path;
import java.util.stream.Stream;

public interface FileService {
    ResponseEntity<String> upload(MultipartFile multipartFile);

    ResponseEntity<Resource> download(String fileName);

    ResponseEntity<Stream<Path>> getAll();

    ResponseEntity<String> delete(String fileName);
}
