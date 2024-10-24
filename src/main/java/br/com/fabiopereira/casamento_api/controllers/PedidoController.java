package br.com.fabiopereira.casamento_api.controllers;

import br.com.fabiopereira.casamento_api.models.Pedido;
import br.com.fabiopereira.casamento_api.services.intefaces.IPedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("pedidos")
public class PedidoController {
    @Autowired
    private IPedidoService service;

    @PostMapping
    public ResponseEntity<Pedido> inserir (@RequestBody Pedido pedido) {
        Pedido resultado = service.inserir(pedido);

        if (resultado != null) {
            return ResponseEntity.status(201).body(resultado);
        }
        return ResponseEntity.badRequest().build();
    }
}
