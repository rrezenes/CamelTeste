package com.brq.CamelTeste.config;

import org.apache.camel.component.servlet.CamelHttpTransportServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigRoute {

	@SuppressWarnings("rawtypes")
	@Bean
	public ServletRegistrationBean camelServletRegistrationBean() {
		ServletRegistrationBean registration = 
				new ServletRegistrationBean(new CamelHttpTransportServlet(),
				"/api/v1/*");
		registration.setName("CamelServlet");
		return registration;
	}

}
