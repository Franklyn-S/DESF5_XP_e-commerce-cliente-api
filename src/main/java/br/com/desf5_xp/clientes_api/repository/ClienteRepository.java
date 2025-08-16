package br.com.desf5_xp.clientes_api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.desf5_xp.clientes_api.model.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    List<Cliente> findByEmail(String email);

    List<Cliente> findByNome(String name);

    List<Cliente> findByNomeContainingIgnoreCase(String nome);
}
