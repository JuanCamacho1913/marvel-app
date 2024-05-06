package com.api.marvel.controllers.dto;

import java.time.LocalDateTime;

public record HistoryDTO(Long id,
                         String url,
                         String httpMethod,
                         String username,
                         LocalDateTime timestamp,
                         String remoteAddress) {
}
