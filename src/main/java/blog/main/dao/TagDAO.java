package blog.main.dao;

import java.util.List;

import org.springframework.stereotype.Component;

 
import blog.main.entity.Tag;
@Component
public interface TagDAO {

	public List<Tag> getTagList();
	public void addTag(Tag tag);
	public Tag getTagById(int id_tag);
	public void deleteTag(int id_tag);
	public List<Tag>getTagListByBlogID(int id_blog_product);
	public List<Tag> getTagListByFrequency();
}
