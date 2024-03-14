package com.api.marvel.services.impl;

import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class HttpClientServiceImpl {
    public JsonNode httpGet(String characterPath, Map<String, String> marvelQueryParams, Class<JsonNode> jsonNodeClass) {
        return null;
    }
}
