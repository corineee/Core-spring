package hello.core.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component //자동으로 스프링 빈에 등록이 된다.
public class MemberServiceImp implements MemberService{

    private final MemberRespository memberRespository;

    @Autowired //자동으로 스프링 빈에 등록이 되기때문에 의존관계주입을 자동으로 해주는 코드이다.
    public MemberServiceImp(MemberRespository memberRespository) {
        this.memberRespository = memberRespository;
    }

    @Override
    public void join(Member member) {
        memberRespository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRespository.findById(memberId);
    }

    //테스트 용도
    public MemberRespository getMemberRespository() {
        return memberRespository;
    }
}
