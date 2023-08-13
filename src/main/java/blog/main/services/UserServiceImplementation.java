package blog.main.services;

import java.util.List;


import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import blog.main.dao.UserDAO;
import blog.main.entity.Role;
import blog.main.entity.User;

@Component
public class UserServiceImplementation implements UserService{

	@Autowired
	private UserDAO userDAO;

	@Transactional
	@Override
	public List<User> getUserList() {
		List<User> userList = userDAO.getUserList();
		
		return userList;
	}

	@Transactional
	@Override
	public List<User> getEnabledUserList() {
		List<User> userList = userDAO.getEnabledUserList();
		return userList;
	}
	
	@Transactional
	@Override
	public List<Role> getRoleList() {
		List<Role> roleList=userDAO.getRoleList();
		return roleList;
	}

	@Transactional
	@Override
	public void addUser(User user) {
	  userDAO.addUser(user);
	 
	}
	
	@Transactional
	@Override
	public void updateExistingUser(User user) {
		userDAO.updateExistingUser(user);
		
	}

	@Transactional
	@Override
	public User getUserByUsername(String username) {
		User user = userDAO.getUserByUsername(username);
		return user;
	}

	@Transactional
	@Override
	public void setEnableUser(String username) {
		userDAO.setEnableUser(username);
		
	}


	@Transactional
	@Override
	public void deleteUser(String username) {
		userDAO.deleteUser(username);
	}

	@Transactional
	@Override
	public User getUserByName(String username) {
		User user = userDAO.getUserByName(username);
		return user;
	}
	
	@Transactional
	@Override
	public User getUserByBlogID(int id_blog_product) {
		 
		User user = userDAO.getUserByBlogID(id_blog_product);
		
		return user;
	}

	@Transactional
	@Override
	public List<Role> getRoleListByUsername(String username) {
		 
		List<Role> roleList = userDAO.getRoleListByUsername(username);
		return roleList;
	}

	

	
	
	
	
}
