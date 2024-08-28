package kr.ac.kopo.schedule.dao;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import kr.ac.kopo.framework.MyBatisConfig;
import kr.ac.kopo.schedule.vo.ScheduleVO;

public class ScheduleDAO {
    private SqlSession Session;

    public ScheduleDAO() {
    	Session = new MyBatisConfig().getInstance();
    }

    public void addSchedule(ScheduleVO schedule) throws ParseException {
        Session.insert("ScheduleMapper.addSchedule", schedule);
        Session.commit();
    }

    public void deleteSchedule(int scheduleNo) {
        Session.delete("ScheduleMapper.deleteSchedule", scheduleNo);
        Session.commit();
    }

    public List<ScheduleVO> getSchedulesByMovie(int movieNo) {
        List<ScheduleVO> scheduleList = Session.selectList("ScheduleMapper.getSchedulesByMovie", movieNo);
        return scheduleList;
    }
    
    public List<ScheduleVO> getAllSchedules() {
        List<ScheduleVO> scheduleList = Session.selectList("ScheduleMapper.getAllSchedules");
        return scheduleList;
    }
    
    public ScheduleVO getSchedule(ScheduleVO schedule) {
    	ScheduleVO scheduleR = Session.selectOne("ScheduleMapper.getSchedule", schedule);
    	return scheduleR;
    }
}
