package hello.core.beanfind;

import hello.core.AppConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ApplicationContextInfoTest {

    AnnotationConfigApplicationContext ac
            = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("모든 빈 출력하기")
    void findAllBean() {
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();
        
        for (String beanDefinitionName : beanDefinitionNames) {
            Object bean = ac.getBean(beanDefinitionName); // 빈을 꺼낸다.
            System.out.println("name = " + beanDefinitionName + ", object = " + bean);
        }
    }

    @Test
    @DisplayName("애플리케이션 빈 출력하기")
    void findApplicationBean() {
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();

        for (String beanDefinitionName : beanDefinitionNames) { //getBeanDefinition이란? 빈에 하나하나에 대한 메타 데이터 정보
            BeanDefinition beanDefinition = ac.getBeanDefinition(beanDefinitionName); // 꺼낼수가 있다.

            // ROLE_APPLICATION 란??
            // 스프링이 내부에서 뭔가를 하기 위해서 등록한게 아니라,
            // 내가 애플리케이션을 개발하기 위해서 등록한 빈이라고 생각하면 되는 것이다.
            if(beanDefinition.getRole() == BeanDefinition.ROLE_APPLICATION) {
                Object bean = ac.getBean(beanDefinitionName); // 빈을 꺼낸다.
                System.out.println("name = " + beanDefinitionName + ", object = " + bean);

            }

        }
    }
}
