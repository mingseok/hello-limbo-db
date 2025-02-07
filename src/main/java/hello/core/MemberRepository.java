package hello.core;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MemberRepository {

    public void createTable() {
        String sql = "CREATE TABLE IF NOT EXISTS members (id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT, email TEXT)";
        try (Connection conn = LimboDatabaseManager.connect();
             Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
            System.out.println("✅ members 테이블 생성 완료");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addMember(String name, String email) {
        String sql = "INSERT INTO members(name, email) VALUES (?, ?)";
        try (Connection conn = LimboDatabaseManager.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, name);
            pstmt.setString(2, email);
            pstmt.executeUpdate();
            System.out.println("✅ 회원 추가: " + name);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Member> getAllMembers() {
        List<Member> members = new ArrayList<>();
        String sql = "SELECT * FROM members";
        try (Connection conn = LimboDatabaseManager.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                members.add(new Member(rs.getInt("id"), rs.getString("name"), rs.getString("email")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return members;
    }

    public Member getMemberById(int id) {
        String sql = "SELECT * FROM members WHERE id = ?";
        try (Connection conn = LimboDatabaseManager.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return new Member(rs.getInt("id"), rs.getString("name"), rs.getString("email"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void updateMember(int id, String newName, String newEmail) {
        String sql = "UPDATE members SET name = ?, email = ? WHERE id = ?";
        try (Connection conn = LimboDatabaseManager.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, newName);
            pstmt.setString(2, newEmail);
            pstmt.setInt(3, id);
            int affectedRows = pstmt.executeUpdate();
            if (affectedRows > 0) {
                System.out.println("✅ 회원 수정 완료: ID = " + id);
            } else {
                System.out.println("수정 실패: ID=" + id + " 없음");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteMember(int id) {
        String sql = "DELETE FROM members WHERE id = ?";
        try (Connection conn = LimboDatabaseManager.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            int affectedRows = pstmt.executeUpdate();
            if (affectedRows > 0) {
                System.out.println("🗑 회원 삭제 완료: ID = " + id);
            } else {
                System.out.println("삭제 실패: ID = " + id + " 없음");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
