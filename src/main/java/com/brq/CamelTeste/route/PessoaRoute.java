package com.brq.CamelTeste.route;

import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.JsonLibrary;
import org.springframework.stereotype.Component;

import com.brq.CamelTeste.bean.PessoaBean;
import com.brq.CamelTeste.model.Endereco;

@Component
public class PessoaRoute extends RouteBuilder{

	public static final String ROTA_LISTA_PESSOAS = "direct:lista-pessoas-route";
	public static final String ROTA_LISTA_PESSOAS_ID = "direct-lista-pessoas-route";
	
	@Override
	public void configure() throws Exception {
		
		from(ROTA_LISTA_PESSOAS)
			.routeId(ROTA_LISTA_PESSOAS_ID)
			.routeDescription("Lista pessoas")
			.bean(PessoaBean.class,"prepararEntrada")
		    .setHeader(Exchange.HTTP_METHOD, constant("GET"))
		    .setHeader(Exchange.HTTP_URI, simple("http://viacep.com.br")) 
			.toD("http4://viacep.com.br/ws/${property.cep}/json/")
			.unmarshal().json(JsonLibrary.Jackson, Endereco.class)
			.bean(PessoaBean.class,"tratarSaida");
	}	
}
