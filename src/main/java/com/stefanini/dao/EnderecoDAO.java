package com.stefanini.dao;

import com.stefanini.dao.abstracao.GenericDAO;
import com.stefanini.model.Endereco;

public class EnderecoDAO extends GenericDAO<Endereco, Integer> {
	public EnderecoDAO() {
		super(Endereco.class);
	}
}
