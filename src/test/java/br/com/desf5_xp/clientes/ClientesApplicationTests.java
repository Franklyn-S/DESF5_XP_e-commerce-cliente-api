package br.com.desf5_xp.clientes;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

@Import(TestcontainersConfiguration.class)
@SpringBootTest
class ClientesApplicationTests {

	@Test
	void contextLoads() {
	}

}
