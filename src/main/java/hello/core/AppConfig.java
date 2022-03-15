package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.MemberRespository;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImp;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// 애플리케이션 전체를 설정하고 구성하는 클래스
@Configuration // 설정정보
public class AppConfig { // 객체를 생성하고 관리하면서 의존관계를 연결해주는 것 : ioC컨테이너 or DI컨테이너

    //@Bean memberService -> new MemoryMemberReapository()
    //@Bean orderService -> new MemoryMemberReapository()

    //call AppConfig.memberService
    //call AppConfig.memberRepository
    //call AppConfig.memberRepository
    //call AppConfig.orderService
    //call AppConfig.memberRepository

    //call AppConfig.memberService
    //call AppConfig.memberRepository
    //call AppConfig.orderService

    // MemberServicImp에서 생성자를 통해서 뭐가들어갈지 정한다.(생성자 주입)
    @Bean
    public MemberService memberService() {
        System.out.println("call AppConfig.memberService");
        return new MemberServiceImp(memberRepository());
    }

    // 역할이 한번에 보이게 설정해 주었다
    @Bean
    public MemberRespository memberRepository() {
        System.out.println("call AppConfig.memberRepository");
        return new MemoryMemberRepository();
    }

    // OrderServicImpl에서 생성자를 통해서 뭐가들어갈지 정한다.(생성자 주입)
    @Bean
    public OrderService orderService() {
        System.out.println("call AppConfig.orderService");
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    // 역할이 한번에 보이게 설정해 주었다
    @Bean
    public DiscountPolicy discountPolicy() {
//        return new FixDiscountPolicy();
        return new RateDiscountPolicy();    // 할인 정책을 변경하면 여기만 변경하면 된다.
    }

}

