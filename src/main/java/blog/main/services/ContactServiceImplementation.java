package blog.main.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import blog.main.dao.ContactDAO;
import blog.main.entity.Contact;

@Component
public class ContactServiceImplementation implements ContactService{

	@Autowired
	private ContactDAO contactDAO;
	
	@Transactional
	@Override
	public Contact getContactInfo() {
		Contact contact = contactDAO.getContactInfo();
		return contact;
	}

	@Transactional
	@Override
	public void updateContact(Contact contact) {
		contactDAO.updateContact(contact);
		
	}

}
