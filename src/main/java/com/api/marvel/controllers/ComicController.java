package com.api.marvel.controllers;

import com.api.marvel.controllers.dto.CharacterDTO;
import com.api.marvel.controllers.dto.ComicDTO;
import com.api.marvel.services.CharacterService;
import com.api.marvel.services.ComicService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador para gestionar solicitudes relacionadas con comics.
 * Proporciona endpoints para operaciones CRUD sobre comics.
 */
@RestController
@RequestMapping("/comic")
public class ComicController {

    private ComicService comicService;

    public ComicController(ComicService comicService) {
        this.comicService = comicService;
    }

    /**
     * Busca y devuelve los cómics asociados a un ID de personaje específico.
     * @param characterId El ID del personaje cuyos cómics se quieren encontrar.
     * @return ResponseEntity que contiene un {@link ComicDTO} con los cómics asociados al personaje especificado.
     */
    @PreAuthorize("hasAnyRole('ADMIN')")
    @GetMapping("/find")
    public ResponseEntity<List<ComicDTO>> findComicByCharacter(@RequestParam int characterId){
        return new ResponseEntity<>(this.comicService.findComicByCharacter(characterId), HttpStatus.OK);
    }


    /**
     * Busca y devuelve un listado de cómics.
     * @return ResponseEntity que contiene un {@link ComicDTO} con la lista de comics encontrados.
     */
    @PreAuthorize("hasAnyRole('ADMIN')")
    @GetMapping("/findAll")
    public ResponseEntity<List<ComicDTO>> findAll(){
        return new ResponseEntity<>(this.comicService.findAllComics(), HttpStatus.OK);
    }

    /**
     * Busca y devuelve un cómic específico basado en su ID.
     * @param  comicId El ID del cómic a buscar.
     * @return ResponseEntity que contiene un {@link ComicDTO} con la información del cómic encontrado.
     */
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    @GetMapping("/find/{comicId}")
    public ResponseEntity<ComicDTO> findById(@PathVariable int comicId){
        return new ResponseEntity<>(this.comicService.findById(comicId), HttpStatus.OK);
    }
}
