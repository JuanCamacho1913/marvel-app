package com.api.marvel.persistence;

import com.api.marvel.config.ApiMarvelConfig;
import com.api.marvel.controllers.dto.ComicDTO;
import com.api.marvel.services.impl.HttpClientServiceImpl;
import com.fasterxml.jackson.databind.JsonNode;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class ComicRepository {

    private ApiMarvelConfig apiMarvelConfig;

    private HttpClientServiceImpl httpClientService;

    public ComicRepository(ApiMarvelConfig apiMarvelConfig, HttpClientServiceImpl httpClientService) {
        this.apiMarvelConfig = apiMarvelConfig;
        this.httpClientService = httpClientService;
    }

    @Value("${integration.marvel.base.path}")
    private String basePath;

    private String comicPath;

    @PostConstruct
    public void setComicPath() {
        comicPath = this.basePath.concat("/").concat("comics");
    }

    public List<ComicDTO> findComicByCharacter(int characterId) {
        Map<String, String> marvelQueryParam = apiMarvelConfig.getAuthorizationParams();

        String finalUrl = basePath.concat("/").concat("characters").concat(String.valueOf(characterId));

        JsonNode response = httpClientService.httpGet(finalUrl, marvelQueryParam, JsonNode.class);
        return null;
    }

    public List<ComicDTO> findAllComics() {
        Map<String, String> marvelQueryParam = apiMarvelConfig.getAuthorizationParams();

        JsonNode response = httpClientService.httpGet(comicPath, marvelQueryParam, JsonNode.class);

        return null;
    }

    public ComicDTO findById(int comicId) {
        Map<String, String> marvelQueryParam = apiMarvelConfig.getAuthorizationParams();

        String finalUrl = comicPath.concat(String.valueOf(comicId));

        JsonNode response = httpClientService.httpGet(finalUrl, marvelQueryParam, JsonNode.class);

        return null;
    }
}
