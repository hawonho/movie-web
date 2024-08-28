package kr.ac.kopo.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.ac.kopo.framework.Controller;
import kr.ac.kopo.movie.dao.MovieDAO;

public class DeleteMovieController implements Controller {

	private MovieDAO movieDAO = new MovieDAO();
	
	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int movieNo = Integer.parseInt(request.getParameter("movieNo"));
        movieDAO.deleteMovie(movieNo);
        return "adminForm.do";
	}

}
