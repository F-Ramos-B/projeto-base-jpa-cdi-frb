package com.stefanini.util;

import java.util.Map;

import com.stefanini.dto.FiltroEnderecoDTO;
import com.stefanini.dto.FiltroPessoaDTO;

public class FiltroUtils {

	public static Map<String, Object> obterFiltroPessoa(FiltroPessoaDTO filtro) {
		Map<String, Object> mapaFiltro = filtro.getMapaAtributos();
		mapaFiltro.forEach((k, v) -> {
			filtro.getSql().append(" AND ");
			switch (k) {
			case "nome":
				filtro.getSql().append(" p.nome LIKE :nome");
				break;
			case "email":
				filtro.getSql().append(" p.email LIKE :email");
				break;
			case "dataNascimento":
				filtro.getSql().append(" p.dataNascimento = :dataNascimento ");
				break;
			default:
				filtro.getSql().append(" p.situacao = :situacao ");
				break;
			}
		});
		return mapaFiltro;
	}
	
	public static Map<String, Object> obterFiltroEndereco(FiltroEnderecoDTO filtro) {
		Map<String, Object> mapaFiltro = filtro.getMapaAtributos();
		mapaFiltro.forEach((k, v) -> {
			filtro.getSql().append(" AND ");
			switch (k) {
			case "logradouro":
				filtro.getSql().append(" e.logradouro LIKE :logradouro");
				break;
			case "complemento":
				filtro.getSql().append(" e.complemento LIKE :complemento");
				break;
			case "bairro":
				filtro.getSql().append(" e.bairro = :bairro ");
				break;
			case "cidade":
				filtro.getSql().append(" e.cidade = :cidade ");
				break;
			case "uf":
				filtro.getSql().append(" e.uf = :uf ");
				break;
			default:
				filtro.getSql().append(" e.cep = :cep ");
				break;
			}
		});
		return mapaFiltro;
	}
	
	

}
