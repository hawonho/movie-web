package kr.ac.kopo.reservation.dao;

import java.util.List;
import org.apache.ibatis.session.SqlSession;

import kr.ac.kopo.framework.MyBatisConfig;
import kr.ac.kopo.reservation.vo.ReservationVO;

public class ReservationDAO {
    private SqlSession Session;

    public ReservationDAO() {
    	Session = new MyBatisConfig().getInstance();
    }

    public void reserveMovie(ReservationVO reservation) {
        Session.insert("ReservationMapper.reserveMovie", reservation);
        Session.commit();
    }

    public void cancelReservation(int reserveNo) {
        Session.delete("ReservationMapper.cancelReservation", reserveNo);
    }

    public List<ReservationVO> getReservationsByMemberId(String memberId) {
        List<ReservationVO> reservationList = Session.selectList("ReservationMapper.getReservationsByMemberId", memberId);
        return reservationList;
    }
}
