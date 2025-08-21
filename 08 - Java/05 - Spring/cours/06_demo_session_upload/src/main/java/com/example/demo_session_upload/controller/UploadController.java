package com.example.demo_session_upload.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Controller
public class UploadController {
    private String location = "src/main/resources/static/img";


    @RequestMapping("/upload")
    public String upload() {
        return "upload-form";
    }

    @PostMapping("/upload")
    // IOException est souvent utilisé pour signaler les erreurs lors de la lecture ou l'écriture de fichier externe
    public String postForm(@RequestParam("image") MultipartFile image) throws IOException {
        // Cette ligne construit le chemin ou le fichier sera enregistré.
        Path destinationFile = Paths.get(location).resolve(image.getOriginalFilename()).toAbsolutePath();
        // Récupère le flux d'entrée du fichier téléchargé
        InputStream inputStream = image.getInputStream();
        // Copié le contenu vers la destination
        Files.copy(inputStream, destinationFile, StandardCopyOption.REPLACE_EXISTING);
        return "redirect:/login";
    }
}
