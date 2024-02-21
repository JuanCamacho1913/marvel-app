package com.api.marvel.persistence;

import com.api.marvel.controllers.dto.ComicDTO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ComicRepository {
    public List<ComicDTO> findComicByCharacter(int characterId) {
        return null;
    }

    public List<ComicDTO> findAllComics() {
        return null;
    }

    public ComicDTO findById(int comicId) {
        return null;
    }
}
