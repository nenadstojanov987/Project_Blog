package blog.main.services;

import java.util.List;

 
import org.springframework.stereotype.Service;

import blog.main.entity.Tag;

@Service
public interface TagService {
	
	public List<Tag> getTagList();
	public void addTag(Tag tag);
	public Tag getTagById(int id_tag);
	public void deleteTag(int id_tag);
	public List<Tag>getTagListByBlogID(int id_blog_product);
	public List<Tag> getTagListByFrequency();
}
