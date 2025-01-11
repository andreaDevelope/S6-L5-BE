package it.epicode.S5_L5_BE.web.controllers;



import it.epicode.S5_L5_BE.db.serv.CloudinaryServ;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

@RestController
@RequestMapping("/api/cloudinary")
@RequiredArgsConstructor
public class UploadController {
    private final CloudinaryServ cloudinaryService;

    @PostMapping(path = "/upload", consumes = "multipart/form-data")
    public ResponseEntity<Map> uploadFile(@RequestPart("file") MultipartFile file) {
        String folder = "test";

        Map result = cloudinaryService.uploader(file, folder);
        return ResponseEntity.ok(result);
    }
}