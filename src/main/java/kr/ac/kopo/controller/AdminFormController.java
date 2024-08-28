package kr.ac.kopo.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.ac.kopo.framework.Controller;
import kr.ac.kopo.member.dao.MemberDAO;
import kr.ac.kopo.member.vo.MemberVO;
import kr.ac.kopo.movie.dao.MovieDAO;
import kr.ac.kopo.movie.vo.MovieVO;
import kr.ac.kopo.reservation.dao.TheaterDAO;
import kr.ac.kopo.reservation.vo.TheaterVO;
import kr.ac.kopo.schedule.dao.ScheduleDAO;
import kr.ac.kopo.schedule.vo.ScheduleVO;

public class AdminFormController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {

        HttpSession session = request.getSession();
    	MovieDAO movieDAO = new MovieDAO();
    	List<MovieVO> movieList = movieDAO.getAllMovies();
    	session.setAttribute("movieList", movieList);
    	
    	TheaterDAO theaterDAO = new TheaterDAO();
    	List<TheaterVO> theaterList = theaterDAO.getTheater();
    	session.setAttribute("theaterList", theaterList);
    	
    	ScheduleDAO scheduleDAO = new ScheduleDAO();
    	List<ScheduleVO> scheduleList = scheduleDAO.getAllSchedules();
    	session.setAttribute("scheduleList", scheduleList);
    	
    	MemberDAO memberDAO = new MemberDAO();
    	List<MemberVO> memberList = memberDAO.getAllMembers();
    	session.setAttribute("memberList", memberList);
    	
    	
		return "admin.jsp";
	}

	
}
