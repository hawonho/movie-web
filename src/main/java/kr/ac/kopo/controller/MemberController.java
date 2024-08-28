package kr.ac.kopo.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import kr.ac.kopo.framework.Controller;
import kr.ac.kopo.framework.MyBatisConfig;
import kr.ac.kopo.member.dao.MemberDAO;
import kr.ac.kopo.member.vo.MemberVO;

import java.util.List;

public class MemberController implements Controller {

    private MemberDAO memberDAO;

    public MemberController() {
        SqlSession Session = new MyBatisConfig().getInstance();
//        memberDAO = new MemberDAO(Session);
    }

    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String action = request.getParameter("action");

        if (action != null) {
            if (action.equals("register")) {
                // 회원 가입 처리
                String memberId = request.getParameter("memberId");
                String memberName = request.getParameter("memberName");
                String password = request.getParameter("password");
                String phone = request.getParameter("phone");
                String email = request.getParameter("email");

                MemberVO member = new MemberVO();
                member.setMemberId(memberId);
                member.setMemberName(memberName);
                member.setPassword(password);
                member.setPhone(phone);
                member.setEmail(email);

                //memberDAO.registerMember(member);
                return "login.jsp";
            } else if (action.equals("login")) {
                // 로그인 처리
                String memberId = request.getParameter("memberId");
                String password = request.getParameter("password");

                //MemberVO member = memberDAO.loginMember(memberId, password);
               // System.out.println(member);
               // if (member != null) {
                   // request.getSession().setAttribute("member", member);
                   // return "index.jsp";
              //  } else {
                  //  request.setAttribute("errorMessage", "Invalid username or password");
                 //   return "login.jsp";
               // }
            } else if (action.equals("logout")) {
                // 로그아웃 처리
                request.getSession().invalidate();
                return "index.jsp";
            } else if(action.equals("gologin")) {
            	return "login.jsp";
            }
        }else {
        	return "login.jsp";
        }
        return "register.jsp";
        
    }
}
