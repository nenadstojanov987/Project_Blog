package blog.main.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import blog.main.entity.Slider;
import blog.main.entity.Visitor;

@Repository
public class VisitorDAOImplementation implements VisitorDAO{

	@Autowired
	private SessionFactory sessionFactory;
	
	
	@Override
	public List<Visitor> getVisitorList() {
		Session session = sessionFactory.getCurrentSession();
		List<Visitor> visitorList=session.createQuery("from Visitor v").list();
		return visitorList;
	}

	@Override
	public List<Visitor> getEnabledVisitorList() {
		Session session = sessionFactory.getCurrentSession();
		List<Visitor> visitorList=session.createQuery("from Visitor v where v.banned=0").list();
		return visitorList;
	}

	@Override
	public List<Visitor> getBannedVisitorList() {
		Session session = sessionFactory.getCurrentSession();
		List<Visitor> visitorList=session.createQuery("from Visitor v where v.banned=1").list();
		return visitorList;
	}

	@Override
	public boolean addNewVisitor(Visitor visitor) {
		Session session = sessionFactory.getCurrentSession();
		List<Visitor> visitorList=session.createQuery("from Visitor v").list();
		
		for(Visitor v:visitorList)
		{
			if(visitor.getEmail().equals(v.getEmail())) 
			{
				return false;
			}
			
		}
		session.saveOrUpdate(visitor);
		return true;
		
	}

	@Override
	public Visitor getVisitorById(int id_visitor) {
		Session session = sessionFactory.getCurrentSession();
		Visitor visitor = session.get(Visitor.class, id_visitor);
		return visitor;
	}

	@Override
	public void banVisitor(int id_visitor) {
		Session session = sessionFactory.getCurrentSession();
		Visitor visitor  = session.get(Visitor.class, id_visitor);
		visitor.setBanned(true);
		session.saveOrUpdate(visitor);
		
	}

	@Override
	public void enableVisitor(int id_visitor) {
		Session session = sessionFactory.getCurrentSession();
		Visitor visitor  = session.get(Visitor.class, id_visitor);
		visitor.setBanned(false);
		session.saveOrUpdate(visitor);
		
	}

	@Override
	public void deleteVisitor(int id_visitor) {
		Session session = sessionFactory.getCurrentSession();
		Visitor visitor  = session.get(Visitor.class, id_visitor);
		session.delete(visitor);
		
	}

}
