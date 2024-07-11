package com.fapethedev.arango;

import com.arangodb.ArangoCollection;
import com.arangodb.ArangoCursor;
import com.arangodb.ArangoDB;
import com.arangodb.ArangoDatabase;
import com.arangodb.entity.BaseDocument;

import java.io.IOException;
import java.util.Collections;
import java.util.Map;

public class AqlQueries
{
    public static void main(String[] args)
    {
//      Getting connection from our arangoDB instance
        ArangoDB arangoDB = new ArangoDB.Builder()
                .host("localhost", 8529)
                .user("root")
                .password("tbDmKOCz0UaTU3LL")
                .build();

//      Let’s connect to our new database:
        ArangoDatabase db = arangoDB.db("javadriverv7tutoraildb");

        ArangoCollection collection = db.collection("firstCollection");

        for (int i = 0; i < 10; i++) {
            BaseDocument value = new BaseDocument(String.valueOf(i));
            value.addAttribute("name", "Homer");
            collection.insertDocument(value);
        }

        String query = "FOR t IN firstCollection FILTER t.name == @name RETURN t";
        Map<String, Object> bindVars = Collections.singletonMap("name", "Homer");
        System.out.println("Executing read query ...");

        try (ArangoCursor<BaseDocument> cursor = db.query(query, BaseDocument.class, bindVars)) {
            cursor.forEach(aDocument -> System.out.println("Key: " + aDocument.getKey()));
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
