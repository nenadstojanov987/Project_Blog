package blog.main.entity;

public class CommentFormWrapper {
	private Visitor visitor;
	private BlogComment blogComment;
	
	public CommentFormWrapper() {}
	
	
	 
	public CommentFormWrapper(Visitor visitor, BlogComment blogComment) {
		super();
		this.visitor = visitor;
		this.blogComment = blogComment;
	}

 
	public Visitor getVisitor() {
		return visitor;
	}
	public void setVisitor(Visitor visitor) {
		this.visitor = visitor;
	}
	public BlogComment getBlogComment() {
		return blogComment;
	}
	public void setBlogComment(BlogComment blogComment) {
		this.blogComment = blogComment;
	}



	@Override
	public String toString() {
		return "CommentFormWrapper [visitor=" + /*visitor.getVisitor_name().toString() +*/ ", blogComment=" + blogComment.getContent().toString() + "]";
	}
	
	
	
}
