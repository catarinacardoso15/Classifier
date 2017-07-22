package com.classifier.DTO;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by Catarina Cardoso on 02/07/2017.
 */
public class SqlDTO {
    private DataSource datasource;
    Connection connectionMySql;


    public SqlDTO(DataSource datasource) {
    }

    public DataSource getDatasource() {
        return datasource;
    }

    public void setDatasource(DataSource datasource) {
        this.datasource = datasource;
    }

    public Connection getConnectionMySql() {
        return connectionMySql;
    }

    public void setConnectionMySql(Connection connectionMySql) {
        this.connectionMySql = connectionMySql;
    }

    public void connect() {
        try {
            this.connectionMySql = this.datasource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if(this.connectionMySql != null){
                disconnect();
            }

        }
    }

    public void disconnect() {
        try {
            this.connectionMySql.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insert(String table){
        String sql = "INSERT INTO "+table+" (CUST_ID, NAME, AGE) VALUES (?, ?, ?)";
    }
}