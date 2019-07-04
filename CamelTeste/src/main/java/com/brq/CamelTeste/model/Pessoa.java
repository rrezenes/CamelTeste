package com.brq.CamelTeste.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Pessoa {

	@JsonProperty("nome")
	private String nome;
	
	@JsonProperty("cpf")
	private String CPF;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCPF() {
		return CPF;
	}

	public void setCPF(String cPF) {
		CPF = cPF;
	}

}
