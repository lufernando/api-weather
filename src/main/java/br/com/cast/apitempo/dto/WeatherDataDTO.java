package br.com.cast.apitempo.dto;

import java.util.List;

public class WeatherDataDTO {
	
	private WeatherMainDTO main;
	private List<WeatherDescriptionDTO> weater;
	private WeatherWindDTO wind;
	private String data;
	
	public WeatherMainDTO getMain() {
		return main;
	}
	public void setMain(WeatherMainDTO main) {
		this.main = main;
	}
	public List<WeatherDescriptionDTO> getWeater() {
		return weater;
	}
	public void setWeater(List<WeatherDescriptionDTO> weater) {
		this.weater = weater;
	}
	public WeatherWindDTO getWind() {
		return wind;
	}
	public void setWind(WeatherWindDTO wind) {
		this.wind = wind;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}

}
