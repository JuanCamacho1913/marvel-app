package com.api.marvel.controllers;

import com.api.marvel.controllers.dto.HistoryDTO;
import com.api.marvel.services.HistoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/history")
public class HistoryController {

    private HistoryService historyService;

    public HistoryController(HistoryService historyService) {
        this.historyService = historyService;
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/find")
    public ResponseEntity<List<HistoryDTO>> findAll (){
        return new ResponseEntity<>(this.historyService.findAll(), HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN') or @interactionLogUser.validate(#username)")
    @GetMapping("/find/{username}")
    public ResponseEntity<List<HistoryDTO>> findByUserName(@PathVariable String username){
        return new ResponseEntity<>(this.historyService.findByName(username), HttpStatus.OK);
    }
}
