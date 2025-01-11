package it.epicode.S5_L5_BE.web.controllers;

import it.epicode.S5_L5_BE.db.pojo.Avatar;
import it.epicode.S5_L5_BE.db.serv.AvatarServ;
import it.epicode.S5_L5_BE.db.serv.CloudinaryServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

@RestController
@RequestMapping("/api/cloudinary")
public class UploadController {

    @Autowired
    private CloudinaryServ cloudinaryService;

    @Autowired
    private AvatarServ avatarServ;

    @PostMapping(path = "/upload/{dipendenteId}", consumes = "multipart/form-data")
    public ResponseEntity<Map> uploadFile(
            @RequestPart("file") MultipartFile file,
            @PathVariable Long dipendenteId) {

        String folder = "avatars";

        Map result = cloudinaryService.uploader(file, folder);
        String imageUrl = (String) result.get("url");

        Avatar avatar = new Avatar();
        avatar.setImageUrl(imageUrl);
        avatarServ.save(avatar, dipendenteId);

        return ResponseEntity.ok(result);
    }
}
