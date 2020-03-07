package com.stefanini.dao;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.persistence.TypedQuery;

import com.stefanini.dao.abstracao.GenericDAO;
import com.stefanini.dto.FiltroEnderecoDTO;
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

	public Optional<List<Pessoa>> getList(FiltroPessoaDTO filtro, FiltroEnderecoDTO filtroEndereco) {
		Map<String, Object> mapaFiltro = FiltroUtils.obterFiltroPessoa(filtro);
		Map<String, Object> mapaFiltroEndereco = FiltroUtils.obterFiltroEndereco(filtroEndereco);
		StringBuilder sql = new StringBuilder();
		sql.append(" select distinct p from Pessoa p ");
//		sql.append(" join p.enderecos e ");
		sql.append(" where 1=1 ");
		
		sql.append(filtro.getSql());
		sql.append(filtroEndereco.getSql());

		
		TypedQuery<Pessoa> query = getEntityManager().createQuery(sql.toString(), Pessoa.class);

		mapaFiltro.forEach((k, v) -> {
			query.setParameter(k, v);
		});
		
		mapaFiltroEndereco.forEach((k, v) -> {
			query.setParameter(k, v);
		});
		
//		sql.append(" group by pessoa ");

		return Optional.ofNullable(query.getResultList());
	}

}
