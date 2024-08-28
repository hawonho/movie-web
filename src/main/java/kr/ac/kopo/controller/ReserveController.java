package kr.ac.kopo.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.ac.kopo.framework.Controller;
import kr.ac.kopo.member.vo.MemberVO;
import kr.ac.kopo.reservation.dao.ReservationDAO;
import kr.ac.kopo.reservation.dao.SeatDAO;
import kr.ac.kopo.reservation.vo.ReservationVO;
import kr.ac.kopo.reservation.vo.SeatVO;

public class ReserveController implements Controller {

	public ReservationDAO reservationDAO = new ReservationDAO();
	public SeatDAO seatDAO = new SeatDAO();

	
	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		HttpSession session = request.getSession();
		
		MemberVO member = (MemberVO)session.getAttribute("member");
		String memberId = member.getMemberId();
		int movieNo = Integer.parseInt(request.getParameter("movieNo"));
		int scheduleNo = Integer.parseInt(request.getParameter("scheduleNo"));
		int seatNo = Integer.parseInt(request.getParameter("seatNo"));
		
		ReservationVO reservation = new ReservationVO();
		reservation.setMemberId(memberId);
		reservation.setMovieNo(movieNo);
		reservation.setScheduleNo(scheduleNo);
		reservation.setSeatNo(seatNo);
		reservationDAO.reserveMovie(reservation);
		
		SeatVO seat = new SeatVO();
		seat.setSeatNo(seatNo);
		seatDAO.update(seatNo);
		
		return "index.do";
	}

	
}
