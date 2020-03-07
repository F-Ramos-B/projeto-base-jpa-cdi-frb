package com.stefanini.dto;

import java.util.HashMap;
import java.util.Map;

public class FiltroEnderecoDTO {
	
	private String logradouro;
	private String complemento;
	private String bairro;
	private String cidade;
	private String uf;
	private String cep;
	private StringBuilder sql = new StringBuilder();
	
	public String getLogradouro() {
		return logradouro;
	}
	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}
	public String getComplemento() {
		return complemento;
	}
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getUf() {
		return uf;
	}
	public void setUf(String uf) {
		this.uf = uf;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	
	public StringBuilder getSql() {
		return sql;
	}
	public void setSql(StringBuilder sql) {
		this.sql = sql;
	}
	
	public Map<String, Object> getMapaAtributos() {
		Map<String, Object> mapa = new HashMap<>();
		if (logradouro != null && !logradouro.trim().isEmpty()) {
			mapa.put("logradouro", logradouro);
		}
		if (complemento != null && !complemento.trim().isEmpty()) {
			mapa.put("complemento", complemento);
		}
		if (bairro != null && !bairro.trim().isEmpty()) {
			mapa.put("bairro", bairro);
		}
		if (cidade != null && !cidade.trim().isEmpty()) {
			mapa.put("cidade", cidade);
		}
		if (uf != null && !uf.trim().isEmpty()) {
			mapa.put("uf", uf);
		}
		if (cep != null && !cep.trim().isEmpty()) {
			mapa.put("cep", cep);
		}
		return mapa;
	}
	
	public FiltroEnderecoDTO(String logradouro, String complemento, String bairro, String cidade, String uf,
			String cep) {
		this.logradouro = logradouro;
		this.complemento = complemento;
		this.bairro = bairro;
		this.cidade = cidade;
		this.uf = uf;
		this.cep = cep;
	}
	

}
