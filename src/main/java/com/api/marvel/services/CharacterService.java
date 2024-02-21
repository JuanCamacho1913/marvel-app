package com.api.marvel.services;

import com.api.marvel.controllers.dto.CharacterDTO;
import com.api.marvel.controllers.dto.CharacterInfoDTO;

import java.util.List;

public interface CharacterService {
    List<CharacterDTO> findCharacters(String name, int[] comics, int[] series, int offset, int limit);

    CharacterInfoDTO findCharacterById(Long characterId);
}
