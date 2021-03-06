package net.azib.java.students.t104971.homework.athletics.util;

import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author Jaroslav Judin
 */
public class DbConnection {

    private Logger log = Logger.getLogger(getClass());
    private Connection connection;

    public Connection connect() {
        try {
            connection = DriverManager.getConnection(
                    System.getProperty("url"),
                    System.getProperty("usr"),
                    System.getProperty("pwd"));
        } catch (SQLException e) {
            log.error("Cannot get db connection", e);
            close();
        }
        return connection;
    }

    void close() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                log.error("Cannot close connection", e);
            }
        }
    }

}
