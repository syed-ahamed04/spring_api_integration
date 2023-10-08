package com.adapter.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.adapter.service.AdapterService;

@RestController
public class AdapterController {

    private final AdapterService service;

    public AdapterController(AdapterService service) {
        this.service = service;
    }

    @PostMapping("/ingest")
    public String ingestJson(@RequestBody String jsonData) {
        service.saveJson(jsonData);
        return "Data saved successfully!";
    }
}
