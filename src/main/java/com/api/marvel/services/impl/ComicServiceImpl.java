package com.api.marvel.services.impl;

import com.api.marvel.controllers.dto.ComicDTO;
import com.api.marvel.persistence.ComicRepository;
import com.api.marvel.services.ComicService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComicServiceImpl implements ComicService {

    private ComicRepository comicRepository;

    public ComicServiceImpl(ComicRepository comicRepository) {
        this.comicRepository = comicRepository;
    }

    @Override
    public List<ComicDTO> findComicByCharacter(int characterId) {
        return this.comicRepository.findComicByCharacter(characterId);
    }

    @Override
    public List<ComicDTO> findAllComics() {
        return this.comicRepository.findAllComics();
    }

    @Override
    public ComicDTO findById(int comicId) {
        return this.comicRepository.findById(comicId);
    }
}
