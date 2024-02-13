package com.example.javaplayground.config;

import com.example.javaplayground.repository.ArtistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import com.example.javaplayground.model.Artist;
import com.example.javaplayground.repository.ArtistRepository;

import java.util.UUID;


@Component
public class InitData implements CommandLineRunner{

    @Autowired
    ArtistRepository artistRepository;

    @Override
    public void run(String... args) throws Exception {
        try {
            Artist a1 = new Artist();
            a1.setId(UUID.randomUUID().toString());
            a1.setName("John1");
            a1.setBirthdate("2000-01-01");
            a1.setActiveSince("2000-01-01");
            a1.setImage("https://www.google.com");
            a1.setGenres("Rock");
            a1.setWebsite("https://www.google.com");
            a1.setShortDescription("This is a short description");
            artistRepository.save(a1);
            System.out.println("Artist saved: " + a1);
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }
}
