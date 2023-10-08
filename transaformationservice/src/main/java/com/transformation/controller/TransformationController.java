package com.transformation.controller;

import com.transformation.service.TransformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TransformationController {

    @Autowired
    private TransformationService transformationService;

    @PostMapping("/transform")
    public String transform(@RequestBody String jsonData) throws Exception {
        return transformationService.transform(jsonData);
    }
}
