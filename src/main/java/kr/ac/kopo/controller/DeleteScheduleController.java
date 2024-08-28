package kr.ac.kopo.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.ac.kopo.framework.Controller;
import kr.ac.kopo.schedule.dao.ScheduleDAO;

public class DeleteScheduleController implements Controller {

	private ScheduleDAO scheduleDAO = new ScheduleDAO();
	
	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int scheduleNo = Integer.parseInt(request.getParameter("scheduleNo"));
		scheduleDAO.deleteSchedule(scheduleNo);
        return "adminForm.do";
	}

	
}
