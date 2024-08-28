package kr.ac.kopo.reservation.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.ac.kopo.framework.MyBatisConfig;
import kr.ac.kopo.reservation.vo.TheaterVO;

public class TheaterDAO {

	private SqlSession Session;

    public TheaterDAO() {
    	Session = new MyBatisConfig().getInstance();
    }
    
    public List<TheaterVO> getTheater() {
    	List<TheaterVO> theaterList = Session.selectList("TheaterMapper.getTheater");
    	return theaterList;
    }
}
