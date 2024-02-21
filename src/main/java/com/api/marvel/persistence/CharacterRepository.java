package com.api.marvel.persistence;

import com.api.marvel.controllers.dto.CharacterDTO;
import com.api.marvel.controllers.dto.CharacterInfoDTO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CharacterRepository {
    public List<CharacterDTO> findCharacters(String name, int[] comics, int[] series, int offset, int limit) {
            return null;
    }

    public CharacterInfoDTO findCharacterById(Long characterId) {
        return null;
    }
}
