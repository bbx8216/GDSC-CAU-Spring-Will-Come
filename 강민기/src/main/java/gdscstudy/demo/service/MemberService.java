package gdscstudy.demo.service;

import gdscstudy.demo.domain.Member;
import gdscstudy.demo.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MemberService {
    @Autowired
    private MemberRepository memberRepository;

    /*
     * 회원 가입
     * */
    public Long join(Member member){
        // 같은 이름이 있는 중복 회원은 안됨.
        validateDuplicateMember(member); // 중복 회원 검증
        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName()).ifPresent(m ->{
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        });
        // result가 optional로 감싸져서, 어떤 값이 있으면 이게 동작하는 것임. 만약 아녔으면 ifNull이라고 했겠지만 (이건 과거임) 옵셔널로 감쌌기 때문에 이렇게!
        // m 에 값이 있으면 throw
    }

    /**
     * 전체 회원 조회
     * */
    public List<Member> findMembers(){
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memerId){
        return memberRepository.findById(memerId);
    }

}
