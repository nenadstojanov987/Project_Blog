package blog.main.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="image_slider")
public class ImageSlider {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column
	private int id_image_slider;
	@Column
	private String image_path_upload;
	
	public ImageSlider() {}
	
	public ImageSlider(int id_image_slider, String image_path_upload) {
		super();
		this.id_image_slider = id_image_slider;
		this.image_path_upload = image_path_upload;
	}
	
	public ImageSlider(String image_path_upload) {
		super();
	 
		this.image_path_upload = image_path_upload;
	}
 
	public int getId_image_slider() {
		return id_image_slider;
	}

	public void setId_image_slider(int id_image_slider) {
		this.id_image_slider = id_image_slider;
	}

	public String getImage_path_upload() {
		return image_path_upload;
	}

	public void setImage_path_upload(String image_path_upload) {
		this.image_path_upload = image_path_upload;
	}
	
	
	
}
