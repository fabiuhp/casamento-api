package br.com.fabiopereira.casamento_api.controllers;

import br.com.fabiopereira.casamento_api.models.Categoria;
import br.com.fabiopereira.casamento_api.services.intefaces.ICategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("categorias")
public class CategoriaController {

    @Autowired
    private ICategoriaService service;

    @GetMapping
    public ResponseEntity<List<Categoria>> listarTodas() {
        return ResponseEntity.ok(service.listarTodos());
    }

    @GetMapping("search")
    public ResponseEntity<List<Categoria>> listarPorPalavraChave(@RequestParam(name = "key") String palavraChave) {
        if (palavraChave != null) {
            return ResponseEntity.ok(service.listarPorPalavraChave(palavraChave));
        }
        return ResponseEntity.badRequest().build();
    }

    @PostMapping
    public ResponseEntity<Categoria> inserir(@RequestBody Categoria categoria) {
        Categoria resultado = service.inserir(categoria);

        if (resultado != null) {
            return ResponseEntity.status(201).body(resultado);
        }
        return ResponseEntity.badRequest().build();
    }

    @PutMapping
    public ResponseEntity<Categoria> alterar(@RequestBody Categoria categoria) {
        Categoria resultado = service.alterar(categoria);

        if (resultado != null) {
            return ResponseEntity.ok(resultado);
        }
        return ResponseEntity.badRequest().build();
    }
}
