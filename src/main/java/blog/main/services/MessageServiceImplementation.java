package blog.main.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import blog.main.dao.MessageDAO;
import blog.main.entity.Message;

@Component
public class MessageServiceImplementation implements MessageService{

	@Autowired
	private MessageDAO messageDAO;
	
	
	@Transactional
	@Override
	public List<Message> getMessageList() {
		List<Message>messageList = messageDAO.getMessageList();
		return messageList;
		
	}

	@Transactional
	@Override
	public void saveMessage(Message message) {
		messageDAO.saveMessage(message);
		
	}

	@Transactional
	@Override
	public void setSeenMessage(int id_message) {
		messageDAO.setSeenMessage(id_message);
		
	}

	@Transactional
	@Override
	public Message getMessagebyId(int id_message) {
		Message message = messageDAO.getMessagebyId(id_message);
		return message;
	}

	@Transactional
	@Override
	public long getUnseenMessageCount() {
		long count = messageDAO.getUnseenMessageCount();
		return count;
	}

	@Transactional
	@Override
	public void deleteMessage(int id_message) {
		messageDAO.deleteMessage(id_message);
		
	}
		
	@Transactional
	@Override
	public long getMessageCount() {
		long count = messageDAO.getMessageCount();
		return count;
	}

}
