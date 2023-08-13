package blog.main.dao;

import java.time.LocalDateTime;
import java.util.List;
import java.util.ArrayList;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import blog.main.entity.VisitLog;
import blog.main.entity.VisitStat;

@Repository
public class VisitLogDAOImplementation implements VisitLogDAO{

	@Autowired
	private SessionFactory sessionFactory;
	
	
	@Override
	public void addVisitLog(VisitLog visitLog) {
		Session session = sessionFactory.getCurrentSession();
		if(visitLog!=null) {
			session.save(visitLog);
		}
	}

	@Override
	public List<VisitLog> getVisitLogList() {
		Session session = sessionFactory.getCurrentSession();
		List<VisitLog> visitLog = session.createQuery("FROM VisitLog vl").list();
		return visitLog;
	}


	@Override
	public VisitLog getVisitLogByBlogId(int blog_product_id) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("FROM VisitLog vl where vl.blog_product_id = :blog_product_id");
		query.setParameter("blog_product_id", blog_product_id);
		VisitLog vl = (VisitLog) query.getSingleResult();
		return vl;
	}

	@Override
	public void deleteVisitLog(VisitLog visitLog) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(visitLog);
		
	}

	@Override
	public List<VisitLog> getVisitLogListByDate(LocalDateTime localDateTime) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createSQLQuery("SELECT COUNT(id_visit_log) FROM visit_log where date(visit_log_date) = :log_date ");
		String ld = "'"+localDateTime.toLocalDate().toString()+"'";
		query.setParameter("log_date", ld);
		List<Object[]> objectArr = query.getResultList();
		
		List<VisitLog> visitLogList = new ArrayList<VisitLog>();
		
		
		for(Object[] row:objectArr) 
		{
			VisitLog vl = new VisitLog();
			vl.setId_visit(Integer.parseInt(row[0].toString()));
			vl.setBlog_product_id(Integer.parseInt(row[1].toString()));
			vl.setVisit_date((LocalDateTime.parse(row[2].toString())));
			visitLogList.add(vl);
		}
		
		return visitLogList;
	}

	@Override
	public List<VisitStat> VisitLogStatByDate() {
		Session session = sessionFactory.getCurrentSession();
		List<VisitStat> visitStatList = new ArrayList();
		Query query = session.createSQLQuery("select distinct date(visit_log_date), count(id_visit_log) "
				+ "from visit_log group by date(visit_log_date) order by date(visit_log_date) asc limit 7");
		
		List<Object[]> objectArr = query.getResultList();
		for(Object[] row:objectArr) 
		{
			VisitStat vsl = new VisitStat();
			 
			vsl.setVisitDate((Date)(row[0]));
			vsl.setVisitNumber(Integer.parseInt(row[1].toString()));
		 
			visitStatList.add(vsl);
		}
		
		return visitStatList;
	}

	 

}
