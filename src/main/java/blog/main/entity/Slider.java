package blog.main.entity;

  
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
 
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
 
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

 

  
@Entity
@Table(name="slider")
@Valid
public class Slider {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column
	private int id_slider;
	@Column
	@NotBlank
	@Size(min=3, max=255)
	private String slider_title;
	 
	@Column
	private String image;
	
	@Column
	@NotBlank
	@Size(min=3, max=500)
	private String description;
	@Column
	@NotBlank
	@Size(min=2, max=255)
	private String button_title;
	@Column
	@NotBlank
	private String url;
	@Column
	private boolean enabled;
	
	@Column
	@Min(1) @Max(30)
	@NotNull
	private int slider_priority;
	
	public Slider() {}
	
	
	public Slider(int id_slider, String slider_title, String image,
			String description,
			String button_title, String url, boolean enabled,
			int slider_priority) {
		super();
		this.id_slider = id_slider;
		this.slider_title = slider_title;
		//this.imageSlider = imageSlider;
		this.description = description;
		this.button_title = button_title;
		this.url = url;
		this.enabled = enabled;
		this.slider_priority = slider_priority;
		this.image = image;
	}

	

	public Slider(String slider_title, String image,
			String description,
			String button_title, String url, boolean enabled,
			int slider_priority) {
		super();
		this.slider_title = slider_title;
		//this.imageSlider = imageSlider;
		this.description = description;
		this.button_title = button_title;
		this.url = url;
		this.enabled = enabled;
		this.slider_priority = slider_priority;
		this.image = image;
	}


	public Slider(String slider_title, String image,
			String description,
			String button_title, String url, boolean enabled) {
		super();
	 
		this.slider_title = slider_title;
		//this.imageSlider = imageSlider;
		this.description = description;
		this.button_title = button_title;
		this.url = url;
		this.enabled = enabled;
		this.image = image;
	}

 
	public int getId_slider() {
		return id_slider;
	}
	public void setId_slider(int id_slider) {
		this.id_slider = id_slider;
	}
	public String getSlider_title() {
		return slider_title;
	}
	public void setSlider_title(String slider_title) {
		 
		this.slider_title = slider_title;
	 
	}
	
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		 
		
		this.image = image;
	 
	}
	
	public String getDescription() {
		
		return description;
	}
	public void setDescription(String description) {
		 
		this.description = description;
		 
	}
	public String getButton_title() {
		return button_title;
	}
	public void setButton_title(String button_title) {
		 
		this.button_title = button_title;
		 
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		 
		this.url = url;
		 
	}
	public boolean getEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	public int getSlider_priority() {
		return slider_priority;
	}
	public boolean setSlider_priority(int slider_priority) {
		if(slider_priority<0) {
			return false;
		}
		this.slider_priority = slider_priority;
		return true;
	}


	@Override
	public String toString() {
		return "Slider [id_slider=" + id_slider + ", slider_title=" + slider_title + ", image=" + image
				+ ", description=" + description + ", button_title=" + button_title + ", url=" + url + ", enabled="
				+ enabled + ", slider_priority=" + slider_priority + "]";
	}


 
	
	
	
	
}
