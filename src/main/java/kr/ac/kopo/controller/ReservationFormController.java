package kr.ac.kopo.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.ac.kopo.framework.Controller;
import kr.ac.kopo.member.vo.MemberVO;
import kr.ac.kopo.reservation.dao.ReservationDAO;
import kr.ac.kopo.reservation.vo.ReservationVO;

public class ReservationFormController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		HttpSession session = request.getSession();
		ReservationDAO reservationDAO = new ReservationDAO();
		MemberVO member = (MemberVO)session.getAttribute("member");
		String memberId = member.getMemberId();
		List<ReservationVO> reservationList = reservationDAO.getReservationsByMemberId(memberId);
		session.setAttribute("reservationList", reservationList);
		
		return "reservations.jsp";
	}

	
}
