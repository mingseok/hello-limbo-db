package hello.core;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MemberPaginationService {

    public List<Member> getMembersWithPagination(int page, int pageSize) {
        List<Member> members = new ArrayList<>();
        String sql = "SELECT * FROM members LIMIT ? OFFSET ?";

        try (Connection conn = LimboDatabaseManager.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, pageSize);
            pstmt.setInt(2, (page - 1) * pageSize);

            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                members.add(new Member(rs.getInt("id"), rs.getString("name"), rs.getString("email")));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return members;
    }
}
