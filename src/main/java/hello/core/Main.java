package hello.core;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        MemberService service = new MemberService();
        service.initializeDatabase();  // 테이블 생성

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\n=== 회원 관리 시스템 ===");
            System.out.println("1. 회원 추가");
            System.out.println("2. 회원 목록 조회");
            System.out.println("3. 특정 회원 조회");
            System.out.println("4. 회원 수정");
            System.out.println("5. 회원 삭제");
            System.out.println("6. 종료");
            System.out.print("선택: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // 개행 문자 처리

            switch (choice) {
                case 1: // 회원 추가
                    System.out.print("\n이름 입력: ");
                    String name = scanner.nextLine();

                    System.out.print("이메일 입력: ");
                    String email = scanner.nextLine();
                    service.addNewMember(name, email);
                    break;

                case 2: // 모든 회원 조회
                    service.listAllMembers();
                    break;

                case 3: // 특정 회원 조회
                    System.out.print("\n조회할 회원 ID 입력: ");
                    int id = scanner.nextInt();
                    service.findMemberById(id);
                    break;

                case 4: // 회원 수정
                    System.out.print("\n수정할 회원 ID 입력: ");
                    int updateId = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("새 이름 입력: ");
                    String newName = scanner.nextLine();

                    System.out.print("새 이메일 입력: ");
                    String newEmail = scanner.nextLine();
                    service.updateMember(updateId, newName, newEmail);
                    break;

                case 5: // 회원 삭제
                    System.out.print("\n삭제할 회원 ID 입력: ");
                    int deleteId = scanner.nextInt();
                    service.deleteMember(deleteId);
                    break;

                case 6: // 종료
                    System.out.println("\n🚪 프로그램 종료");
                    LimboDatabaseManager.close();
                    scanner.close();
                    return;

                default:
                    System.out.println("잘못된 입력");
            }
        }
    }
}
