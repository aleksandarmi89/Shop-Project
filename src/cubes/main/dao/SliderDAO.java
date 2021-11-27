package cubes.main.dao;

import java.util.List;


import cubes.main.entity.Slider;



public interface SliderDAO {
	
	public List<Slider> getSliderList();

	public void saveSlider(Slider slider);

	public Slider getSliderbyId(int id);

	public void deleteSliderById(int id);

	public List<Slider> getSlidersHomepageList();
}
