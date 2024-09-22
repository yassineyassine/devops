package com.simpleProject.mesEtudiantManagement.controller;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.simpleProject.mesEtudiantManagement.model.MesEtudiantModule;
import com.simpleProject.mesEtudiantManagement.service.MesEtudiantService;
/*yassine changement controller 1*/
/*yassine changement controller 2*/
/*yassine changement controller 3*/
/*yassine changement controller 4*/
/*yassine changement controller 5*/
/*yassine changement controller 6*/
@RestController
@RequestMapping("/mesEtudiant")
public class MesEtudiantController {
    private final MesEtudiantService mesEtudiantService;

    public MesEtudiantController(MesEtudiantService mesEtudiantService) {
        this.mesEtudiantService = mesEtudiantService;
    }

    @GetMapping
    public ResponseEntity<List<MesEtudiantModule>> getAllTajilProducts(){
        return new ResponseEntity<>(mesEtudiantService.getAllTajilProduct(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MesEtudiantModule> getTajilProductById(@PathVariable UUID id){
        Optional<MesEtudiantModule> optionalTajilProduct = mesEtudiantService.getTajilProductByProductId(id);
        if (optionalTajilProduct.isPresent()) {
            return new ResponseEntity<>(optionalTajilProduct.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<MesEtudiantModule> createNewTajilProduct(@RequestBody MesEtudiantModule tajilProduct){
        return new ResponseEntity<>(mesEtudiantService.createTajilProduct(tajilProduct), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MesEtudiantModule> updateTajilProductById(@PathVariable UUID id, @RequestBody MesEtudiantModule tajilProduct){
        Optional<MesEtudiantModule> optionalUpdateTajilProduct = mesEtudiantService.updateTajilProduct(id, tajilProduct);
        if (optionalUpdateTajilProduct.isPresent()) {
            return new ResponseEntity<>(optionalUpdateTajilProduct.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteTajilProductById(@PathVariable UUID id){
        mesEtudiantService.deleteTajilProduct(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
