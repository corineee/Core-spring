package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.member.MemberRespository;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan( //스프링빈으로 등록하는 것중 뺄 것을 지정
//        basePackages = "hello.core.member", // member하위 패키지부터 탐색하여 memeber만 ComponenetScan의 대상이된다.
//        basePackageClasses = AutoAppConfig.class,
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
)
public class AutoAppConfig {
    /*
    컴포넌트 스캔을 수동으로 등록
    @Bean(name = "memoryMemberRepository")
    MemberRespository memberRespository() {
        return new MemoryMemberRepository();
    }
    */
}
