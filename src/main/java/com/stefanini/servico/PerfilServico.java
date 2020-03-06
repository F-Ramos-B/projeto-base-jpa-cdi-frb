package com.stefanini.servico;

import java.util.List;
import java.util.Optional;

import javax.inject.Inject;
import javax.validation.Valid;

import com.stefanini.dao.PerfilDAO;
import com.stefanini.model.Perfil;
import com.stefanini.util.IGenericService;

public class PerfilServico implements IGenericService<Perfil, Integer> {

	@Inject
	private PerfilDAO dao;
	
	
	/**
	 * Salvar os dados de uma Pessoa
	 */
	public Perfil salvar(@Valid Perfil entity) {
		return dao.salvar(entity);
	}


	/**
	 * Atualizar o dados de uma pessoa
	 */
	@Override
	public Perfil atualizar(@Valid Perfil entity) {
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
	public Optional<List<Perfil>> getList() {
		return dao.getList();
	}


	/**
	 * Buscar uma Pessoa pelo ID
	 */
	@Override
	public Optional<Perfil> encontrar(Integer id) {
		return dao.encontrar(id);
	}
}
