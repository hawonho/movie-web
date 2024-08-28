package kr.ac.kopo.movie.dao;

import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import kr.ac.kopo.framework.MyBatisConfig;
import kr.ac.kopo.movie.vo.MovieVO;

public class MovieDAO {
    private SqlSession Session;

    public MovieDAO() {
    	Session = new MyBatisConfig().getInstance();
    }

    public void addMovie(MovieVO movie) {
        Session.insert("MovieMapper.addMovie", movie);
        Session.commit();
    }

    public void deleteMovie(int movieNo) {
        Session.delete("MovieMapper.deleteMovie", movieNo);
        Session.commit();
    }

    public List<MovieVO> getAllMovies() {
        List<MovieVO> movieList = Session.selectList("MovieMapper.getAllMovies");
        return movieList;
    }
}
