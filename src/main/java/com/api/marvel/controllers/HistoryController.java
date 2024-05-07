package com.api.marvel.controllers;

import com.api.marvel.controllers.dto.ComicDTO;
import com.api.marvel.controllers.dto.HistoryDTO;
import com.api.marvel.services.HistoryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador para gestionar solicitudes relacionadas con historiales.
 * Proporciona endpoints para operaciones de historiales de usuarios.
 */
@RestController
@RequestMapping("/history")
@Tag(name = "History", description = "Controller to work with History interactions")
public class HistoryController {

    private HistoryService historyService;

    public HistoryController(HistoryService historyService) {
        this.historyService = historyService;
    }

    /**
     Busca el historial y devuelve la lista de usuarios que accedieron a nuestro servidor.
     @return ResponseEntity que contiene un {@link HistoryDTO} con la lista de usuarios encontrados.
     */
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/find")
    @Operation(
            method = "GET",
            description = "This is an andpoint to list all user interaction history",
            responses = {
                    @ApiResponse(
                            description = "Success",
                            responseCode = "200"
                    ),
                    @ApiResponse(
                            description = "Unhautorized / Invalid token",
                            responseCode = "403"
                    )
            }
    )
    public ResponseEntity<List<HistoryDTO>> findAll (){
        return new ResponseEntity<>(this.historyService.findAll(), HttpStatus.OK);
    }

    /**
     * Busca el historial y devuelve la lista de usuarios que accedieron a nuestro servidor basandose por el username.
     * @param  username El nombre del usuario a buscar.
     * @return ResponseEntity que contiene un {@link HistoryDTO} con la información del usuario encontrado.
     */
    @PreAuthorize("hasRole('ADMIN') or @interactionLogUser.validate(#username)")
    @GetMapping("/find/{username}")
    public ResponseEntity<List<HistoryDTO>> findByUserName(@PathVariable String username){
        return new ResponseEntity<>(this.historyService.findByName(username), HttpStatus.OK);
    }
}
