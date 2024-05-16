package com.example.App.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Service
public class ArchivoService {
    @Value("${pathPdf}")
    private String pathPdf;

    public String uploadFile(String fileName, MultipartFile multipartFile) {
        File dir = new File(pathPdf+fileName);

        if(dir.exists()){
            return "EXIST";
        }

        Path path = Path.of(pathPdf+fileName);

        try{
            Files.copy(multipartFile.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
            return "CREATED";
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        return "FAILED";
    }

    public String savePdf(/*String fileName,*/ MultipartFile file){
        String NewName;
            if (file.isEmpty()) {
                return "File is empty";
            }
        try {
            //String fullPath = pathPdf+fileName+".pdf";
            //System.out.println(fullPath);
            //File dir = new File(fullPath);

            byte[] bytes = file.getBytes();

            Path path = Paths.get(pathPdf +File.pathSeparator+ file.getOriginalFilename() );
            Files.write(path, bytes);

            return "Archivo subido exitosamente: " + path.getFileName();


           /* if (dir.createNewFile()){
                System.out.println("File created: " + dir.getName());
            }
                System.out.println("File already exists.");
            return fullPath;*/
        } catch (IOException e) {
            e.printStackTrace();
            return "Fallo en la carga del archivo: " + e.getMessage();
        }
    }
}
