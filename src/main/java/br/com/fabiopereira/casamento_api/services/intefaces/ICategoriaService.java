package br.com.fabiopereira.casamento_api.services.intefaces;

import br.com.fabiopereira.casamento_api.models.Categoria;

import java.util.List;

public interface ICategoriaService {
    Categoria inserir(Categoria categoria);
    Categoria alterar(Categoria categoria);
    List<Categoria> listarTodos();
    List<Categoria> listarPorPalavraChave(String palavraChave);
}
