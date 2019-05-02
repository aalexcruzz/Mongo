
package com.mycompany.mongo;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;

public class SampleInsert{

    private final static String HOST = "localhost";
    private final static int PORT = 27017;
    
    
    public static void main( String args[] ){
        try{

            MongoClient mongoClient = new MongoClient(HOST,PORT );

            DB db = mongoClient.getDB( "sampledb" );

            DBCollection coll = db.getCollection("javastuff");
            DBObject doc = new BasicDBObject("name","frank")
             .append("age", 31)
             .append("info", new BasicDBObject("email",
             "frank@mail.com").append("phone", "222-111-444"));


            coll.insert(doc);

            }
        catch(Exception e){
        System.err.println( e.getClass().getName() + ": " +
        e.getMessage() );
        }
    }
}