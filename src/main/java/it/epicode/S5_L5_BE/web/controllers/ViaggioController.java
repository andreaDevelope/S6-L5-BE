package it.epicode.S5_L5_BE.web.controllers;

import it.epicode.S5_L5_BE.db.pojo.Viaggio;
import it.epicode.S5_L5_BE.db.serv.ViaggioServ;
import it.epicode.S5_L5_BE.web.dto.ViaggioRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/viaggi")
public class ViaggioController {

    @Autowired
    ViaggioServ vs;

    @GetMapping
    public ResponseEntity<List<Viaggio>> getAll(){
        return ResponseEntity.ok(vs.findAll());
    }

    @PostMapping
    public ResponseEntity<Viaggio> saveViaggio(@RequestBody ViaggioRequest newV){
        return ResponseEntity.status(HttpStatus.CREATED).body(vs.saveViaggio(newV));
    }
}
