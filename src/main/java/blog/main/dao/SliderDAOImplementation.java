package blog.main.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import blog.main.entity.Slider;
 
 
 
@Repository
public class SliderDAOImplementation implements SliderDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Slider> getSliderList() {
		Session session = sessionFactory.getCurrentSession();
		List<Slider> sliderList=session.createQuery("from Slider s").list();
		return sliderList;
	}
	
	@Override
	public List<Slider> getEnabledSliderList() {
		Session session = sessionFactory.getCurrentSession();
		List<Slider> sliderList=session.createQuery("from Slider s where s.enabled=1 order by slider_priority asc").list();
		return sliderList;
	}
	 

	@Override
	public void addSlider(Slider slider) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(slider);
	
	}

	@Override
	public Slider getSliderById(int id_slider) {
		Session session = sessionFactory.getCurrentSession();
		Slider slider = session.get(Slider.class, id_slider);
		return slider;
	}

	@Override
	public void enableSlider(int id_slider) {
		Session session = sessionFactory.getCurrentSession();
		Slider slider  = session.get(Slider.class, id_slider);
		slider.setEnabled(!slider.getEnabled());
		this.addSlider(slider);
	}

	@Override
	public void setSliderPriority(int id_slider, int priority) {
		Session session = sessionFactory.getCurrentSession();
		Slider slider  = session.get(Slider.class, id_slider);
		slider.setSlider_priority(priority);
		session.saveOrUpdate(slider);
	}

	@Override
	public void deleteSlider(int id_slider) {
		Session session = sessionFactory.getCurrentSession();
		Slider slider  = session.get(Slider.class, id_slider);
		session.delete(slider);
	}

	

}
