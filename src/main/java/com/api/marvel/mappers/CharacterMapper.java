package com.api.marvel.mappers;

import com.api.marvel.controllers.dto.CharacterDTO;
import com.api.marvel.controllers.dto.CharacterInfoDTO;
import com.api.marvel.controllers.dto.ThumbnailDTO;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CharacterMapper {
    public List<CharacterDTO> getCharacterDTOList(JsonNode response) {


        if (response == null) {
            throw new IllegalArgumentException("El nodo json no puede ser null");
        }

        JsonNode dataNode = response.get("data");
        ArrayNode arrayNode = (ArrayNode) dataNode.get("results");

        List<CharacterDTO> characterList = new ArrayList<>();

        arrayNode.elements().forEachRemaining(character -> {
            characterList.add(this.getCharacterDTO(character));
        });

        return characterList;
    }

    public CharacterDTO getCharacterDTO(JsonNode jsonNode) {

        if (jsonNode == null) {
            throw new IllegalArgumentException("El nodo json no puede ser nulo");
        }

        CharacterDTO characterDTO = new CharacterDTO(
                jsonNode.get("id").asInt(),
                jsonNode.get("name").asText(),
                jsonNode.get("description").asText(),
                jsonNode.get("modified").asText(),
                jsonNode.get("resourceURI").asText()
        );

        return characterDTO;
    }

    public CharacterInfoDTO getCharacterInfoDTO(JsonNode jsonNode) {

        if (jsonNode == null) {
            throw new IllegalArgumentException("El nodo json no puede ser nulo");
        }

        JsonNode dataNode = jsonNode.get("data");
        ArrayNode arrayNode = (ArrayNode) dataNode.get("results");

        JsonNode thumbnailNode = null;
        if (arrayNode.size() > 0) {
            JsonNode characterNode = arrayNode.get(0);
            thumbnailNode = characterNode.get("thumbnail");

            ThumbnailDTO thumbnailDTO = new ThumbnailDTO(
                    thumbnailNode.get("path").asText(),
                    thumbnailNode.get("extension").asText()
            );

            String imagePath = thumbnailDTO.path().concat(".").concat(thumbnailDTO.extension());

            CharacterInfoDTO characterInfoDTO = new CharacterInfoDTO(
                    characterNode.get("description").asText(),
                    imagePath
            );

            return characterInfoDTO;
        }
        return null;
    }
}
