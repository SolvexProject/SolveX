package com.java.real.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

@RestController
public class MongoVerifyController {

    private final MongoTemplate mongoTemplate;

    public MongoVerifyController(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @GetMapping("/mongo-db")
    public String db() {
        String dbName = mongoTemplate.getDb().getName();
        System.out.println("Connected DB (via MongoTemplate): " + dbName);

        StringBuilder sb = new StringBuilder("DB: ").append(dbName).append("\nCollections:\n");
        for (String name : mongoTemplate.getDb().listCollectionNames()) {
            System.out.println("Collection: " + name);
            sb.append("- ").append(name).append("\n");
        }
        return sb.toString();
    }
}

