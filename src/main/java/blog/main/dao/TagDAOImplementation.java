package blog.main.dao;

import java.util.List;
import java.util.ArrayList;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import blog.main.entity.Tag;
import blog.main.entity.User;

@Repository
public class TagDAOImplementation implements TagDAO{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Tag> getTagList() {
		Session session =  sessionFactory.getCurrentSession();
		List<Tag> tagList = session.createQuery("from Tag t").list();
		return tagList;
	}
  
	@Override
	public void addTag(Tag tag) {
		Session session =  sessionFactory.getCurrentSession();
		session.saveOrUpdate(tag);
		
	}

	@Override
	public Tag getTagById(int id_tag) {
		Session session =  sessionFactory.getCurrentSession();
		Tag tag = session.get(Tag.class, id_tag);
		return tag;
	}

	@Override
	public void deleteTag(int id_tag) {
		Session session =  sessionFactory.getCurrentSession();
		Tag tag = session.get(Tag.class, id_tag);
		session.delete(tag);
		
	}

	@Override
	public List<Tag> getTagListByBlogID(int id_blog_product) {
		Session session = sessionFactory.getCurrentSession();
		//Query query = session.createSQLQuery("select id_tag, tag_name from tag inner join blog_product_tag on tag.id_tag = blog_product_tag.tag_id where blog_product_id =  (:id_blog_product)");
		Query query = session.createSQLQuery("call get_Tag_List_By_BlogID (:id_blog_product);");
		query.setParameter("id_blog_product", id_blog_product);
		List<Object[]> rows = query.getResultList();
		
		List<Tag> tagList = new ArrayList<Tag>();
		for(Object[] row: rows) 
		{
			Tag tag = new Tag();
			tag.setId_tag(Integer.parseInt(row[0].toString()));
			tag.setTag_name(row[1].toString());
			tagList.add(tag);
			
		}
		 
		return tagList; 
		
	}

	@Override
	public List<Tag> getTagListByFrequency() {
		Session session = sessionFactory.getCurrentSession();
		/*
		Query query = session.createSQLQuery(" select * from tag where tag.id_tag in (select subquery.tag_id from \n"
				+ " (select distinct tag_id, count(id_blog_product_tag)as counter from blog_product_tag inner join blog_product \n"
				+ "  on blog_product_tag.blog_product_id = blog_product.id_blog_product\n"
				+ "  where blog_product.enabled =1\n"
				+ "  group by tag_id order by counter desc ) as subquery)");
		*/
		Query query = session.createSQLQuery("select * from getTagListByFrequency");
		
		List<Object[]> rows = query.getResultList();
		
		List<Tag> tagListbyFrequency = new ArrayList<Tag>();
		for(Object[] row: rows) 
		{
			Tag tag = new Tag();
			tag.setId_tag(Integer.parseInt(row[0].toString()));
			tag.setTag_name(row[1].toString());
			tagListbyFrequency.add(tag);
			
		}
		 
		return tagListbyFrequency; 
		 
	}

}
