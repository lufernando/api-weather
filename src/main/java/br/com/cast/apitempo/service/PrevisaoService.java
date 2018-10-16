package br.com.cast.apitempo.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cast.apitempo.client.WeatherCliente;
import br.com.cast.apitempo.dto.ResultWeatherDTO;
import br.com.cast.apitempo.dto.WeatherDTO;
import br.com.cast.apitempo.dto.WeatherDataDTO;
import br.com.cast.apitempo.dto.WeatherDescriptionDTO;
import br.com.cast.apitempo.entity.Weather;
import br.com.cast.apitempo.repository.TempoRepository;

@Service
public class PrevisaoService {
	
	@Autowired
	private WeatherCliente weatherClient;
	
	@Autowired
	private TempoRepository tempoRepository;
	
	public List<ResultWeatherDTO> getPrevisoes(String cidade){
		
		List<Weather> listaEntidade = tempoRepository.buscarTodos(cidade);
		List<ResultWeatherDTO> resultado = new ArrayList<>();
		
		if(listaEntidade.size() < 5) {
			
			tempoRepository.excluir(cidade);
			
			Map<String, ResultWeatherDTO> registros = new HashMap<>();
			WeatherDTO previsoes = weatherClient.getPrevisoes(cidade);
			
			for (WeatherDataDTO data : previsoes.getList()) {
				String dataMap = data.getData().substring(0, 10);
				if(registros.containsKey(dataMap)) {
					continue;
				}
				
				ResultWeatherDTO result = apiParaDto(cidade, data);
				
				registros.put(dataMap, result);
				resultado.add(result);
				inserir(result);
			}
			
		
	} else {
		
		for (Weather dto : listaEntidade) {
			
			ResultWeatherDTO result = entidadeParaDto(dto);
			
			resultado.add(result);
		}
		
	}
		return resultado;
	}

	public void inserir(ResultWeatherDTO dto) {
		
		Weather weather = dtoParaEntidade(dto);
		
		tempoRepository.inserir(weather);
		
	}
	
	//metodo para salvar no banco
	public Date stringToDate(String data) {
		Date dataFormatada = null;
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		try {
			dataFormatada = format.parse(data);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dataFormatada;
	}
	
	//metodo para exibir na tela
	public String dateToString(Date date) {
		String dataFormatada = "";
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		try {
			dataFormatada = format.format(date);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dataFormatada;
	}

	private Weather dtoParaEntidade(ResultWeatherDTO dto) {
		Weather weather = new Weather();
		weather.setCidade(dto.getCidade());
		weather.setData(stringToDate(dto.getData()));
		weather.setIcon(dto.getIcon());
		weather.setPressao(dto.getPressao());
		weather.setSpeed(dto.getPressao());
		weather.setTempmax(dto.getTempmax());
		weather.setTempmin(dto.getTempmin());
		weather.setUmidade(dto.getUmidade());
		weather.setMain(dto.getMain());
		return weather;
	}
	
	private ResultWeatherDTO entidadeParaDto(Weather dto) {
		ResultWeatherDTO result = new ResultWeatherDTO();
		result.setCidade(dto.getCidade());
		result.setData(dateToString(dto.getData()));
		result.setIcon(dto.getIcon());
		result.setPressao(dto.getPressao());
		result.setSpeed(dto.getSpeed());
		result.setTempmax(dto.getTempmax());
		result.setTempmin(dto.getTempmin());
		result.setUmidade(dto.getPressao());
		result.setMain(dto.getMain());
		return result;
	}
	
	private ResultWeatherDTO apiParaDto(String cidade, WeatherDataDTO data) {
		ResultWeatherDTO result = new ResultWeatherDTO();
		result.setCidade(cidade);
		result.setData(data.getData());
		result.setPressao(data.getMain().getPressao());
		result.setTempmax(data.getMain().getTempmax());
		result.setTempmin(data.getMain().getTempmin());
		result.setUmidade(data.getMain().getUmidade());
		result.setSpeed(data.getWind().getSpeed());
		
		for (WeatherDescriptionDTO resultWeatherDTO : data.getWeater()) {
			result.setIcon(resultWeatherDTO.getIcon());
			result.setMain(resultWeatherDTO.getMain());
		}
		return result;
	}
}
