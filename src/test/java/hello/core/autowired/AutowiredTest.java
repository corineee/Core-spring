package hello.core.autowired;

import hello.core.member.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.lang.Nullable;

import java.util.Optional;

public class AutowiredTest {

    @Test
    void AutowiredOption() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestBean.class);
    }

    static class TestBean {

        //의존관계가 없으면 required = false한 메서드는 호출이 안된다.
        @Autowired(required = false)
        public void setNoBean1(Member noBean1) { //Member는 스프링 빈이 아니다.
            System.out.println("noBean1 = " + noBean1);
        }

        //@Nullable을 넣으면 호출은 되지만 null로 들어간다.
        @Autowired
        public void setNoBean2(@Nullable Member noBean2) {
            System.out.println("noBean2 = " + noBean2);
        }

        //Optional은 스프링빈이 없으면 Optional.empty라는 값으로 들어간다.
        @Autowired
        public void setNoBean3(Optional<Member> noBean3) {
            System.out.println("noBean3 = " + noBean3);
        }
        //@Nullable, Optional은 스프링 전반에 걸려서 지원한다.
        //Ex) 생성자 자동 주입에서 특정 필드에만 사용해도 된다.

    }


}
