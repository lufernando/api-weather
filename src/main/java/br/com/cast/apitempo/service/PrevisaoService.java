package br.com.cast.apitempo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cast.apitempo.client.WeatherCliente;
import br.com.cast.apitempo.dto.ResultWeatherDTO;
import br.com.cast.apitempo.dto.WeatherDTO;
import br.com.cast.apitempo.dto.WeatherDataDTO;
import br.com.cast.apitempo.repository.TempoRepository;

@Service
public class PrevisaoService {
	
	@Autowired
	private WeatherCliente weatherClient;
	
	@Autowired
	private TempoRepository tempoRepository;
	
	public List<ResultWeatherDTO> getPrevisoes(String cidade){
		WeatherDTO previsoes = weatherClient.getPrevisoes(cidade);
		
		List<ResultWeatherDTO> rw = tempoRepository.buscarTodos(cidade);
		
		List<ResultWeatherDTO> resultado = new ArrayList<>();
		
		if(rw != null && rw.size() >=1) {
		
		for (WeatherDataDTO data : previsoes.getList()) {
			ResultWeatherDTO result = new ResultWeatherDTO();
			result.setData(data.getData());
			result.setPressao(data.getMain().getPressao());
			result.setTempmax(data.getMain().getTempmax());
			result.setTempmin(data.getMain().getTempmin());
			result.setUmidade(data.getMain().getUmidade());
			
		}
		
	} else {
		
		for (ResultWeatherDTO dto : resultado) {
			ResultWeatherDTO result = new ResultWeatherDTO();
			result.setCidade(dto.getCidade());
			result.setData(dto.getData());
			result.setIcon(dto.getIcon());
			result.setId(dto.getId());
			result.setPressao(dto.getPressao());
			result.setSpeed(dto.getSpeed());
			result.setTempmax(dto.getTempmax());
			result.setTempmin(dto.getTempmin());
			result.setUmidade(dto.getPressao());
			
		}
	}
		return resultado;
		
	}

}
