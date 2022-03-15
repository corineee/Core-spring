package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
//@Qualifier("fixDiscountPolicy")애노테이션을 넣고 orderServiceImpl에서 생성자 부분에 Qualifier("이름")을 넣어주면 된다.
public class FixDiscountPolicy implements  DiscountPolicy{

    private int discountFixAmount = 1000; // 1000원 할인

    @Override
    public int discount(Member member, int price) {
        if(member.getGrade() == Grade.VIP){ // enum타입은 == 사용
            return discountFixAmount;
        }else{
            return 0;
        }
    }
}
