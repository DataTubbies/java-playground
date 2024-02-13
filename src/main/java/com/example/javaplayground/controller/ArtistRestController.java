package com.example.javaplayground.controller;

import com.example.javaplayground.model.Artist;
import com.example.javaplayground.repository.ArtistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.UUID;

import java.util.List;


@RestController
@RequestMapping("/artists")
public class ArtistRestController {


    @Autowired
    ArtistRepository artistRepository;

    @GetMapping("/test")
    public String hello() {
        return "Du er i roden af JpaStudent";
    }

    @GetMapping("/")
    public List<Artist> getArtists() {
        return artistRepository.findAll();
    }

    @GetMapping("/{id}")
    public Artist getArtist(@PathVariable String id) {
        return artistRepository.findById(id);
    }


    @PostMapping("/")
    public ResponseEntity<Artist> createArtist(@RequestBody Artist artist) {
        try {
            artist.setId(UUID.randomUUID().toString());
            artistRepository.save(artist);
        } catch (Exception e) {
            System.out.println("error: " + e);
        }
        return new ResponseEntity<>(artist, HttpStatus.CREATED);
    }
}



