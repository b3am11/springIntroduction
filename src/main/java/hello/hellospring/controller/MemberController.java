package hello.hellospring.controller;

import hello.hellospring.domain.Member;
import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

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
        System.out.println("memberService = " + memberService.getClass());
    }

    @GetMapping("/members/new") //조회할 때 주로 쓴다.
    public String createForm() {
        return "members/createMemberForm";
    }

    @PostMapping("/members/new") //데이터를 폼 같은 곳에 넣어서 전달할 떄 사용 (등록)
    public String create(MemberForm form) {
        Member member = new Member();
        member.setName(form.getName());

        System.out.println("member = " + member.getName());
        memberService.join(member);

        return "redirect:/";
    }

    @GetMapping("/members")
    public String list(Model model) {
       List<Member> members =  memberService.findMembers();
       model.addAttribute("members", members);
       return "members/memberList";
    }


}
