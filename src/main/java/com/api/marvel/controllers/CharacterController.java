package com.api.marvel.controllers;

import com.api.marvel.controllers.dto.CharacterDTO;
import com.api.marvel.controllers.dto.CharacterInfoDTO;
import com.api.marvel.services.CharacterService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador para gestionar solicitudes relacionadas con character.
 * Proporciona endpoints para operaciones CRUD sobre character.
 */
@RestController
@RequestMapping("/character")
public class CharacterController {

    private CharacterService characterService;

    public CharacterController(CharacterService characterService) {
        this.characterService = characterService;
    }

    /**
     * Busca y devuelve una lista de personajes basada en los criterios de búsqueda proporcionados.
     * Los parámetros de búsqueda son opcionales y se pueden combinar para filtrar los resultados.
     *
     * @param name   Opcional. Nombre del personaje para filtrar en la búsqueda.
     * @param comics Opcional. Array de IDs de cómics para filtrar personajes que aparecen en esos cómics.
     * @param series Opcional. Array de IDs de series para filtrar personajes que aparecen en esas series.
     * @param limit  Opcional. Número máximo de resultados a devolver. Por defecto es "10".
     * @param offset Opcional. Número de resultados a saltar para la paginación. Por defecto es "0".
     * @return ResponseEntity que contiene una lista de {@link CharacterDTO} que coinciden con los criterios de búsqueda.
     */
    @GetMapping("/find")
    public ResponseEntity<List<CharacterDTO>> findCharacters(@RequestParam(required = false) String name,
                                                             @RequestParam(required = false) int[] comics,
                                                             @RequestParam(required = false) int[] series,
                                                             @RequestParam(required = false, defaultValue = "0") int offset,
                                                             @RequestParam(required = false, defaultValue = "10") int limit) {
        return new ResponseEntity<>(
                this.characterService.findCharacters(name, comics, series, offset, limit), HttpStatus.OK);
    }

    /**
     * Busca y devuelve la información detallada de un personaje específico basándose en su nombre.
     */
    @GetMapping("/find/{characterId}")
    public ResponseEntity<CharacterInfoDTO> findCharacterById(@PathVariable Long characterId){
        return new ResponseEntity<>(this.characterService.findCharacterById(characterId) , HttpStatus.OK);
    }
}
