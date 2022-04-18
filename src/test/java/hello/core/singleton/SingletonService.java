package hello.core.singleton;

import org.junit.jupiter.api.Test;

public class SingletonService {

    //자기 자신을 내부에 private으로 하나 가지고 있는데 static 이므로,
    //클래스 레벨에 딱 하나만 존재하게 된다.
    //1. static 영역에 객체를 딱 1개만 생성해둔다.
    private static final SingletonService instance = new SingletonService();

    //2. public으로 열어서 객체 인스턴스가 필요하면 이 static 메서드를 통해서만 조회하도록 허용한다.
    //static 메서드는 static 변수로 지정 되어 있는 것을 가져와서 사용할때 static 메서드를 사용한다.
    //즉, 핵심은 static 메서드에 인스턴스 변수는 들어 올수 있지만,
    //인스턴스 메서드에 static 변수는 들어 올수 없다.
    public static SingletonService getInstance() {
        return instance;
    }

    private SingletonService() {

    }

    public void logic() {
        System.out.println("싱글톤 객체 로직 호출");
    }


}
