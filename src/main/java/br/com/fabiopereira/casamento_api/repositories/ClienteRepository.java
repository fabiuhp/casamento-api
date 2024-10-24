package br.com.fabiopereira.casamento_api.repositories;

import br.com.fabiopereira.casamento_api.models.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long>{

    Cliente findByEmailOrTelefone(String email, String telefone);
}
