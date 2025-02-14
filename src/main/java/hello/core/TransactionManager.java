package hello.core;

import java.sql.Connection;
import java.sql.SQLException;

public class TransactionManager {

    private Connection connection;

    public TransactionManager() throws SQLException {
        this.connection = LimboDatabaseManager.connect();
        this.connection.setAutoCommit(false);
    }

    public void commit() {
        try {
            connection.commit();
            System.out.println("트랜잭션 커밋");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void rollback() {
        try {
            connection.rollback();
            System.out.println("트랜잭션 롤백");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void close() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
