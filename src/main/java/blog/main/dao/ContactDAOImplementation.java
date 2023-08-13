package blog.main.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import blog.main.entity.Contact;

@Repository
public class ContactDAOImplementation implements ContactDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public Contact getContactInfo() {
		Session session = sessionFactory.getCurrentSession();
		Contact contact = session.get(Contact.class, 1);
		return contact;
	}

	@Override
	public void updateContact(Contact contact) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(contact);
	}

	
}
