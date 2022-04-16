package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.order.Order;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class OrderApp {

    public static void main(String[] args) {

       // AppConfig appConfig = new AppConfig();
       // MemberService memberService = appConfig.memberService();
       // OrderService orderService = appConfig.orderService();

        ApplicationContext applicationContext
                = new AnnotationConfigApplicationContext(AppConfig.class);

        MemberService memberService
                = applicationContext.getBean("memberService", MemberService.class);
                // 하면 반환값으로 뭐가 나온다?
                // new MemberServiceImpl(memberRepository())

        OrderService orderService
                = applicationContext.getBean("orderService", OrderService.class);
                // 하면 반환값으로 뭐가 나온다?
                // new OrderServiceImpl(memberRepository(), discountPolicy()) 나오는 것이다.


        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);//VIP회원을 하나 만든다.
        memberService.join(member); // 맴버서비스의 조인을 통해 메모리 객체에 넣는다.

        // 회원정책에 맞게 1만원짜리 상품을 산다. / 위에 memberId 인 친구를 불러 온것이다.
        Order order = orderService.createOrder(memberId, "itemA", 20000);
        // 위 코드의 결고를 보고 싶으면
        // order = Order{memberId=1, itemName='itemA', itemPrice=10000, discountPrice=1000}
        // 풀이. memberId=1 이 주문 했고, 아이템 이름은 itemA이고, 원가 가격은 10000인데, 할인 금액이 1000이다.

        System.out.println("order = " + order); // 뒤에 order는 order.toString이 호출된다. 생략된것이다.

        // order.calculatePrice = 9000
        System.out.println("order.calculatePrice = " + order.calculatePrice());

    }

}