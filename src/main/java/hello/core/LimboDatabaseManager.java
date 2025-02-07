package hello.core;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class LimboDatabaseManager {
    private static final String DB_URL = "jdbc:sqlite:members.db";
    private static Connection connection;

    public static Connection connect() throws SQLException {
        try {
            Class.forName("org.sqlite.JDBC");
            if (connection == null || connection.isClosed()) {
                connection = DriverManager.getConnection(DB_URL);
                System.out.println("✅ LimboDB 연결 성공!");
            }
            return connection;
        } catch (ClassNotFoundException e) {
            throw new SQLException("SQLite JDBC 드라이버를 찾을 수 없습니다!", e);
        }
    }

    public static void close() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
                System.out.println("LimboDB 연결 닫힘");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
