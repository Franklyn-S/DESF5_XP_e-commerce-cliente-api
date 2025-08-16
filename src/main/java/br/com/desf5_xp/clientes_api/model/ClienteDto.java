package br.com.desf5_xp.clientes_api.model;

public record ClienteDto(
        Long id,
        String nome,
        String email) {
    public ClienteDto(Cliente cliente) {
        this(cliente.getId(), cliente.getNome(), cliente.getEmail());
    }
}
