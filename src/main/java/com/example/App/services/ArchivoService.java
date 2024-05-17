package com.example.App.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.UUID;

@Service
@Slf4j
public class ArchivoService {
    @Value("${pathPdf}")
    private String pathPdf;

    public String uploadFile(String fileName, MultipartFile multipartFile) {
        File dir = new File(pathPdf + fileName);

        if (dir.exists()) {
            return "EXIST";
        }

        Path path = Path.of(pathPdf + fileName);

        try {
            Files.copy(multipartFile.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
            return "CREATED";
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return "FAILED";
    }

    public String savePdf(MultipartFile file) {
        if (file.isEmpty()) {
            return "File is empty";
        }
        try {
            byte[] bytes = file.getBytes();
            String hashedFileName = UUID.randomUUID().toString();
            Path path = Paths.get(pathPdf + hashedFileName + File.pathSeparator + file.getOriginalFilename());
            Files.write(path, bytes);

            return path.getFileName().toString();

        } catch (IOException e) {
            log.error("Error: {}", e.getMessage());
            return "Error al subir el archivo";
        }

    }
}
