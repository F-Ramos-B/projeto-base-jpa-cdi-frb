package com.stefanini.teste;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import javax.enterprise.inject.se.SeContainer;
import javax.enterprise.inject.se.SeContainerInitializer;
import javax.inject.Inject;

import com.stefanini.dto.FiltroPessoaDTO;
import com.stefanini.model.Endereco;
import com.stefanini.model.Pessoa;
import com.stefanini.servico.EnderecoServico;
import com.stefanini.servico.PessoaServico;

public class App {

	@Inject
	private PessoaServico pessoaServico;
	@Inject
	private EnderecoServico enderecoServico;

	public static void main(String[] args) {
		// CONFIGURACAO PARA INICIAR O CONTAINER PARA GERENCIAMENTO DO CDI
		SeContainerInitializer initializer = SeContainerInitializer.newInstance();
		try (final SeContainer container = initializer.initialize()) {
			App app = container.select(App.class).get();
			app.executar();
		}
	}

	public void executar() {
//		buscarTodos();
		buscarPessoaFiltro();
//		encontrar();
//		salvar();
//		salvarEndereco();
//		remover();
		System.out.println("=======================");
	}

	private void remover() {
		pessoaServico.remover(5L);
	}

	private void encontrar() {
		Optional<Pessoa> pessoa = pessoaServico.encontrar(1L);
		System.out.println("=======================");
		System.out.println(pessoa.isPresent() ? pessoa.get() : "Pessoa não encontrada");
	}

	private void buscarTodos() {
		pessoaServico.getList().ifPresent(conteudo -> {
			System.out.println("=======================");
			conteudo.forEach(cadaPessoa -> {
				System.out.println(cadaPessoa);
				System.out.println("----");
			});
		});
	}

	private void buscarPessoaFiltro() {
		pessoaServico.getList(new FiltroPessoaDTO(null, "joa%", null, null))
			.ifPresent(lista -> lista.forEach(System.out::println));
	}

	public void salvar() {

		Pessoa pessoa = new Pessoa("ELIAS", "elias.dev@hotmail.com", LocalDate.of(1996, 8, 24), true);
		pessoaServico.salvar(pessoa);

	}

	public void salvarEndereco() {
//		Pessoa pessoa = new Pessoa();
//		pessoa.setId(1L);
//		Optional<Pessoa> pessoaPegada = pessoaServico.encontrar(1L);
		Endereco endereco = new Endereco(pessoaServico.encontrar(1L).get(), "SQSW 173", "AP381", "Cruz", "Brasília",
				"DF", "70670420");
		enderecoServico.salvar(endereco);

	}

}
