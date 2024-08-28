package kr.ac.kopo.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import kr.ac.kopo.framework.Controller;
import kr.ac.kopo.framework.MyBatisConfig;
import kr.ac.kopo.movie.dao.MovieDAO;
import kr.ac.kopo.movie.vo.MovieVO;
import kr.ac.kopo.reservation.dao.ReservationDAO;
import kr.ac.kopo.reservation.dao.SeatDAO;
import kr.ac.kopo.reservation.vo.ReservationVO;
import kr.ac.kopo.reservation.vo.SeatVO;
import kr.ac.kopo.schedule.dao.ScheduleDAO;
import kr.ac.kopo.schedule.vo.ScheduleVO;

public class ReservationController implements Controller {

	private SqlSession Session;
	private MovieDAO movieDAO;
    private ScheduleDAO scheduleDAO;
    private SeatDAO seatDAO;
    private ReservationDAO reservationDAO;

	public ReservationController() {
		Session = new MyBatisConfig().getInstance();
		movieDAO = new MovieDAO();
//		scheduleDAO = new ScheduleDAO(Session);
	//	seatDAO = new SeatDAO(Session);
		//reservationDAO = new ReservationDAO(Session);
	}

    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String action = request.getParameter("action");
        
        if (action != null) {
            if (action.equals("reserve")) {
                String memberId = request.getParameter("memberId");
                int movieNo = Integer.parseInt(request.getParameter("movieNo"));
                int scheduleNo = Integer.parseInt(request.getParameter("scheduleNo"));
                int seatNo = Integer.parseInt(request.getParameter("seatNo"));
                
                ReservationVO reservation = new ReservationVO();
                reservation.setMemberId(memberId);
                reservation.setMovieNo(movieNo);
                reservation.setScheduleNo(scheduleNo);
                reservation.setSeatNo(seatNo);
                
                reservationDAO.reserveMovie(reservation);
                
                return "/reservationSuccess.jsp";
            } else if (action.equals("cancel")) {
                int reserveNo = Integer.parseInt(request.getParameter("reserveNo"));
                reservationDAO.cancelReservation(reserveNo);
                
                return "redirect:reserve.do?action=viewReservations";
            } else if (action.equals("viewReservations")) {
                String memberId = (String) request.getSession().getAttribute("memberId");
                List<ReservationVO> reservations = reservationDAO.getReservationsByMemberId(memberId);
                request.setAttribute("reservations", reservations);
                return "/reservations.jsp";
            }
        } else {
            List<MovieVO> movies = movieDAO.getAllMovies();
            List<ScheduleVO> schedules = scheduleDAO.getAllSchedules();
            List<SeatVO> seats = seatDAO.getAvailableSeats();
            request.setAttribute("movies", movies);
            request.setAttribute("schedules", schedules);
            request.setAttribute("seats", seats);
            return "/reserve.jsp";
        }
        return "/index.jsp";
    }
}
