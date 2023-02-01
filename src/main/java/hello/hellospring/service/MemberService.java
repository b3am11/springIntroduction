package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional //항상 사용해 줘야 한다.
public class MemberService { //컨트롤 + 시프르 + t 누르면 테스트 생성 가능
    private final MemberRepository memberRepository;
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    /**
    * 회원 가입
    */
    public Long join(Member member) {

            validateDuplicateMember(member); //중복 회원 검증
            memberRepository.save(member);
            return member.getId();

    }

    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName())
                .ifPresent(m -> { //Optional 덕에 ifPresent 쓸 수 있다.
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
    }

    /**
    * 전체 회원 조회
    */
    public List<Member> findMembers() {
            return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
