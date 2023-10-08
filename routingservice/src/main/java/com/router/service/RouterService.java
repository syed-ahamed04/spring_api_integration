package com.router.service;


import com.router.repository.JsonRecordRepository;
import com.routing.entity.JsonRecord;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class RouterService {

    private final JsonRecordRepository repository;
    private final RestTemplate restTemplate;

    public RouterService(JsonRecordRepository repository, RestTemplate restTemplate) {
        this.repository = repository;
        this.restTemplate = restTemplate;
    }

    public void routeUnprocessedRecords() {
        List<JsonRecord> unprocessedRecords = repository.findByStatus("UNPROCESSED");

        for (JsonRecord record : unprocessedRecords) {
            // Redirect to transformation service
            String response = restTemplate.postForObject("http://localhost:9061/api/transform", 
                                                        record.getJsonData(), 
                                                        String.class);
            
            // After redirection, update the status
            record.setStatus("PROCESSED");
            repository.save(record);
        }
    }
}
