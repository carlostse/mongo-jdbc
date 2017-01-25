/*
 * Copyright 2017 Carlos Tse <copperoxide@gmail.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class First {

    static void print(String name, ResultSet res) throws SQLException {
        System.out.println(name);
        while (res.next()) {
            System.out.println(
                    "\t" + res.getString("email") +
                    "\t" + res.getInt("age") +
                    "\t" + res.getObject(0)
            );
        }
    }

    public static void main(String args[]) throws SQLException, ClassNotFoundException {

        Class.forName("com.mongodb.jdbc.MongoDriver");

        Connection c = DriverManager.getConnection("jdbc:mongodb://127.0.0.1:27017,slave:27017/test");

        Statement stmt = c.createStatement();

        // drop old table
        stmt.executeUpdate("DROP TABLE people");

        // insert some data
        stmt.executeUpdate("INSERT INTO people (name, age) VALUES ('Eliot' , 30)");
        stmt.executeUpdate("INSERT INTO people (name, age) VALUES ('Sara'  , 12)");
        stmt.executeUpdate("INSERT INTO people (name, age) VALUES ('Jaime' , 28)");

        String baseSQL = "SELECT name, age FROM people";

        // query
        print("not sorted", stmt.executeQuery(baseSQL));
        print("where", stmt.executeQuery(baseSQL + " WHERE name = 'Eliot'"));
        print("sorted by age", stmt.executeQuery(baseSQL + " ORDER BY age"));
        print("sorted by age desc", stmt.executeQuery(baseSQL + " ORDER BY age DESC LIMIT 2,1"));

        // update
        stmt.executeUpdate("UPDATE people SET age = 32 WHERE name = 'Jaime'");
        print("after update", stmt.executeQuery(baseSQL + " ORDER BY age DESC"));
    }

} 
