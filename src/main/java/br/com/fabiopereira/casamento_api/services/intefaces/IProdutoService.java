package br.com.fabiopereira.casamento_api.services.intefaces;

import br.com.fabiopereira.casamento_api.models.Categoria;
import br.com.fabiopereira.casamento_api.models.Produto;

import java.util.List;

public interface IProdutoService {
    Produto listar(Long id);
    Produto inserir(Produto produto);
    Produto alterar(Produto produto);
    List<Produto> listarTodos();
    List<Produto> listarDisponiveis();
    List<Produto> listarIndisponiveis();
    List<Produto> listarPorCategoria(Categoria categoria);
}
