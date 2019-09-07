package com.kittystore.datalayer.data;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.Closeable;
import java.math.BigDecimal;
import java.sql.*;

//TODO HOW TO TEST THIS?
public class JdbcHandler implements Closeable, AutoCloseable {
    private static JdbcHandler instance;
    private static final Logger logger = LogManager.getLogger(JdbcHandler.class);
    private Connection con;
    private Statement statement;
    private PreparedStatement preparedStatement;
    private ResultSet results;
    private int parameterCount = 1;
    private boolean isTransaction = false;

    private JdbcHandler() {
        con = getConnection();
    }

    public static JdbcHandler getInstance() {
        instance = instance == null ? new JdbcHandler() : instance;
        return instance;
    }

    private Connection getConnection() {
        if (con != null) return con;
        try {
            con = DriverManager.getConnection(
                    "jdbc:mariadb://noelvaes.eu/javaeewondelgemDB12",
                    "javaeewondelgem",
                    "java€€wond€lg€m2019"
            );
        } catch (SQLException sqle) {
            throw new RuntimeException(sqle);
        }
        return con;
    }

    boolean isTransaction() {
        return isTransaction;
    }

    boolean setTransaction(boolean isTransaction) {
        if (preparedStatement == null && statement == null && con != null) {
            this.isTransaction = isTransaction;

            try {
                con.setAutoCommit(false);
            } catch (SQLException sqle) {
                throw new RuntimeException(sqle);
            }
            return true;
        }
        return false;
    }

    ResultSet getResults() {
        return results;
    }

    private void setResults(ResultSet results) {
        this.results = results;
    }

    void prepareStatement(String sql) {
        try {
            preparedStatement = con.prepareStatement(sql);
        } catch (SQLException sqle) {
            throw new RuntimeException(sqle);
        }
    }

    boolean setParameter(int param) {
        if (preparedStatement == null) return false;
        try {
            preparedStatement.setInt(parameterCount++, param);
            return true;
        } catch (SQLException sqle) {
            throw new RuntimeException(sqle);
        }
    }

    boolean setParameter(BigDecimal param) {
        if (preparedStatement == null) return false;
        try {
            preparedStatement.setBigDecimal(parameterCount++, param);
            return true;
        } catch (SQLException sqle) {
            throw new RuntimeException(sqle);
        }
    }

    boolean setParameter(String param) {
        if (preparedStatement == null) return false;
        try {
            preparedStatement.setString(parameterCount++, param);
            return true;
        } catch (SQLException sqle) {
            throw new RuntimeException(sqle);
        }
    }

    boolean setParameter(Timestamp param) {
        if (preparedStatement == null) return false;
        try {
            preparedStatement.setTimestamp(parameterCount++, param);
            return true;
        } catch (SQLException sqle) {
            throw new RuntimeException(sqle);
        }
    }

    void executeUpdate() {
        try {
            preparedStatement.executeUpdate();
        } catch (SQLException sqle) {
            throw new RuntimeException(sqle);
        }
    }

    void executeQuery() {
        try {
            setResults(preparedStatement.executeQuery());
        } catch (SQLException sqle) {
            throw new RuntimeException(sqle);
        }
    }

    void executeStatement(String sql) {
        try {
            statement = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            statement.executeQuery(sql);
        } catch (SQLException sqle) {
            throw new RuntimeException(sqle);
        }
    }

    void updateStatement(String sql) {
        try {
            statement = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            statement.executeUpdate(sql);
        } catch (SQLException sqle) {
            throw new RuntimeException(sqle);
        }
    }

    boolean commit() {
        if (isTransaction()) {
            try {
                con.commit();
                return true;
            } catch (SQLException sqle) {
                throw new RuntimeException(sqle);
            }
        }
        return false;
    }

    private void closeConnection() {
        try {
            con.close();
        } catch (SQLException sqle) {
            throw new RuntimeException(sqle);
        }
    }

    public void close() {
        closeConnection();
    }
}
