package br.com.fabiopereira.casamento_api.repositories;

import br.com.fabiopereira.casamento_api.models.Cliente;
import br.com.fabiopereira.casamento_api.models.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PedidoRepository extends JpaRepository<Pedido, Long>{

    List<Pedido> findAllByCliente(Cliente cliente);
}
