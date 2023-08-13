package blog.main.services;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import blog.main.entity.VisitLog;
import blog.main.entity.VisitStat;

@Service
public interface VisitLogService {

	public void addVisitLog(VisitLog visitLog);
	public List<VisitLog> getVisitLogList();
	public List<VisitLog> getVisitLogListByDate(LocalDateTime localDateTime);
	public VisitLog getVisitLogByBlogId(int blog_product_id);
	public void deleteVisitLog(VisitLog visitLog);
	public List<VisitStat> VisitLogStatByDate();
}
