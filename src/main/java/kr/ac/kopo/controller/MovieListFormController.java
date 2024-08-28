package kr.ac.kopo.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.ac.kopo.framework.Controller;
import kr.ac.kopo.movie.dao.MovieDAO;
import kr.ac.kopo.movie.vo.MovieVO;

public class MovieListFormController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
    	MovieDAO movieDAO = new MovieDAO();
    	List<MovieVO> movieList = movieDAO.getAllMovies();
    	System.out.println("무비리스트 : " + movieList);
    	session.setAttribute("movieList", movieList);
        return "movieList.jsp";
	}

	
}
