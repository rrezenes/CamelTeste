package com.brq.CamelTeste.route;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

import com.brq.CamelTeste.bean.PessoaBean;

@Component
public class PessoaRoute extends RouteBuilder{

	public static final String ROTA_LISTA_PESSOAS = "direct:lista-pessoas-route";
	public static final String ROTA_LISTA_PESSOAS_ID = "direct-lista-pessoas-route";
	
	@Override
	public void configure() throws Exception {
		
		from(ROTA_LISTA_PESSOAS)
			.routeId(ROTA_LISTA_PESSOAS_ID)
			.routeDescription("Lista pessoas")
			.bean(PessoaBean.class,"gerarSaida");
	}	
}
