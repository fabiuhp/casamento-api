package br.com.fabiopereira.casamento_api.services.intefaces;

import br.com.fabiopereira.casamento_api.models.Categoria;
import br.com.fabiopereira.casamento_api.models.Produto;

import java.util.List;

public interface IProdutoService {
    Produto inserir(Produto produto);
    Produto alterar(Produto produto);
    List<Produto> listarTodos();
    List<Produto> listarDisponiveis();
    List<Produto> listarPorCategorias(Categoria categoria);
}
