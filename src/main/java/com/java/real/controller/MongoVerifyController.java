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

    @Autowired
    MongoTemplate mongoTemplate;

   @RestController
public class DbController {

    private final MongoTemplate mongoTemplate;
    private final MongoClient mongoClient; // Spring-managed

    public DbController(MongoTemplate mongoTemplate, MongoClient mongoClient) {
        this.mongoTemplate = mongoTemplate;
        this.mongoClient = mongoClient;
    }

    @GetMapping("/mongo-db")
    public String db() {
        String dbName = mongoTemplate.getDb().getName();
        MongoDatabase db = mongoClient.getDatabase(dbName);

        StringBuilder sb = new StringBuilder("DB: ").append(dbName).append("\nCollections:\n");
        for (String name : db.listCollectionNames()) {
            System.out.println("Collection: " + name);
            sb.append("- ").append(name).append("\n");
        }
        return sb.toString();
    }
}
}
