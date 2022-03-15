package hello.core.singleton;

import hello.core.AppConfig;
import hello.core.member.MemberRespository;
import hello.core.member.MemberServiceImp;
import hello.core.order.OrderServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.*;

public class ConfigurationSingletonTest {

    @Test
    void configurationTest() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

        MemberServiceImp memberService = ac.getBean("memberService", MemberServiceImp.class);
        OrderServiceImpl orderService = ac.getBean("orderService", OrderServiceImpl.class);
        MemberRespository memberRepository = ac.getBean("memberRepository", MemberRespository.class);

        MemberRespository memberRepository1 = memberService.getMemberRespository();
        MemberRespository memberRepository2 = orderService.getMemberRespository();

        System.out.println("memberService -> memberRepository = " + memberRepository1);
        System.out.println("orderService -> memberRepository = " + memberRepository2);
        System.out.println("memberRepository = " + memberRepository);

        assertThat(memberService.getMemberRespository()).isSameAs(memberRepository);
        assertThat(orderService.getMemberRespository()).isSameAs(memberRepository);
    }

    @Test
    void configurationDeep() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        AppConfig bean = ac.getBean(AppConfig.class);

        System.out.println("bean = " + bean.getClass());

    }
}
