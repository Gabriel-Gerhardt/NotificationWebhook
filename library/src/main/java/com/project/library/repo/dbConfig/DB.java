package com.project.library.repo.dbConfig;

import org.springframework.stereotype.Component;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class DB {
    static String DB_URL = "jdbc:oracle:thin:@libraryDB:1521/FREEPDB1";
    static final String ROOT_USER = "system";
    static final String ROOT_PASSWORD = "password";

    public Connection dbConnection() {
        Connection conn;
        try {
            conn = DriverManager.getConnection(DB_URL, ROOT_USER, ROOT_PASSWORD);
            Statement stmt = conn.createStatement();
            String grantSQL = "GRANT CONNECT, RESOURCE TO system";
            stmt.executeUpdate(grantSQL);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return conn;
    }
}
