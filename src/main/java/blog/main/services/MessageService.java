package blog.main.services;

import java.util.List;

import org.springframework.stereotype.Service;

import blog.main.entity.Message;

@Service
public interface MessageService {
	public List<Message>getMessageList();
	public void saveMessage(Message message);
	public void setSeenMessage(int id_message);
	public void deleteMessage(int id_message);
	public Message getMessagebyId(int id_message);
	public long getMessageCount();
	public long getUnseenMessageCount();
}
