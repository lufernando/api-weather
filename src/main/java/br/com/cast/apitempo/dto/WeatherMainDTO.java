package br.com.cast.apitempo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class WeatherMainDTO {
	
	@JsonProperty("temp_min")
	private String tempmin;
	
	@JsonProperty("temp_max")
	private String tempmax;
	
	@JsonProperty("pressure")
	private String pressao;
	
	@JsonProperty("humidity")
	private String umidade;
	

	public String getTempmin() {
		return tempmin;
	}

	public void setTempmin(String tempmin) {
		this.tempmin = tempmin;
	}

	public String getTempmax() {
		return tempmax;
	}

	public void setTempmax(String tempmax) {
		this.tempmax = tempmax;
	}

	public String getPressao() {
		return pressao;
	}

	public void setPressao(String pressao) {
		this.pressao = pressao;
	}

	public String getUmidade() {
		return umidade;
	}

	public void setUmidade(String umidade) {
		this.umidade = umidade;
	}
	
}
