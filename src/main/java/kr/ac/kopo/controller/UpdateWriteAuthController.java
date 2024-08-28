package kr.ac.kopo.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.ac.kopo.framework.Controller;
import kr.ac.kopo.member.dao.MemberDAO;
import kr.ac.kopo.member.vo.MemberVO;

public class UpdateWriteAuthController implements Controller {

	private MemberDAO memberDAO = new MemberDAO();
	
	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String memberId = request.getParameter("memberId");
        String writeAuth = request.getParameter("writeAuth");

        memberDAO.updateWriteAuth(memberId, writeAuth);
		return "adminForm.do";
	}

	
}
