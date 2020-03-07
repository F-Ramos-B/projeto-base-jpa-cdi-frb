package com.stefanini.servico;

import java.util.List;
import java.util.Optional;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.stefanini.dao.PessoaDAO;
import com.stefanini.dto.FiltroEnderecoDTO;
import com.stefanini.dto.FiltroPessoaDTO;
import com.stefanini.model.Pessoa;
import com.stefanini.util.IGenericService;

/**
 * 
 * Classe de servico, as regras de negocio devem estar nessa classe
 * 
 * @author joaopedromilhome
 *
 */
public class PessoaServico implements IGenericService<Pessoa, Long> {

	@Inject
	private PessoaDAO dao;

	/**
	 * Salvar os dados de uma Pessoa
	 */
	public Pessoa salvar(@Valid Pessoa entity) {
		return dao.salvar(entity);
	}

	/**
	 * Atualizar o dados de uma pessoa
	 */
	@Override
	public Pessoa atualizar(@Valid Pessoa entity) {
		return dao.atualizar(entity);
	}

	/**
	 * Remover uma pessoa pelo id
	 */
	@Override
	public void remover(Long id) {
		dao.remover(id);
	}

	/**
	 * Buscar uma lista de Pessoa
	 */
	@Override
	public Optional<List<Pessoa>> getList() {
		return dao.getList();
	}

	public Optional<List<Pessoa>> getList(@NotNull FiltroPessoaDTO filtro, @NotNull FiltroEnderecoDTO filtroEndereco) {
		return dao.getList(filtro, filtroEndereco);
	}

	/**
	 * Buscar uma Pessoa pelo ID
	 */
	@Override
	public Optional<Pessoa> encontrar(Long id) {
		return dao.encontrar(id);
	}

}
