package br.com.fabiopereira.casamento_api.services;

import java.util.List;
import br.com.fabiopereira.casamento_api.models.Categoria;

public interface ICategoriaService {
    Categoria inserir(Categoria categoria);
    Categoria alterar(Categoria categoria);
    List<Categoria> listarTodos();
    List<Categoria> listarPorPalavraChave(String palavraChave);
}
