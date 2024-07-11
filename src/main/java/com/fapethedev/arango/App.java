package com.fapethedev.arango;


import com.arangodb.ArangoDB;

public class App
{
    public static void main( String[] args )
    {
        ArangoDB arangoDB = new ArangoDB.Builder()
        .host("localhost", 8529)
        .build();
    }
}
