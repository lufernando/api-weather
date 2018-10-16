package br.com.cast.apitempo.dto;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class WeatherDataDTO {
	
	@JsonProperty("main")
	private WeatherMainDTO main;
	
	@JsonProperty("weather")
	private List<WeatherDescriptionDTO> weater;
	
	@JsonProperty("wind")
	private WeatherWindDTO wind;
	
	@JsonProperty("dt_txt")
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
	
	public Date getDataConvertida() {
		if (data != null) {
			try {
				return new SimpleDateFormat("yyyy-MM-dd").parse(data);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

}
