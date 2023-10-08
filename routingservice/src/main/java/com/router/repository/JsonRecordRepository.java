package com.router.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.routing.entity.JsonRecord;

import java.util.List;

@Repository
public interface JsonRecordRepository extends JpaRepository<JsonRecord, Long> {
    List<JsonRecord> findByStatus(String status);
}
