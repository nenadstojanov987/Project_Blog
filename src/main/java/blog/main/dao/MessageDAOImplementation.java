package blog.main.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import blog.main.entity.Message;

@Repository
public class MessageDAOImplementation implements MessageDAO {

	@Autowired
	public SessionFactory sessionFactory;
	
	@Override
	public List<Message> getMessageList() {
		Session session = sessionFactory.getCurrentSession();
		List<Message>messageList = session.createQuery("from Message m").list();
		return messageList;
	}

	@Override
	public void saveMessage(Message message) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(message);
		
	}

	@Override
	public void setSeenMessage(int id_message) {
		
		Session session = sessionFactory.getCurrentSession();
		Message message =session.get(Message.class,id_message);  
		message.setSeen(true);
		session.saveOrUpdate(message);
		
	}

	@Override
	public Message getMessagebyId(int id_message) {
		Session session = sessionFactory.getCurrentSession();
		Message message = session.get(Message.class, id_message);
		return message;
	}

	@Override
	public long getUnseenMessageCount() {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("select count(*) from Message m where m.seen=0");
		long number = (long) query.uniqueResult();
		return number;
	}

	@Override
	public void deleteMessage(int id_message) {
		Session session = sessionFactory.getCurrentSession();
		Message message = session.get(Message.class, id_message);
		session.delete(message);
	}

	@Override
	public long getMessageCount() {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("select count(*) from Message m");
		long number = (long) query.uniqueResult();
		return number;
	}
 

}
