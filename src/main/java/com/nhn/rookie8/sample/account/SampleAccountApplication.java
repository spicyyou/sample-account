package com.nhn.rookie8.sample.account;

import org.apache.catalina.connector.Connector;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
public class SampleAccountApplication {

	public static void main(String[] args) {
		SpringApplication.run(SampleAccountApplication.class, args)
		;
	}

	@Configuration
	public class ContainerConfig{
		@Bean 
		public ServletWebServerFactory servletContainer() { 
			TomcatServletWebServerFactory tomcat = new TomcatServletWebServerFactory(); 
			tomcat.addAdditionalTomcatConnectors(createAjpConnector());
			return tomcat; 
		}

		private Connector createAjpConnector() {
			Connector ajpConnector = new Connector("AJP/1.3");
			ajpConnector.setPort(9099); ajpConnector.setSecure(false);
			ajpConnector.setAllowTrace(false);
			ajpConnector.setScheme("http");
			return ajpConnector;
		}
	}

}
