package br.com.fabiopereira.casamento_api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fabiopereira.casamento_api.models.Categoria;

import java.util.List;

public interface CategoriaRepository extends JpaRepository<Categoria, Long>{

    //consultar categoria por palavra-chave
    public List<Categoria> findByNomeContaining(String palavra);
    
}
