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

import java.io.InputStream;
import java.io.Reader;
import java.math.BigDecimal;
import java.net.URL;
import java.sql.Array;
import java.sql.Blob;
import java.sql.Clob;
import java.sql.Date;
import java.sql.NClob;
import java.sql.ParameterMetaData;
import java.sql.PreparedStatement;
import java.sql.Ref;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.RowId;
import java.sql.SQLException;
import java.sql.SQLXML;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class MongoPreparedStatement extends MongoStatement implements PreparedStatement {

    MongoPreparedStatement(MongoConnection conn, int type, int concurrency, int holdability, String sql)
            throws MongoSQLException {
        super(conn, type, concurrency, holdability);
        _exec = new Executor(conn.getDb(), sql);
    }

    private final Executor _exec;
    private List _params = new ArrayList();

    @Override
    public void addBatch() {
        throw new UnsupportedOperationException("batch stuff not supported");
    }

    // --- metadata ---

    @Override
    public ResultSetMetaData getMetaData() {
        throw new UnsupportedOperationException();
    }

    @Override
    public ParameterMetaData getParameterMetaData() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void clearParameters() {
        throw new UnsupportedOperationException();
    }

    // ----- actually do

    @Override
    public boolean execute() {
        throw new RuntimeException("execute not done");
    }

    @Override
    public ResultSet executeQuery() {
        throw new RuntimeException("executeQuery not done");
    }

    @Override
    public int executeUpdate() throws MongoSQLException {
        _exec.setParams(_params);
        return _exec.writeop();
    }

    // ---- setters -----

    @Override
    public void setArray(int idx, Array x) {
        _setnotdone();
    }

    @Override
    public void setAsciiStream(int idx, InputStream x) {
        _setnotdone();
    }

    @Override
    public void setAsciiStream(int idx, InputStream x, int length) {
        _setnotdone();
    }

    @Override
    public void setAsciiStream(int idx, InputStream x, long length) {
        _setnotdone();
    }

    @Override
    public void setBigDecimal(int idx, BigDecimal x) {
        _setnotdone();
    }

    @Override
    public void setBinaryStream(int idx, InputStream x) {
        _setnotdone();
    }

    @Override
    public void setBinaryStream(int idx, InputStream x, int length) {
        _setnotdone();
    }

    @Override
    public void setBinaryStream(int idx, InputStream x, long length) {
        _setnotdone();
    }

    @Override
    public void setBlob(int idx, Blob x) {
        _setnotdone();
    }

    @Override
    public void setBlob(int idx, InputStream inputStream) {
        _setnotdone();
    }

    @Override
    public void setBlob(int idx, InputStream inputStream, long length) {
        _setnotdone();
    }

    @Override
    public void setBoolean(int idx, boolean x) {
        _setnotdone();
    }

    @Override
    public void setByte(int idx, byte x) {
        _setnotdone();
    }

    @Override
    public void setBytes(int idx, byte[] x) {
        _setnotdone();
    }

    @Override
    public void setCharacterStream(int idx, Reader reader) {
        _setnotdone();
    }

    @Override
    public void setCharacterStream(int idx, Reader reader, int length) {
        _setnotdone();
    }

    @Override
    public void setCharacterStream(int idx, Reader reader, long length) {
        _setnotdone();
    }

    @Override
    public void setClob(int idx, Clob x) {
        _setnotdone();
    }

    @Override
    public void setClob(int idx, Reader reader) {
        _setnotdone();
    }

    @Override
    public void setClob(int idx, Reader reader, long length) {
        _setnotdone();
    }

    @Override
    public void setDate(int idx, Date x) {
        _setnotdone();
    }

    @Override
    public void setDate(int idx, Date x, Calendar cal) {
        _setnotdone();
    }

    @Override
    public void setDouble(int idx, double x) {
        _setnotdone();
    }

    @Override
    public void setFloat(int idx, float x) {
        _setnotdone();
    }

    @Override
    public void setInt(int idx, int x) {
        _set(idx, x);
    }

    @Override
    public void setLong(int idx, long x) {
        _set(idx, x);
    }

    @Override
    public void setNCharacterStream(int idx, Reader value) {
        _setnotdone();
    }

    @Override
    public void setNCharacterStream(int idx, Reader value, long length) {
        _setnotdone();
    }

    @Override
    public void setNClob(int idx, NClob value) {
        _setnotdone();
    }

    @Override
    public void setNClob(int idx, Reader reader) {
        _setnotdone();
    }

    @Override
    public void setNClob(int idx, Reader reader, long length) {
        _setnotdone();
    }

    @Override
    public void setNString(int idx, String value) {
        _setnotdone();
    }

    @Override
    public void setNull(int idx, int sqlType) {
        _setnotdone();
    }

    @Override
    public void setNull(int idx, int sqlType, String typeName) {
        _setnotdone();
    }

    @Override
    public void setObject(int idx, Object x) {
        _set(idx, x);
    }

    @Override
    public void setObject(int idx, Object x, int targetSqlType) {
        _setnotdone();
    }

    @Override
    public void setObject(int idx, Object x, int targetSqlType, int scaleOrLength) {
        _setnotdone();
    }

    @Override
    public void setRef(int idx, Ref x) {
        _setnotdone();
    }

    @Override
    public void setRowId(int idx, RowId x) {
        _setnotdone();
    }

    @Override
    public void setShort(int idx, short x) {
        _set(idx, x);
    }

    @Override
    public void setSQLXML(int idx, SQLXML xmlObject) {
        _setnotdone();
    }

    @Override
    public void setString(int idx, String x) {
        _set(idx, x);
    }

    @Override
    public void setTime(int idx, Time x) {
        _setnotdone();
    }

    @Override
    public void setTime(int idx, Time x, Calendar cal) {
        _setnotdone();
    }

    @Override
    public void setTimestamp(int idx, Timestamp x) {
        _setnotdone();
    }

    @Override
    public void setTimestamp(int idx, Timestamp x, Calendar cal) {
        _setnotdone();
    }

    @Override @Deprecated
    public void setUnicodeStream(int idx, InputStream x, int length) {
        _setnotdone();
    }

    @Override
    public void setURL(int idx, URL x) {
        _setnotdone();
    }

    @Override
    public void closeOnCompletion() throws SQLException {

    }

    @Override
    public boolean isCloseOnCompletion() throws SQLException {
        return false;
    }

    private void _setnotdone() {
        throw new UnsupportedOperationException("setter not done");
    }

    private void _set(int idx, Object o) {
        while (_params.size() <= idx) {
            _params.add(null);
        }
        _params.set(idx, o);
    }
}
