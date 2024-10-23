package br.com.fabiopereira.casamento_api.services.implementations;

import br.com.fabiopereira.casamento_api.models.Categoria;
import br.com.fabiopereira.casamento_api.models.Produto;
import br.com.fabiopereira.casamento_api.repositories.ProdutoRepository;
import br.com.fabiopereira.casamento_api.services.intefaces.IProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProdutoServiceImp implements IProdutoService {
    @Autowired
    private ProdutoRepository repository;

    @Override
    public Produto listar(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Produto inserir(Produto produto) {
        try {
            return repository.save(produto);
        } catch (Exception e) {
            System.out.println("Inserir Produto: ");
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Produto alterar(Produto produto) {
        try {
            return repository.save(produto);
        } catch (Exception e) {
            System.out.println("Alterar Produto: ");
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Produto> listarTodos() {
        return repository.findAll();
    }

    @Override
    public List<Produto> listarDisponiveis() {
        return repository.findAllByDisponivel(true);
    }

    @Override
    public List<Produto> listarIndisponiveis() {
        return repository.findAllByDisponivel(false);
    }

    @Override
    public List<Produto> listarPorCategoria(Categoria categoria) {
        return repository.findAllByDisponivelAndCategoria(true, categoria);
    }
}
