package com.fapethedev.arango;


import com.arangodb.ArangoDB;
import com.arangodb.ArangoDatabase;

public class App
{
    public static void main( String[] args )
    {
        ArangoDB arangoDB = new ArangoDB.Builder()
        .host("localhost", 8529)
        .build();

//      Let’s connect to or create a new database:
        ArangoDatabase db = arangoDB.db("javadriverv7tutoraildb");
        System.out.println("Creating database...");
        db.create(); // Not possible if using the generated University database
    }
}
