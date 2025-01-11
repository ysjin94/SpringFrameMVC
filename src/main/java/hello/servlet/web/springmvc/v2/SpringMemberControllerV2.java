package hello.servlet.web.springmvc.v2;

import hello.servlet.domain.member.Member;
import hello.servlet.domain.member.MemberRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/springmvc/v2/members")
public class SpringMemberControllerV2 {

    private MemberRepository memberRepository = MemberRepository.getInstance();

    @RequestMapping("/new-form")
    public ModelAndView newForm(HttpServletRequest request, HttpServletResponse response) {
        return new ModelAndView("new-form");
    }

    @RequestMapping("/save")
    public ModelAndView save(HttpServletRequest request, HttpServletResponse response) {
        String username = request.getParameter("username").toString();
        int age         = Integer.parseInt(request.getParameter("age").toString());

        Member member = new Member(username, age);
        memberRepository.save(member);

        ModelAndView modelView = new ModelAndView("save-result");
        modelView.addObject("member", member);
        System.out.println(modelView.getModel());
        return modelView;
    }

    @RequestMapping
    public ModelAndView members(Map<String, String> paramMap) {
        List<Member> members = memberRepository.findAll();
        ModelAndView modelView = new ModelAndView("members");
        modelView.addObject("members", members);
        return modelView;
    }

}
