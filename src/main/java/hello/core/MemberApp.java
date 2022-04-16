package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {

    public static void main(String[] args) {

        ApplicationContext applicationContext
                = new AnnotationConfigApplicationContext(AppConfig.class);

        // 앞에 name인 부분은 메서드 이름을 말하는 것이다. 두번째는 타입이다.
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);

        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember(1L); // '키' 를 넘겨준것이다.

        System.out.println("new member = " + member.getName());
        System.out.println("find Member = " + findMember.getName());

    }

}










