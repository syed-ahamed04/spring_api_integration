package com.adapter.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.adapter.entity.JsonRecord;

public interface JsonRecordRepository extends JpaRepository<JsonRecord, Long> {
}
