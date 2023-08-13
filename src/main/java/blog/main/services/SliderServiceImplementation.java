package blog.main.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import blog.main.dao.SliderDAO;
import blog.main.entity.Slider;

@Component
public class SliderServiceImplementation implements SliderService {

	@Autowired
	private SliderDAO sliderDAO;
	
	
	@Transactional
	@Override
	public List<Slider> getSliderList() {
		List<Slider> sliderList=sliderDAO.getSliderList();
		return sliderList;
	}
	@Transactional
	@Override
	public List<Slider> getEnabledSliderList() {
		List<Slider> sliderList=sliderDAO.getEnabledSliderList();
		return sliderList;
	}


	@Transactional
	@Override
	public void addSlider(Slider slider) {
		sliderDAO.addSlider(slider);
	}

	@Transactional
	@Override
	public Slider getSliderById(int id_slider) {
		Slider slider = sliderDAO.getSliderById(id_slider);
		return slider;
	}

	@Transactional
	@Override
	public void enableSlider(int id_slider) {
		sliderDAO.enableSlider(id_slider);
		
	}

	@Transactional
	@Override
	public void setSliderPriority(int id_slider, int priority) {
		sliderDAO.setSliderPriority(id_slider, priority);
		
	}

	@Transactional
	@Override
	public void deleteSlider(int id_slider) {
		sliderDAO.deleteSlider(id_slider);
		
	}

	
}
