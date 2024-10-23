package br.com.fabiopereira.casamento_api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.fabiopereira.casamento_api.models.Categoria;
import br.com.fabiopereira.casamento_api.repositories.CategoriaRepository;

@Component
public class CategoriaServiceImp implements ICategoriaService{

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Override
    public Categoria inserir(Categoria categoria) {
        try {
            if (categoria.getNome() != null && categoria.getNome().length() > 0) {
                return categoriaRepository.save(categoria);
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Debug: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Debug: " + e.getMessage());
        }
        return null;
    }

    @Override
    public Categoria alterar(Categoria categoria) {
        try {
            if (categoria.getId() != null && categoria.getNome() != null && categoria.getNome().length() > 0) {
                return categoriaRepository.save(categoria);
            }
        } catch (Exception e) {
            System.out.println("Debug: " + e.getMessage());
        }
        return null;
    }

    @Override
    public List<Categoria> listarTodos() {
        return categoriaRepository.findAll();
    }

    @Override
    public List<Categoria> listarPorPalavraChave(String palavraChave) {
        if (palavraChave != null){
            return categoriaRepository.findByNomeContaining(palavraChave);
        }
        return null;
    }

}
