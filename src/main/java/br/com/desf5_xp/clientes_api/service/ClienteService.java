package br.com.desf5_xp.clientes_api.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.desf5_xp.clientes_api.model.Cliente;
import br.com.desf5_xp.clientes_api.model.ClienteDto;
import br.com.desf5_xp.clientes_api.repository.ClienteRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ClienteService {
    private final ClienteRepository clienteRepository;

    public List<ClienteDto> listarTodos() {
        return clienteRepository.findAll()
                .stream()
                .map(ClienteDto::new)
                .toList();
    }

    public ClienteDto buscarPorId(Long id) {
        return clienteRepository.findById(id)
                .map(ClienteDto::new)
                .orElse(null);
    }

    public ClienteDto salvar(ClienteDto clienteDto) {
        var cliente = new Cliente(clienteDto);
        var savedCliente = clienteRepository.save(cliente);
        return new ClienteDto(savedCliente);
    }

    public List<ClienteDto> buscarPorNome(String nome) {
        return clienteRepository.findByNomeContainingIgnoreCase(nome)
                .stream()
                .map(ClienteDto::new)
                .toList();
    }

    public List<ClienteDto> buscarPorEmail(String email) {
        return clienteRepository.findByEmail(email)
                .stream()
                .map(ClienteDto::new)
                .toList();
    }

    public void deletar(Long id) {
        if (!clienteRepository.existsById(id)) {
            throw new RuntimeException("Cliente não encontrado");
        }
        clienteRepository.deleteById(id);
    }

    public ClienteDto atualizar(Long id, ClienteDto clienteDto) {
        if (!clienteRepository.existsById(id)) {
            throw new RuntimeException("Cliente não encontrado");
        }
        var cliente = new Cliente(clienteDto);
        cliente.setId(id);
        var updatedCliente = clienteRepository.save(cliente);
        return new ClienteDto(updatedCliente);
    }

    public Long contarClientes() {
        return clienteRepository.count();
    }
}
