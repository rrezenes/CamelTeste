package com.brq.CamelTeste.bean;

import java.util.Arrays;
import java.util.List;

import org.apache.camel.Exchange;

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

}
