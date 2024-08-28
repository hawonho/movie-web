package kr.ac.kopo.schedule.vo;

public class ScheduleVO {
    
	private int scheduleNo;
    private int movieNo;
    private String theaterName;
    private String startTime;
    private String movieName;
    private String seatName;
    
	public int getScheduleNo() {
		return scheduleNo;
	}
	public void setScheduleNo(int scheduleNo) {
		this.scheduleNo = scheduleNo;
	}
	public int getMovieNo() {
		return movieNo;
	}
	public void setMovieNo(int movieNo) {
		this.movieNo = movieNo;
	}
	public String getTheaterName() {
		return theaterName;
	}
	public void setTheaterName(String theaterName) {
		this.theaterName = theaterName;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getMovieName() {
		return movieName;
	}
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	public String getSeatName() {
		return seatName;
	}
	public void setSeatName(String seatName) {
		this.seatName = seatName;
	}
	@Override
	public String toString() {
		return "ScheduleVO [scheduleNo=" + scheduleNo + ", movieNo=" + movieNo + ", theaterName=" + theaterName
				+ ", startTime=" + startTime + ", movieName=" + movieName + ", seatName=" + seatName + "]";
	}
    
	
}
