package hello.core;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class BulkInsertService {

    public void addMembersBatch(List<Member> members) {
        String sql = "INSERT INTO members(name, email) VALUES (?, ?)";
        try (Connection conn = LimboDatabaseManager.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            conn.setAutoCommit(false);

            for (Member member : members) {
                pstmt.setString(1, member.getName());
                pstmt.setString(2, member.getEmail());
                pstmt.addBatch();
            }

            pstmt.executeBatch();
            conn.commit();
            System.out.println("대량 데이터 삽입 완료!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
