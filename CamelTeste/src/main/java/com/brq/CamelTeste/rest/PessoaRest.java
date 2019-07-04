package com.brq.CamelTeste.rest;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.JsonLibrary;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;

import com.brq.CamelTeste.route.PessoaRoute;

@Component
public class PessoaRest extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		rest()
			.get("/pessoas")
			.produces(MediaType.APPLICATION_JSON_VALUE)
			.route()
				.routeId("lista-pessoas")
				.routeDescription("Lista Pessoas")
			.to(PessoaRoute.ROTA_LISTA_PESSOAS)
			.marshal().json(JsonLibrary.Jackson)
		.end();
	}

}
