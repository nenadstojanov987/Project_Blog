package blog.main.services;

import java.util.List;
 
import org.springframework.stereotype.Service;

import blog.main.entity.Slider;

@Service
public interface SliderService {

	public List<Slider> getSliderList();
	public List<Slider> getEnabledSliderList();
	public void addSlider(Slider slider);
	public Slider getSliderById(int id_slider);
 	public void enableSlider(int id_slider);
 	public void setSliderPriority(int id_slider, int priority);
	public void deleteSlider(int id_slider);
}
