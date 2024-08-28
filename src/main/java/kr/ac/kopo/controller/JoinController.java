package kr.ac.kopo.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import kr.ac.kopo.framework.Controller;
import kr.ac.kopo.framework.MyBatisConfig;
import kr.ac.kopo.member.dao.MemberDAO;
import kr.ac.kopo.member.vo.MemberVO;

public class JoinController implements Controller {

	private MemberDAO memberDAO = new MemberDAO();

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {

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

		memberDAO.join(member);
		return "loginForm.do";
	}

}
