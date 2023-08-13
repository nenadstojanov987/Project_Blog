package blog.main.dao;

 
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

 
import blog.main.entity.Role;
import blog.main.entity.User;
 

@Repository
public class UserDAOImplementation implements UserDAO{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<User> getUserList() {
		Session session =  sessionFactory.getCurrentSession();
		List<User> userList = session.createQuery("from User u").list();
		return userList;
	}

	@Override
	public List<User> getEnabledUserList() {
		Session session =  sessionFactory.getCurrentSession();
		List<User> userList = session.createQuery("from User u where u.enabled=1").list();
		return userList;
	}

	@Override
	public void addUser(User user) {
		Session session = sessionFactory.getCurrentSession();
		session.save(user);
		  
	}

	@Override
	public void updateExistingUser(User user) {
		Session session = sessionFactory.getCurrentSession();
		session.update(user);
		 	 	
	}
	
	@Override
	public User getUserByUsername(String username) {
		Session session = sessionFactory.getCurrentSession();
		User user = session.get(User.class, username);
		return user;
		
	}

	@Override
	public void setEnableUser(String username) {
		Session session = sessionFactory.getCurrentSession();
		User user = session.get(User.class, username);
		user.setEnabled(!user.getEnabled());
		
		if(user.getEnabled()) {
			Role role = new Role("ROLE_user");
			List<Role> roles = new ArrayList<Role>();
			roles.add(role);
			user.setRoles(roles);
			 
		}
		else {
			Role role = new Role("ROLE_banned");
			List<Role> roles = new ArrayList<Role>();
			roles.add(role);
			user.setRoles(roles);
		}
		session.saveOrUpdate(user);
	}

	
	@Override
	public void deleteUser(String username) {
		Session session = sessionFactory.getCurrentSession();
		User user = session.get(User.class, username);
		session.delete(user);
		
	}

	@Override
	public List<Role> getRoleList() {
		Session session = sessionFactory.getCurrentSession();
		List<Role> roleList = session.createQuery("from Role r").list();
		return roleList;
	}

	@Override
	public User getUserByName(String username) {
		Session session = sessionFactory.getCurrentSession();
		User user = session.get(User.class, username);
		return user;
	}

	 
	@Override
	public User getUserByBlogID(int id_blog_product) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createSQLQuery("call get_User_By_BlogID(:id_blog_product)");
		query.setParameter("id_blog_product", id_blog_product);
		List<Object[]> rows = query.getResultList();
		List<User> userList = new ArrayList<User>();
		for(Object[] row:rows) 
		{
			User u = new User();
			u.setUsername(row[0].toString());
			u.setPassword(row[1].toString());
			u.setName(row[2].toString());
			u.setSurname(row[3].toString());
			u.setEmail(row[4].toString());
			u.setPhone_number(row[5].toString());
			u.setImage(row[6].toString());
			u.setEnabled(Boolean.parseBoolean(row[7].toString()));
			userList.add(u);
		}
		User user = userList.get(0);
		return user;
		 
	}

	@Override
	public int getUserEnabledListNumber() {
		Session session =  sessionFactory.getCurrentSession();
		List<User> userList = session.createSQLQuery("select count(*) from users inner join authorities on users.username = authorities.username where users.enabled=1 and authorities.authority = 'ROLE_user';").list();
		return 0;
	}

	@Override
	public List<Role> getRoleListByUsername(String username) {
		Session session = sessionFactory.getCurrentSession();
		 Query query = session.createSQLQuery("select authority from authorities where username = :username");
		 query.setParameter("username", username);
		 Role role = new Role(query.uniqueResult().toString());
		 List<Role> roleList = new ArrayList<Role>();
		 roleList.add(role);
		  
		return roleList;
	}

	

	

}
