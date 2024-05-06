package com.api.marvel.persistence.repositories;

import com.api.marvel.controllers.dto.HistoryDTO;
import com.api.marvel.persistence.entity.HistoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HistoryRepository extends JpaRepository<HistoryEntity, Long> {

//    @Query("SELECT h FROM HistoryEntity h WHERE h.username = ?")
//    List<HistoryEntity> findByUsername(String username);

    List<HistoryEntity> findHistoryEntitiesByUsername(String username);

}
