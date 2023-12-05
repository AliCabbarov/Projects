package com.multicompany.java106bmultipart.service.impl;

import com.multicompany.java106bmultipart.service.FileService;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Objects;
import java.util.stream.Stream;

@Service
@Slf4j
public class FileServiceImpl implements FileService {
    private final Path ROOT = Path.of("upload");

    @SneakyThrows
    private void init() {
        Path path = Files.createDirectory(ROOT);
        log.info("created file : {}", path.getRoot());
    }

    @Override
    @SneakyThrows
    public ResponseEntity<String> upload(MultipartFile multipartFile) {
        if (multipartFile.isEmpty()){
            throw new NullPointerException("File has not been selected!!!");
        }
        Files.write(this.ROOT.resolve(Objects.requireNonNull(multipartFile.getOriginalFilename())),multipartFile.getBytes());
        return ResponseEntity.status(HttpStatus.CREATED).body("created");
    }


    @Override
    @SneakyThrows
    public ResponseEntity<Resource> download(String fileName) {
        Resource resource = new UrlResource(ROOT.toUri().resolve(fileName));

        if (!resource.exists() || !resource.isReadable()) {
            throw new RuntimeException("invalid file name!!!!");
        }

        return ResponseEntity
                .status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .body(resource);
    }

    @Override
    @SneakyThrows
    public ResponseEntity<Stream<Path>> getAll() {
        Stream<Path> files = Files.walk(ROOT).filter(Files::isRegularFile);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(files);
    }

    @Override
    @SneakyThrows
    public ResponseEntity<String> delete(String fileName) {
        Path path = ROOT.resolve(fileName);
        boolean hasDelete = Files.deleteIfExists(path);
        if (!hasDelete) {
            throw new RuntimeException("file doesn't deleted!!!");
        }
        return ResponseEntity.status(HttpStatus.OK).body("deleted");
    }
}
