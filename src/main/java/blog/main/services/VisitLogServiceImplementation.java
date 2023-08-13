package blog.main.services;

import java.time.LocalDateTime;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import blog.main.dao.VisitLogDAO;
import blog.main.entity.VisitLog;
import blog.main.entity.VisitStat;

@Component
public class VisitLogServiceImplementation implements VisitLogService {

	@Autowired
	private VisitLogDAO visitLogDAO;
	
	@Transactional
	@Override
	public void addVisitLog(VisitLog visitLog) {
		 visitLogDAO.addVisitLog(visitLog);
	}

	@Transactional
	@Override
	public List<VisitLog> getVisitLogList() {
		List<VisitLog> visitLogList = visitLogDAO.getVisitLogList();
		return visitLogList;
	}
	

	@Transactional
	@Override
	public VisitLog getVisitLogByBlogId(int blog_product_id) {
		VisitLog visitLog = visitLogDAO.getVisitLogByBlogId(blog_product_id);
		return visitLog;
	}

	@Transactional
	@Override
	public void deleteVisitLog(VisitLog visitLog) {
		visitLogDAO.deleteVisitLog(visitLog);
		
	}

	@Transactional
	@Override
	public List<VisitLog> getVisitLogListByDate(LocalDateTime localDateTime) {
		List<VisitLog> visitLogList = visitLogDAO.getVisitLogListByDate(localDateTime);
		return visitLogList;
	}

	@Transactional
	@Override
	public List<VisitStat> VisitLogStatByDate() {
		List<VisitStat> visitStatList = visitLogDAO.VisitLogStatByDate();
		return visitStatList;
	}

}
