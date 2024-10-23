package br.com.fabiopereira.casamento_api.controllers;

import br.com.fabiopereira.casamento_api.models.Categoria;
import br.com.fabiopereira.casamento_api.models.Produto;
import br.com.fabiopereira.casamento_api.services.intefaces.IProdutoService;
import br.com.fabiopereira.casamento_api.services.intefaces.IUploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("produtos")
public class ProdutoController {
    @Autowired
    private IProdutoService service;

    @Autowired
    private IUploadService upload;

    @PostMapping
    public ResponseEntity<Produto> inserir(@RequestBody Produto produto) {
        try {
            service.inserir(produto);
            return ResponseEntity.status(201).body(produto);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.badRequest().build();
    }

    @PostMapping("upload")
    public ResponseEntity<String> uploadFoto(@RequestParam(name = "arquivo")MultipartFile arquivo) {
        String path = upload.uploadFile(arquivo);

        if (path != null) {
            return ResponseEntity.status(201).body(path);
        }
        return ResponseEntity.badRequest().build();
    }

    @GetMapping
    public ResponseEntity<List<Produto>> listarTodos() {
        return ResponseEntity.ok(service.listarDisponiveis());
    }

    @GetMapping("categoria/{id}")
    public ResponseEntity<List<Produto>> listarPorCategoria(@PathVariable Long id) {
        Categoria categoria = new Categoria();
        categoria.setId(id);

        return ResponseEntity.ok(service.listarPorCategoria(categoria));
    }

    @GetMapping("{id}")
    public ResponseEntity<Produto> listar(@PathVariable Long id) {
        Produto produto = service.listar(id);

        if (produto != null) {
            return ResponseEntity.ok(produto);
        }
        return ResponseEntity.notFound().build();
    }
}
