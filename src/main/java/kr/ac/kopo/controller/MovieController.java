package kr.ac.kopo.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;

import kr.ac.kopo.framework.Controller;
import kr.ac.kopo.framework.MyBatisConfig;
import kr.ac.kopo.movie.dao.MovieDAO;
import kr.ac.kopo.movie.vo.MovieVO;

public class MovieController implements Controller {

    public MovieController() {
    	
    }

    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String action = request.getParameter("action");

        if (action == null) {
        	HttpSession session = request.getSession();
        	MovieDAO movieDAO = new MovieDAO();
        	List<MovieVO> movieList = movieDAO.getAllMovies();
        	session.setAttribute("movieList", movieList);
            return "movieList.jsp";
        }

        switch (action) {
            case "addMovie":
                return addMovie(request, response);
            case "deleteMovie":
                return deleteMovie(request, response);
            case "scheduleMovie":
                return scheduleMovie(request, response);
            case "manageSchedule":
                return manageSchedule(request, response);
            default:
                return "error.jsp";
        }
    }

    private String addMovie(HttpServletRequest request, HttpServletResponse response) {
        // 영화 등록 로직
        return "addMovieSuccess.jsp";
    }

    private String deleteMovie(HttpServletRequest request, HttpServletResponse response) {
        // 영화 삭제 로직
        return "deleteMovieSuccess.jsp";
    }

    private String scheduleMovie(HttpServletRequest request, HttpServletResponse response) {
        // 상영시간 배정 로직
        return "scheduleMovieSuccess.jsp";
    }

    private String manageSchedule(HttpServletRequest request, HttpServletResponse response) {
        // 상영 시간표 관리 로직
        return "manageScheduleSuccess.jsp";
    }
}
