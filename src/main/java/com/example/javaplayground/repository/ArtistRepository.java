package com.example.javaplayground.repository;

import com.example.javaplayground.model.Artist;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ArtistRepository extends JpaRepository<Artist, Integer> {
    List<Artist> findAllByName(String name);
    Artist findById(String id);
    Artist getAll();
}
