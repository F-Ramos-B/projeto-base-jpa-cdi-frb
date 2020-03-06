package com.stefanini.dto;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class FiltroPessoaDTO {

	private String nome;
	private String email;
	private LocalDate dataNascimento;
	private Boolean situacao;
	private StringBuilder sql = new StringBuilder();

	public FiltroPessoaDTO() {
	}

	public FiltroPessoaDTO(String nome, String email, LocalDate dataNascimento, Boolean situacao) {
		this.nome = nome;
		this.email = email;
		this.dataNascimento = dataNascimento;
		this.situacao = situacao;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public Boolean getSituacao() {
		return situacao;
	}

	public void setSituacao(Boolean situacao) {
		this.situacao = situacao;
	}

	public StringBuilder getSql() {
		return sql;
	}

	public void setSql(StringBuilder sql) {
		this.sql = sql;
	}

	public Map<String, Object> getMapaAtributos() {
		Map<String, Object> mapa = new HashMap<>();
		if (nome != null && !nome.trim().isEmpty()) {
			mapa.put("nome", nome);
		}
		if (email != null && !email.trim().isEmpty()) {
			mapa.put("email", email);
		}
		if (situacao != null) {
			mapa.put("situacao", situacao);
		}
		if (dataNascimento != null) {
			mapa.put("dataNascimento", dataNascimento);
		}
		return mapa;
	}

}
