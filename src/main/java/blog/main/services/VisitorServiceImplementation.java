package blog.main.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import blog.main.dao.VisitorDAO;
import blog.main.entity.Visitor;

@Component
public class VisitorServiceImplementation implements VisitorService{

	@Autowired
	private VisitorDAO visitorDAO;
	
	@Transactional
	@Override
	public List<Visitor> getVisitorList() {
		List<Visitor> visitorList = visitorDAO.getVisitorList();
		return visitorList;
	}

	@Transactional
	@Override
	public List<Visitor> getEnabledVisitorList() {
		List<Visitor> visitorList = visitorDAO.getEnabledVisitorList();
		return visitorList;
	}

	@Transactional
	@Override
	public List<Visitor> getBannedVisitorList() {
		List<Visitor> visitorList = visitorDAO.getBannedVisitorList();
		return visitorList;
	}

	@Override
	public boolean addNewVisitor(Visitor visitor) {
		 boolean add = visitorDAO.addNewVisitor(visitor);
		 return add;
		
	}

	@Transactional
	@Override
	public Visitor getVisitorById(int id_visitor) {
		Visitor visitor = visitorDAO.getVisitorById(id_visitor);
		return visitor;
	}

	@Transactional
	@Override
	public void banVisitor(int id_visitor) {
		visitorDAO.banVisitor(id_visitor);
		
	}

	@Transactional
	@Override
	public void enableVisitor(int id_visitor) {
		visitorDAO.enableVisitor(id_visitor);
		
	}

	@Transactional
	@Override
	public void deleteVisitor(int id_visitor) {
		visitorDAO.deleteVisitor(id_visitor);
		
	}

}
