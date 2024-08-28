package kr.ac.kopo.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.ac.kopo.framework.Controller;
import kr.ac.kopo.movie.dao.MovieDAO;
import kr.ac.kopo.movie.vo.MovieVO;
import kr.ac.kopo.reservation.dao.SeatDAO;
import kr.ac.kopo.reservation.vo.SeatVO;
import kr.ac.kopo.schedule.dao.ScheduleDAO;
import kr.ac.kopo.schedule.vo.ScheduleVO;

public class ReserveFormController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		HttpSession session = request.getSession();
//    	MovieDAO movieDAO = new MovieDAO();
//    	List<MovieVO> movieList = movieDAO.getAllMovies();
//    	session.setAttribute("movieList", movieList);
    	
    	ScheduleDAO scheduleDAO = new ScheduleDAO();
    	List<ScheduleVO> scheduleList = scheduleDAO.getAllSchedules();
    	session.setAttribute("scheduleList", scheduleList);
    	
    	SeatDAO seatDAO = new SeatDAO();
    	List<SeatVO> seatList = seatDAO.getAvailableSeats();
    	session.setAttribute("seatList", seatList);
    	
		return "reserve.jsp";
	}
	
}
