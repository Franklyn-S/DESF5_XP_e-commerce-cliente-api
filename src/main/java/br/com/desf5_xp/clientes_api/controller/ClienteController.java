package br.com.desf5_xp.clientes_api.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.desf5_xp.clientes_api.model.ClienteDto;
import br.com.desf5_xp.clientes_api.service.ClienteService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/clientes")
@RequiredArgsConstructor
public class ClienteController {
    private final ClienteService clienteService;

    @GetMapping
    public ResponseEntity<List<ClienteDto>> listarTodos() {
        return ResponseEntity.ok(clienteService.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClienteDto> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(clienteService.buscarPorId(id));
    }

    @GetMapping("/nome/{nome}")
    public ResponseEntity<List<ClienteDto>> buscarPorNome(@PathVariable String nome) {
        return ResponseEntity.ok(clienteService.buscarPorNome(nome));
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<List<ClienteDto>> buscarPorEmail(@PathVariable String email) {
        return ResponseEntity.ok(clienteService.buscarPorEmail(email));
    }

    @GetMapping("/total")
    public ResponseEntity<Long> contarClientes() {
        return ResponseEntity.ok(clienteService.contarClientes());
    }

    @PostMapping
    public ResponseEntity<ClienteDto> salvar(@RequestBody ClienteDto clienteDto) {
        return ResponseEntity.ok(clienteService.salvar(clienteDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClienteDto> atualizar(@PathVariable Long id, @RequestBody ClienteDto clienteDto) {
        return ResponseEntity.ok(clienteService.atualizar(id, clienteDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        clienteService.deletar(id);
        return ResponseEntity.noContent().build();
    }

}
