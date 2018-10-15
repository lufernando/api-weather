package br.com.cast.apitempo.client;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import br.com.cast.apitempo.dto.WeatherDTO;

@Component
public class WeatherCliente {
	
	private static final String URL_BUSCA_PREVISOES = "http://api.openweathermap.org/data/2.5/forecast?q={cidade},br&units=metric&mode=json&appid={appid}&lang=pt";
	private static final String APPID = "70b2b71f31bfaf17093dfe71f4ad8f04";
	private RestTemplate client;
	
	public WeatherCliente(RestTemplateBuilder builder) {
		this.client = builder.build();
	}
	
	public WeatherDTO getPrevisoes(String cidade) {
		WeatherDTO weatherDTO = this.client.getForObject(URL_BUSCA_PREVISOES, WeatherDTO.class, cidade, APPID);
		return weatherDTO;
	}

}
