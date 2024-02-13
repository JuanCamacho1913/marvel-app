package com.api.marvel.controllers.dto;

import java.util.Date;

public record CharacterDTO(String name, String description, Date modified, String resourceURI){}
