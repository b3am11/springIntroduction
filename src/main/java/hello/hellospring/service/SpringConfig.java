package hello.hellospring.service;

import hello.hellospring.aop.TimeTraceAop;
import hello.hellospring.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    private final MemberRepository memberRepository;

    //생성자가 하나인 경우에는 생략 가능
    @Autowired
    public SpringConfig(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository);
    }

/*    @Bean
    public TimeTraceAop timeTraceAop() {
        return new TimeTraceAop();
    }*/

    //@Bean
    //public MemberRepository memberRepository() {
    //    return new MemoryMemberRepository();
    //    return new JdbcMemberRepository(dataSource);
    //    return new JdbcTemplateMemberRepository(dataSource);
    //    return new JpaMemberRepository(em);
    //}
}
