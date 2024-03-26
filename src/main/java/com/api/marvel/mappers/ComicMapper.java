package com.api.marvel.mappers;

import com.api.marvel.controllers.dto.ComicDTO;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ComicMapper {
    public List<ComicDTO> getComicDTOListId(JsonNode response) {

        if (response == null){
            throw new IllegalArgumentException("El nodo json no puede ser null");
        }

        JsonNode dataNode = response.get("data");
        ArrayNode arrayNode = (ArrayNode) dataNode.get("results");

        List<ComicDTO> comicList = new ArrayList<>();

        arrayNode.elements().forEachRemaining(comic -> {
            comicList.add(this.getComicDTO(comic));
        });

        return comicList;
    }

    public List<ComicDTO> getComicDTOList(JsonNode response) {

        if (response == null){
            throw new IllegalArgumentException("El nodo json no puede ser null");
        }

        JsonNode dataNode = response.get("data");
        ArrayNode arrayNode = (ArrayNode) dataNode.get("results");

        List<ComicDTO> comicList = new ArrayList<>();

        arrayNode.elements().forEachRemaining(comic -> {
            comicList.add(this.getComicDTO(comic));
        });

        return comicList;
    }

    public ComicDTO getComicDTOId(JsonNode response) {

        if (response == null){
            throw new IllegalArgumentException("El nodo json no puede ser null");
        }

        JsonNode dataNode = response.get("data");
        ArrayNode arrayNode = (ArrayNode) dataNode.get("results");

        if (!arrayNode.isEmpty()){
            JsonNode comicNode = arrayNode.get(0);

            ComicDTO comicDTO = getComicDTO(comicNode);

            return comicDTO;
        }

        return null;
    }

    public ComicDTO getComicDTO(JsonNode jsonNode){

        if (jsonNode == null){
            throw new IllegalArgumentException("El nodo json no puede ser null");
        }

        ComicDTO comicDTO = new ComicDTO(
                jsonNode.get("id").asInt(),
                jsonNode.get("title").asText(),
                jsonNode.get("description").asText(),
                jsonNode.get("pageCount").asInt(),
                jsonNode.get("resourceURI").asText()
        );
        return comicDTO;
    }
}
