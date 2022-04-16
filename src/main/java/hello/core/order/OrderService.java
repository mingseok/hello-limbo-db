package hello.core.order;

public interface OrderService {

    // 회원id, 상품명, 상품 가격

    // 여기의 앞에 Order는 리턴타입이다.
    Order createOrder(Long memberId, String itemName, int itemPrice);

}