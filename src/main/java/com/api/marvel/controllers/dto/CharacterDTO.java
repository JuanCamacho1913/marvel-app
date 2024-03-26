package com.api.marvel.controllers.dto;

import java.util.Date;

public record CharacterDTO(int id, String name, String description, String modified, String resourceURI){}
