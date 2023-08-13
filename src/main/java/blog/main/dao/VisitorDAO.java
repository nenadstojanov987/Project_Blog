package blog.main.dao;

import java.util.List;

import org.springframework.stereotype.Component;

 
import blog.main.entity.Visitor;

@Component
public interface VisitorDAO {

	public List<Visitor> getVisitorList();
	public List<Visitor> getEnabledVisitorList();
	public List<Visitor> getBannedVisitorList();
	public boolean addNewVisitor(Visitor visitor);
	public Visitor getVisitorById(int id_visitor);
 	public void banVisitor(int id_visitor);
 	public void enableVisitor(int id_visitor);
	public void deleteVisitor(int id_visitor);
}
