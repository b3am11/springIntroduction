package hello.hellospring.controller;

import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class MemberController {

    //@Autowired private MemberService memberService; //필드 주입, 좋은 방식이 아니다.

    private MemberService memberService;

/*    @Autowired
    public void setMemberService(MemberService memberService) {
        this.memberService = memberService; //setter 주입
    }*/

    @Autowired //MemberService를 스프링이 스프링 서비스에 있는
    //MemberService에다가 연결을 시켜준다.(의존관계 주입 중 생성자 주입)
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }
}
