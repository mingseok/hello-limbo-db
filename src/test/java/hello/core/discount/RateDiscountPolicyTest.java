package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RateDiscountPolicyTest {

    RateDiscountPolicy discountPolicy = new RateDiscountPolicy();

    @Test
    @DisplayName("VIP는 10% 할인이 적용되어야 한다.")
    void vip_o() {
        //given
        //회원을 만든다.
        Member member = new Member(1L, "memberVIP", Grade.VIP);

        //when
        //discountPolicy 10%할인 금액 부분을 하는 것이다.
        int discount = discountPolicy.discount(member, 10000);

        //then
        //검증한다. vip는 1천 할인이 적용 되어야 하는 것이다.
        Assertions.assertThat(discount).isEqualTo(1000);
    }


    @Test
    @DisplayName("VIP가 아니면 할인이 적용되지 않아야 한다.")
    void vip_x() {
        //given
        //VIP가 아닌 회원을 만든다.
        Member member = new Member(2L, "memberBASIC", Grade.BASIC);

        //when
        //discountPolicy 할인 금액은 0원이다.
        int discount = discountPolicy.discount(member, 10000);

        //then
        //검증한다. vip가 아니므로 할인 금액은 0원이 되어야 하는 것이다.
        Assertions.assertThat(discount).isEqualTo(0);
    }

}