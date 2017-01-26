package com.mongodb.jdbc;

import org.junit.Test;
import java.sql.DriverManager;
import static org.junit.Assert.assertNotNull;

public class DriverTest extends Base {

    @Test
    public void test1() throws Exception {
        String dbHost = System.getenv("mongodb");
        if (dbHost == null || dbHost.length() < 1)
            dbHost = "localhost";

        String dbName = System.getenv("database");
        if (dbName == null || dbName.length() < 1)
            dbName = "test";

        String connString = "jdbc:mongodb://" + dbHost + "/" + dbName;
        System.out.println("connect: " + connString);

        try {
            conn = DriverManager.getConnection(connString);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        assertNotNull(conn);
    }

}
