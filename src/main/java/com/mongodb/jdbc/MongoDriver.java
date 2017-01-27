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

package com.mongodb.jdbc;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.DriverPropertyInfo;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.Properties;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MongoDriver implements Driver {

    private static final String CONNECTION_PATTERN = "jdbc:(mongodb://[^/]+)/(\\w+)";

    static {
        try {
            DriverManager.registerDriver(new MongoDriver());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public MongoDriver() {
        super();
    }

    @Override
    public boolean acceptsURL(String url) {
        Matcher matcher = Pattern.compile(CONNECTION_PATTERN).matcher(url);
        return matcher.find();
    }

    /**
     * Get the MongoConnection from connection string.
     *
     * Warning: Properties is not supported yet
     * @param url - connection string
     * @param info - must be null or empty
     * @return <class>MongoConnection</class>
     * @throws SQLException
     */
    @Override
    public Connection connect(String url, Properties info) throws SQLException {

        if (info != null && info.size() > 0)
            throw new UnsupportedOperationException("properties not supported yet");

        Matcher matcher = Pattern.compile(CONNECTION_PATTERN).matcher(url);

        // throw exception if the regular expression does not match,
        if (!matcher.find())
            throw new MongoSQLException("Invalid connection string: " + url);


        MongoClient client = new MongoClient(new MongoClientURI(matcher.group(1)));
        return new MongoConnection(client.getDB(matcher.group(2)));

    }

    @Override
    public int getMajorVersion() {
        return 1;
    }

    @Override
    public int getMinorVersion() {
        return 0;
    }

    @Override
    public DriverPropertyInfo[] getPropertyInfo(String url, Properties info) {
        throw new UnsupportedOperationException("getPropertyInfo doesn't work yet");
    }

    @Override
    public boolean jdbcCompliant() {
        return false;
    }

    @Override
    public Logger getParentLogger() throws SQLFeatureNotSupportedException {
        return null;
    }
}
