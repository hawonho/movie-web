package kr.ac.kopo.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import kr.ac.kopo.framework.Controller;
import kr.ac.kopo.framework.MyBatisConfig;
import kr.ac.kopo.member.dao.MemberDAO;
import kr.ac.kopo.member.vo.MemberVO;
import kr.ac.kopo.movie.dao.MovieDAO;
import kr.ac.kopo.movie.vo.MovieVO;
import kr.ac.kopo.schedule.dao.ScheduleDAO;
import kr.ac.kopo.schedule.vo.ScheduleVO;

public class AdminController implements Controller {

	private SqlSession Session;
	private MovieDAO movieDAO;
    private ScheduleDAO scheduleDAO;
    private MemberDAO memberDAO;

    public AdminController() {
        Session = new MyBatisConfig().getInstance();
        movieDAO = new MovieDAO();
//        scheduleDAO = new ScheduleDAO(Session);
//        memberDAO = new MemberDAO(Session);
    }

    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String action = request.getParameter("action");
        if (action != null) {
            if (action.equals("addMovie")) {
				request.setCharacterEncoding("utf-8");
                String movieName = request.getParameter("movieName");
                System.out.println(movieName);
                String openDate = request.getParameter("openDate");
                int runningTime = Integer.parseInt(request.getParameter("runningTime"));

                MovieVO movie = new MovieVO();
                movie.setMovieName(movieName);
                movie.setOpenDate(openDate);
                movie.setRunningTime(runningTime);

                movieDAO.addMovie(movie);
                
                return "index.do";
            } else if (action.equals("deleteMovie")) {
                int movieNo = Integer.parseInt(request.getParameter("movieNo"));
                movieDAO.deleteMovie(movieNo);
                return "index.do";
            } else if (action.equals("addSchedule")) {
                int movieNo = Integer.parseInt(request.getParameter("movieNo"));
                String theaterName = request.getParameter("theaterName");
                String startTime = request.getParameter("startTime");

                ScheduleVO schedule = new ScheduleVO();
                schedule.setMovieNo(movieNo);
                schedule.setTheaterName(theaterName);
                schedule.setStartTime(startTime);

                scheduleDAO.addSchedule(schedule);
                return "redirect:admin.do";
            } else if (action.equals("deleteSchedule")) {
                int scheduleNo = Integer.parseInt(request.getParameter("scheduleNo"));
                scheduleDAO.deleteSchedule(scheduleNo);
                return "redirect:admin.do";
            } else if (action.equals("updateWriteAuth")) {
                String memberId = request.getParameter("memberId");
                String writeAuth = request.getParameter("writeAuth");

//                memberDAO.updateWriteAuth(memberId, 0);
                return "redirect:admin.do";
            }
        }

        List<MovieVO> movies = movieDAO.getAllMovies();
        List<ScheduleVO> schedules = scheduleDAO.getAllSchedules();
        //List<MemberVO> members = memberDAO.getAllMembers();

        request.setAttribute("movies", movies);
        request.setAttribute("schedules", schedules);
        //request.setAttribute("members", members);

        return "/admin.jsp";
    }
}
