package com.api.marvel.services;

import com.api.marvel.controllers.dto.HistoryDTO;

import java.util.List;

public interface HistoryService {


    List<HistoryDTO> findAll();

    List<HistoryDTO> findByName(String username);
}
