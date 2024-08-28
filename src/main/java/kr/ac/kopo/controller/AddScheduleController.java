package kr.ac.kopo.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.ac.kopo.framework.Controller;
import kr.ac.kopo.reservation.dao.SeatDAO;
import kr.ac.kopo.schedule.dao.ScheduleDAO;
import kr.ac.kopo.schedule.vo.ScheduleVO;

public class AddScheduleController implements Controller {

	private ScheduleDAO scheduleDAO = new ScheduleDAO();
	private SeatDAO seatDAO = new SeatDAO();
	
	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		int movieNo = Integer.parseInt(request.getParameter("movieNo"));
		String theaterName = request.getParameter("theaterName");
		String startTime = request.getParameter("startTime");
		
		ScheduleVO schedule = new ScheduleVO();
		schedule.setMovieNo(movieNo);
		schedule.setTheaterName(theaterName);
		schedule.setStartTime(startTime);
		
    	String time = schedule.getStartTime();
    	startTime = time.replaceAll("T", " ");
    	schedule.setStartTime(startTime);
		
		scheduleDAO.addSchedule(schedule);
		ScheduleVO scheduleR = new ScheduleVO();
		scheduleR = scheduleDAO.getSchedule(schedule);
		
		char[] rows = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H'};
		for(char row : rows) {
			for(int i = 1; i <= 10; i++) {
				String seatName = String.format("%c%02d", row, i);
				scheduleR.setSeatName(seatName);
				seatDAO.createSeat(scheduleR);
			}
		}
		
		
		return "adminForm.do";
	}

}
