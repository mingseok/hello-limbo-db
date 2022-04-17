package hello.core.beanfind;

import hello.core.AppConfig;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.jupiter.api.Assertions.*;

public class ApplicationContextBasicFindTest {


    AnnotationConfigApplicationContext ac
            = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("빈 이름으로 조회")
    void findBeanByName() {
        MemberService memberService = ac.getBean("memberService", MemberService.class);
        System.out.println("memberService = " + memberService); // 빈에서 꺼내서 가져 온것이다. 임포이다.
        System.out.println("memberService.getClass() = " + memberService.getClass()); // 빈의 클래스 이름을 가져 온것이다.

        // memberService가 MemberServiceImpl의 인스턴스면 성공 하는 것이다.
        Assertions.assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
    }

    // 이렇게도 가능하다.!!!!!!!!!!!!!!!!!!!!
    @Test
    @DisplayName("이름 없이 타입으로만 조회")
    void findBeanByType() {
        MemberService memberService = ac.getBean(MemberService.class);
        Assertions.assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
    }

    // 이건 좋은 방법의 코드가 아니다.
    // 하지만 이런 방법도 된다는걸 알고 있기.
    @Test
    @DisplayName("구체 타입으로 조회")
    void findBeanByName2() {
        MemberServiceImpl memberService = ac.getBean("memberService", MemberServiceImpl.class);

        Assertions.assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
    }

    // 안될때 검사하는 코스
    @Test
    @DisplayName("빈 이름으로 조회")
    void findBeanByNameX() {
        //즉, xxxx 라는 이런 빈을 등록한 적이 없는데 사용하였기 때문이다.

        // 밑에 람다식 안으로 넣었다. ac.getBean("xxxx", MemberService.class);
        //MemberService xxxx = ac.getBean("xxxx", MemberService.class);

        //import static org.junit.jupiter.api.Assertions.*; 이걸 해줘야 한다.

        //이 예외가 터져야(된다) 제대로 된 코드를 작성 한것이다. == 테스트 성공이다
        //람다식 58번째 코드를 실행하면 57번째 에러가 터져야 된다는 뜻이다. 그래야 테스트 코드 성공이다.
        assertThrows(NoSuchBeanDefinitionException.class,
                () -> ac.getBean("xxxx", MemberService.class));

    }


}
