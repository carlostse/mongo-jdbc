package com.mongodb.jdbc;

import java.sql.Connection;

public abstract class Base {

    protected Connection conn;

    static {
        try {
            Class.forName("com.mongodb.jdbc.MongoDriver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}

