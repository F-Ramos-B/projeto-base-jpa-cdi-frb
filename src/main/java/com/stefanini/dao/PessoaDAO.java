package com.stefanini.dao;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.persistence.TypedQuery;

import com.stefanini.dao.abstracao.GenericDAO;
import com.stefanini.dto.FiltroPessoaDTO;
import com.stefanini.model.Pessoa;
import com.stefanini.util.FiltroUtils;

/**
 * O Unico objetivo da Dao
 * 
 * @author joaopedromilhome
 *
 */
public class PessoaDAO extends GenericDAO<Pessoa, Long> {

	public PessoaDAO() {
		super(Pessoa.class);
	}

	public Optional<List<Pessoa>> getList(FiltroPessoaDTO filtro) {
		Map<String, Object> mapaFiltro = FiltroUtils.obterFiltroPessoa(filtro);
		StringBuilder sql = new StringBuilder();
		sql.append(" select p from Pessoa p ");
		sql.append(" where 1=1 ");

		sql.append(filtro.getSql());

		TypedQuery<Pessoa> query = getEntityManager().createQuery(sql.toString(), Pessoa.class);

		mapaFiltro.forEach((k, v) -> {
			query.setParameter(k, v);
		});

		return Optional.ofNullable(query.getResultList());
	}

}
