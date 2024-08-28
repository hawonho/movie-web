package kr.ac.kopo.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import kr.ac.kopo.framework.Controller;
import kr.ac.kopo.framework.MyBatisConfig;
import kr.ac.kopo.member.dao.MemberDAO;
import kr.ac.kopo.member.vo.MemberVO;

public class LoginController implements Controller {

	private MemberDAO memberDAO = new MemberDAO();
	
	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 로그인 처리
        String memberId = request.getParameter("memberId");
        String password = request.getParameter("password");

        MemberVO member = memberDAO.login(memberId, password);
        if (member != null) {
            request.getSession().setAttribute("member", member);
            return "index.jsp";
        } else {
            request.setAttribute("errorMessage", "Invalid username or password");
            return "login.jsp";
        }
	}

	
}
