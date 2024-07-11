package com.fapethedev.arango;


import com.arangodb.ArangoCollection;
import com.arangodb.ArangoDB;
import com.arangodb.ArangoDatabase;
import com.arangodb.entity.BaseDocument;

import java.util.Date;

public class App
{
    public static void main( String[] args )
    {
        ArangoDB arangoDB = new ArangoDB.Builder()
                .host("localhost", 8529)
                .user("root")
                .password("tbDmKOCz0UaTU3LL")
                .build();

//      Let’s connect to or create a new database:
        ArangoDatabase db = arangoDB.db("javadriverv7tutoraildb");
        System.out.println("Creating database...");
        db.create(); // Not possible if using the generated University database

//      Now let’s create our first collection:
        ArangoCollection collection = db.collection("firstCollection");
        System.out.println("Creating collection...");
        collection.create();

        String key = "myKey";
        BaseDocument doc = new BaseDocument(key);
        doc.addAttribute("Apprentice", "Fapethedev");
        doc.addAttribute("Date", new Date());
        System.out.println("Inserting document...");
        collection.insertDocument(doc);

        System.out.println("Reading document...");
        BaseDocument readDocument = collection.getDocument(key, BaseDocument.class);

        System.out.println("Key: " + readDocument.getKey());
        System.out.println("Attribute a: " + readDocument.getAttribute("Apprentice"));
        System.out.println("Attribute b: " + readDocument.getAttribute("Date"));
    }
}
