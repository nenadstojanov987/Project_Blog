package blog.main.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import blog.main.entity.Slider;
 
@Component
public interface SliderDAO {

	public List<Slider> getSliderList();
	public List<Slider> getEnabledSliderList();
	public void addSlider(Slider slider);
	public Slider getSliderById(int id_slider);
 	public void enableSlider(int id_slider);
 	public void setSliderPriority(int id_slider, int priority);
	public void deleteSlider(int id_slider);
	
}
