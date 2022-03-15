package hello.core.order;

import hello.core.annotation.MainDiscountPolicy;
import hello.core.discount.DiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRespository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
//@RequiredArgsConstructor //final이 붙은 필수 값을 받은 생성자를 만들어준다.
public class OrderServiceImpl implements OrderService{

    private final MemberRespository memberRespository; //필드 주입은 @Autowired private처럼 앞에 바로 생성하는 것이다.
    private final DiscountPolicy discountPolicy;  // interface만 의존하도록 변경
    // 필드주입은 외부에서 변경이 불가능해서 테스트 하기 힘들다는 치명적인 단점이 있다.
    // 필드주입은 스프링 설정을 목적으로 하는 @Configuration 같은 곳에서만 특별한 용도로 사용
//
//    @Autowired
//    public void setDiscountPolicy(DiscountPolicy discountPolicy) {
//        this.discountPolicy = discountPolicy;
//    }
//
//    @Autowired
//    public void setMemberRespository(MemberRespository memberRespository) {
//        this.memberRespository = memberRespository;
//    }

//    @Autowired //생성자가 1개일 경우에는 Authowired 생략가능
    public OrderServiceImpl(MemberRespository memberRespository, @MainDiscountPolicy DiscountPolicy discountPolicy) {
        this.memberRespository = memberRespository;           //직접만든 Qualifier를 수정자에 자동 주입해주었다.
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRespository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);
        // 단일 책임 원칙이 잘 적용되었다.
        // 할인정책을 변경하려는 경우 discount부분만 변경하면 되기 때문
        return new Order(memberId, itemName, itemPrice, discountPrice);
    }

    //테스트 용도
    public MemberRespository getMemberRespository() {
        return memberRespository;
    }
}

