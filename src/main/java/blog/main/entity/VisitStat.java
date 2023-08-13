package blog.main.entity;

import java.time.LocalDateTime;
import java.util.Date;

public class VisitStat {

	private Date visitDate;
	private int visitNumber;
	
	
	public VisitStat() {}
	
	
	public VisitStat(Date visitDate, int visitNumber) {
		super();
		this.visitDate = visitDate;
		this.visitNumber = visitNumber;
	}
	
	
	public Date getVisitDate() {
		return visitDate;
	}
	public void setVisitDate(Date visitDate) {
		this.visitDate = visitDate;
	}
	public int getVisitNumber() {
		return visitNumber;
	}
	public void setVisitNumber(int visitNumber) {
		this.visitNumber = visitNumber;
	}


	@Override
	public String toString() {
		return "VisitStat [visitDate=" + visitDate + ", visitNumber=" + visitNumber + "]";
	}
	
}
