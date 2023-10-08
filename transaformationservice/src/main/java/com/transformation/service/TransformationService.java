package com.transformation.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

@Service
public class TransformationService {

    @Autowired
    private JmsTemplate jmsTemplate;

    private final ObjectMapper jsonMapper = new ObjectMapper();
    private final XmlMapper xmlMapper = new XmlMapper();

    private static final String QUEUE_NAME = "transformationQueue";

    public String transform(String jsonData) throws Exception {
        // Convert JSON string to JsonNode
        JsonNode node = jsonMapper.readTree(jsonData);

        // Convert JsonNode to XML string
        String xmlData = xmlMapper.writeValueAsString(node);

        // Send the XML data to the ActiveMQ queue
        jmsTemplate.convertAndSend(QUEUE_NAME, xmlData);

        return xmlData;
    }
}
