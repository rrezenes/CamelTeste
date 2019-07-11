package com.brq.CamelTeste.bean;

import java.util.Arrays;
import java.util.List;

import org.apache.camel.Exchange;

import com.brq.CamelTeste.model.Endereco;
import com.brq.CamelTeste.model.Pessoa;

public class PessoaBean {

	public void gerarSaida(Exchange ex) {
		Pessoa pessoa = new Pessoa();
		pessoa.setCPF("12312312312");
		pessoa.setNome("Fulano");
		Pessoa pessoa2 = new Pessoa();
		pessoa2.setCPF("11111111111");
		pessoa2.setNome("Beltrano");

		List<Pessoa> pessoas = Arrays.asList(pessoa, pessoa2);

		ex.getOut().setBody(pessoas);
	}
	
	public void prepararEntrada(Exchange ex) {
		Endereco end = new Endereco();
		
		end.setCep("09210-270");
		
		ex.setProperty("cep", "09210270");
		
	}
	
	public void tratarSaida(Exchange ex) {
		String nome = ex.getIn().getHeader("nome", String.class);
		Endereco body = ex.getIn().getBody(Endereco.class);
		
		Pessoa p = new Pessoa();
		p.setEndereco(body);
		p.setCPF("12312312312");
		p.setNome(nome);
		
		ex.getOut().setBody(p);
		
		
	}
	
	public void gerarEntradaDados(Endereco end) {
		
	}

}
