package com.api.marvel.controllers.dto;

import jakarta.validation.constraints.Size;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Validated
public record AuthCreateRoleRequest(
        @Size(max = 3, message = "El user no puede tener mas de 3 roles") List<String> roleListName) {
}
