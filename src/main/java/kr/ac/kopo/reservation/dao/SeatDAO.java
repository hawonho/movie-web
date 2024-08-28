package kr.ac.kopo.reservation.dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import kr.ac.kopo.framework.MyBatisConfig;
import kr.ac.kopo.reservation.vo.SeatVO;
import kr.ac.kopo.schedule.vo.ScheduleVO;

import java.util.List;

public class SeatDAO {

    private SqlSession Session;

    public SeatDAO() {
    	Session = new MyBatisConfig().getInstance();
    }

    public List<SeatVO> getAvailableSeats() {
    	List<SeatVO> seatList = Session.selectList("SeatMapper.getAvailableSeats");
    	return seatList;
    }
    
    public void update(int seatNo) {
    	Session.update("SeatMapper.update", seatNo);
    	Session.commit();
    }
    
    public void createSeat(ScheduleVO schedule) {
    	Session.insert("SeatMapper.createSeat", schedule);
    	Session.commit();
    }
}
