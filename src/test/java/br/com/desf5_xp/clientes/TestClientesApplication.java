package br.com.desf5_xp.clientes;

import org.springframework.boot.SpringApplication;

import br.com.desf5_xp.clientes_api.ClientesApiApplication;

public class TestClientesApplication {

	public static void main(String[] args) {
		SpringApplication.from(ClientesApiApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
