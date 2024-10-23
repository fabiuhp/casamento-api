package br.com.fabiopereira.casamento_api.repositories;

import br.com.fabiopereira.casamento_api.models.Categoria;
import br.com.fabiopereira.casamento_api.models.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
    List<Produto> findAllByCategoria(Categoria categoria);
    List<Produto> findAllByDisponivel(boolean disponivel);
    List<Produto> findAllByDisponivelAndCategoria(boolean disponivel, Categoria categoria);
}
