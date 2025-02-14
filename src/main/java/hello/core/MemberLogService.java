package hello.core;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MemberLogService {

    public void logChange(int memberId, String action, String details) {
        String sql = "INSERT INTO member_logs(member_id, action, details, timestamp) VALUES (?, ?, ?, CURRENT_TIMESTAMP)";
        try (Connection conn = LimboDatabaseManager.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, memberId);
            pstmt.setString(2, action);
            pstmt.setString(3, details);
            pstmt.executeUpdate();
            System.out.println("변경 로그 기록");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
