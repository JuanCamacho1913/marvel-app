package com.api.marvel.services;

import com.api.marvel.controllers.dto.ComicDTO;
import org.springframework.http.HttpStatus;

import java.util.List;

public interface ComicService {
    List<ComicDTO> findComicByCharacter(int characterId);

    List<ComicDTO> findAllComics();

    ComicDTO findById(int comicId);
}
