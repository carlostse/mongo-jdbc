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
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Blog {

    static void print(String name, ResultSet res) throws SQLException {
        System.out.println(name);
        while (res.next()) {
            System.out.println(
                    "\t" + res.getInt("num") +
                    "\t" + res.getString("title") +
                    "\t" + res.getObject("tags")
            );
        }
    }

    public static void main(String args[]) throws SQLException, ClassNotFoundException {

        Class.forName("com.mongodb.jdbc.MongoDriver");

        Connection c = DriverManager.getConnection("mongodb://127.0.0.1:27017/test");

        Statement st = c.createStatement();
        st.executeUpdate("drop table blogposts");

        PreparedStatement ps = c.prepareStatement("insert into blogposts ( title , tags , num ) values ( ? , ? , ? )");
        ps.setString(1, "first post!");
        ps.setObject(2, new String[]{"fun", "eliot"});
        ps.setInt(3, 1);
        ps.executeUpdate();

        ps.setString(1, "wow - this is cool");
        ps.setObject(2, new String[]{"eliot", "bar"});
        ps.setInt(3, 2);
        ps.executeUpdate();
        ps.close();

        print("num should be 1 ", st.executeQuery("select * from blogposts where tags='fun'"));
        print("num should be 2 ", st.executeQuery("select * from blogposts where tags='bar'"));
    }

} 
