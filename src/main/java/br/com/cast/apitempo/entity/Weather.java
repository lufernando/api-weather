package br.com.cast.apitempo.entity;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "tempo", schema = "api")
public class Weather {
	
	@Id
	@SequenceGenerator(sequenceName = "tempo_id_seq", name = "gerador_end_seq", allocationSize = 1, schema = "api")
	@GeneratedValue(generator = "gerador_end_seq", strategy = GenerationType.SEQUENCE)
	private Integer id;
	
	@Column(name="data")
	private Date data;
	private String tempmin;
	private String tempmax;
	private String pressao;
	private String umidade;
	private String main;
	
	@Column(name="icone")
	private String icon;
	
	@Column(name="velocidade")
	private String speed;
	
	private String cidade;
	
	public String getMain() {
		return main;
	}
	public void setMain(String main) {
		this.main = main;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
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
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	public String getSpeed() {
		return speed;
	}
	public void setSpeed(String speed) {
		this.speed = speed;
	}
	
}
