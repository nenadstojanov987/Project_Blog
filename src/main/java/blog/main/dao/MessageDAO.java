package blog.main.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import blog.main.entity.Message;

 
@Component
public interface MessageDAO {

	public List<Message>getMessageList();
	public void saveMessage(Message message);
	public void setSeenMessage(int id_message);
	public void deleteMessage(int id_message);
	public Message getMessagebyId(int id_message);
	public long getMessageCount();
	public long getUnseenMessageCount();
 
}
