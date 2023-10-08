package com.adapter.service;

import org.springframework.stereotype.Service;
import com.adapter.entity.JsonRecord;
import com.adapter.repository.JsonRecordRepository;

@Service
public class AdapterService {

    private final JsonRecordRepository repository;

    public AdapterService(JsonRecordRepository repository) {
        this.repository = repository;
    }

    public JsonRecord saveJson(String jsonData) {
        JsonRecord record = new JsonRecord();
        record.setJsonData(jsonData);
        record.setStatus("UNPROCESSED");
        return repository.save(record);
    }
}
