package kr.ac.kopo.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.ac.kopo.framework.Controller;
import kr.ac.kopo.movie.dao.MovieDAO;
import kr.ac.kopo.movie.vo.MovieVO;

public class AddMovieController implements Controller {

	private MovieDAO movieDAO = new MovieDAO();
	
	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
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
    	
        return "adminForm.do";
	}

}
