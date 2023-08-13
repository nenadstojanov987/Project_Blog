package blog.main.dao;

import java.util.List;
import org.springframework.stereotype.Component;

import blog.main.entity.Role;
import blog.main.entity.User;

@Component
public interface UserDAO {
	public List<User> getUserList();
	public List<User> getEnabledUserList();
	public List<Role> getRoleList();
	public List<Role> getRoleListByUsername(String username);
	public void addUser(User user);
	public void updateExistingUser(User user);
	public User getUserByUsername(String username);
	public User getUserByName(String username);
	public User getUserByBlogID(int id_blog_product);
 	public void setEnableUser(String username);
	public void deleteUser(String username);
	public int getUserEnabledListNumber();
	
}
