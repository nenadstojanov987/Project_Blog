package blog.main.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import blog.main.dao.TagDAO;
import blog.main.entity.Tag;

@Component
public class TagServiceImplementation implements TagService {

	@Autowired
	private TagDAO tagDAO;
	
	@Transactional
	@Override
	public List<Tag> getTagList() {
		List<Tag> tagList = tagDAO.getTagList();
		return tagList;
	}
 
	@Transactional
	@Override
	public void addTag(Tag tag) {
		tagDAO.addTag(tag);
		
	}

	@Transactional
	@Override
	public Tag getTagById(int id_tag) {
		Tag tag = tagDAO.getTagById(id_tag);
		return  tag;
	}

	@Transactional
	@Override
	public void deleteTag(int id_tag) {
		tagDAO.deleteTag(id_tag);
		
	}
	
	@Transactional
	@Override
	public List<Tag> getTagListByBlogID(int id_blog_product) {
		List<Tag> tagList = tagDAO.getTagListByBlogID(id_blog_product);
		return tagList;
	}

	@Transactional
	@Override
	public List<Tag> getTagListByFrequency() {
		List<Tag>tagListByFrequency = tagDAO.getTagListByFrequency();
		return tagListByFrequency;
	}

}
