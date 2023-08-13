package blog.main.services;

import org.springframework.stereotype.Service;

import blog.main.entity.Contact;

@Service
public interface ContactService {
	public Contact getContactInfo();
	 
	public void updateContact(Contact contact);
}
