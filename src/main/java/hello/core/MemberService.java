package hello.core;

import java.util.List;

public class MemberService {
    private final MemberRepository repository = new MemberRepository();

    public void initializeDatabase() {
        repository.createTable();
    }

    public void addNewMember(String name, String email) {
        repository.addMember(name, email);
    }

    public void listAllMembers() {
        List<Member> members = repository.getAllMembers();
        System.out.println("\n📋 모든 회원 목록:");
        for (Member m : members) {
            System.out.println(m);
        }
    }

    public void findMemberById(int id) {
        Member member = repository.getMemberById(id);
        if (member != null) {
            System.out.println("\n🔍 회원 정보: " + member);
        } else {
            System.out.println("해당 ID의 회원 없음");
        }
    }

    public void updateMember(int id, String newName, String newEmail) {
        repository.updateMember(id, newName, newEmail);
        System.out.println("\n✅ 회원 정보 업데이트 완료!");
    }

    public void deleteMember(int id) {
        repository.deleteMember(id);
        System.out.println("\n🗑️ 회원 삭제 완료!");
    }
}
