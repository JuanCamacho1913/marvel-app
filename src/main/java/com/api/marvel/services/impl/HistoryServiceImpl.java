package com.api.marvel.services.impl;

import com.api.marvel.controllers.dto.HistoryDTO;
import com.api.marvel.persistence.repositories.HistoryRepository;
import com.api.marvel.services.HistoryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class HistoryServiceImpl implements HistoryService {

    private HistoryRepository historyRepository;

    public HistoryServiceImpl(HistoryRepository historyRepository) {
        this.historyRepository = historyRepository;
    }

    @Override
    public List<HistoryDTO> findAll() {
        return this.historyRepository.findAll()
                .stream()
                .map(entity -> new HistoryDTO(
                        entity.getId(),
                        entity.getUrl(),
                        entity.getHttpMethod(),
                        entity.getUsername(),
                        entity.getTimestamp(),
                        entity.getRemoteAddress()))
                .collect(Collectors.toList());
    }

    @Override
    public List<HistoryDTO> findByName(String username) {
        return this.historyRepository.findHistoryEntitiesByUsername(username)
                .stream()
                .map(entity -> new HistoryDTO(
                        entity.getId(),
                        entity.getUrl(),
                        entity.getHttpMethod(),
                        entity.getUsername(),
                        entity.getTimestamp(),
                        entity.getRemoteAddress()))
                .collect(Collectors.toList());
    }
}
