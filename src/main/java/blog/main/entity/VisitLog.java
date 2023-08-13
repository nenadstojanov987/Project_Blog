package blog.main.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="visit_log")
public class VisitLog {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column
	private int id_visit_log;
	@Column
	private int blog_product_id;
	@Column
	private LocalDateTime visit_log_date;

	
	public VisitLog() {}


	public VisitLog(int id_visit, int blog_product_id, LocalDateTime visit_date) {
		super();
		this.id_visit_log = id_visit;
		this.blog_product_id = blog_product_id;
		this.visit_log_date = visit_date;
	}
	public VisitLog(String id_visit, int blog_product_id, LocalDateTime visit_date) {
		super();
		this.id_visit_log = Integer.parseInt(id_visit);
		this.blog_product_id = blog_product_id;
		this.visit_log_date = visit_date;
	}
	
	public VisitLog( int blog_product_id, LocalDateTime visit_date) {
		super();
		this.blog_product_id = blog_product_id;
		this.visit_log_date = visit_date;
	}


	public int getId_visit() {
		return id_visit_log;
	}


	public void setId_visit(int id_visit) {
		this.id_visit_log = id_visit;
	}


	public int getBlog_product_id() {
		return blog_product_id;
	}


	public void setBlog_product_id(int blog_product_id) {
		this.blog_product_id = blog_product_id;
	}


	public LocalDateTime getVisit_date() {
		return visit_log_date;
	}


	public void setVisit_date(LocalDateTime visit_date) {
		this.visit_log_date = visit_date;
	}


	@Override
	public String toString() {
		return "Visit_log [id_visit_log=" + id_visit_log + ", blog_product_id=" + blog_product_id + ", visit_log_date=" + visit_log_date
				+ "]";
	}
	
	
}
