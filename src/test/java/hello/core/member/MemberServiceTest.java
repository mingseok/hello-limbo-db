package hello.core.member;

import hello.core.AppConfig;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MemberServiceTest {

    // MemberService memberService = new MemberServiceImpl();

    MemberService memberService;

    @BeforeEach
    public void beforeEach() {
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
    }

    @Test
    void join() {
        //given : 뭐가 주어 졌을때
        Member member = new Member(1L, "memberA", Grade.VIP);

        //when : 이거를 실행 했을때
        memberService.join(member);
        Member findMember = memberService.findMember(1L); // 만약 2L로 하면 에러가 발생하는 것이다.

        //then : 결과가 이게 나와야 해.
        Assertions.assertThat(member).isEqualTo(findMember);

    }

}
