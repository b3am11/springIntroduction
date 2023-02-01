package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

//인터페이스가 인터페이스를 상속받을 때는 implements가 아니라 extends로 받을것
//인터페이스는 다중 상속이 가능하다
public interface SpringDataJpaMemberRepository extends JpaRepository<Member, Long>, MemberRepository {

    //JPOL select m from Member m where m.name = ?
    @Override
    Optional<Member> findByName(String name);
}
