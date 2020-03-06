package com.stefanini.servico;

import java.util.List;
import java.util.Optional;

import javax.inject.Inject;
import javax.validation.Valid;

import com.stefanini.dao.EnderecoDAO;
import com.stefanini.model.Endereco;
import com.stefanini.util.IGenericService;

public class EnderecoServico implements IGenericService<Endereco, Integer> {
	
	@Inject
	private EnderecoDAO dao;
	
	
	/**
	 * Salvar os dados de uma Pessoa
	 */
	public Endereco salvar(@Valid Endereco entity) {
		return dao.salvar(entity);
	}


	/**
	 * Atualizar o dados de uma pessoa
	 */
	@Override
	public Endereco atualizar(@Valid Endereco entity) {
		return dao.atualizar(entity);
	}


	/**
	 * Remover uma pessoa pelo id
	 */
	@Override
	public void remover(Integer id) {
		dao.remover(id);
	}


	/**
	 * Buscar uma lista de Pessoa
	 */
	@Override
	public Optional<List<Endereco>> getList() {
		return dao.getList();
	}


	/**
	 * Buscar uma Pessoa pelo ID
	 */
	@Override
	public Optional<Endereco> encontrar(Integer id) {
		return dao.encontrar(id);
	}

}
