package com.multicompany.java106bmultipart.controller;

import com.multicompany.java106bmultipart.service.FileService;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.AccessDeniedException;
import java.nio.file.Path;
import java.util.stream.Stream;

@RestController
@RequestMapping("/multipart/")
@RequiredArgsConstructor
@Slf4j
public class MultipartController {
    private final FileService fileService;

    @PostMapping("upload")
    @SneakyThrows
    public ResponseEntity<String> upload(@RequestPart("file") MultipartFile multipartFile) {
        log.info("POST - upload file name: {}", multipartFile.getOriginalFilename());
        return fileService.upload(multipartFile);
    }

    @GetMapping("download/{fileName}")
    public ResponseEntity<Resource> download(@PathVariable String fileName) {
        log.info("GET - download file name: {}", fileName);
        return fileService.download(fileName);
    }

    @GetMapping()
    public ResponseEntity<Stream<Path>> files() {
        return fileService.getAll();
    }

    @DeleteMapping("delete/{fileName}")
    public ResponseEntity<String> delete(@PathVariable String fileName) {
        log.info("DELETE - delete file name: {}", fileName);
        return fileService.delete(fileName);
    }
}
