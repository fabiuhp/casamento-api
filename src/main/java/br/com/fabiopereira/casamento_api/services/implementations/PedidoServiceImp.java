package br.com.fabiopereira.casamento_api.services.implementations;

import br.com.fabiopereira.casamento_api.models.ItemPedido;
import br.com.fabiopereira.casamento_api.models.Pedido;
import br.com.fabiopereira.casamento_api.repositories.PedidoRepository;
import br.com.fabiopereira.casamento_api.services.intefaces.IPedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PedidoServiceImp implements IPedidoService {
    @Autowired
    private PedidoRepository repository;

    @Override
    public Pedido inserir(Pedido pedido) {
        try {
            double total = 0.0;

            for (ItemPedido itemPedido : pedido.getItensPedido()) {
                itemPedido.setPrecoTotal(itemPedido.getPreco() * itemPedido.getQuantidadeItem());
                itemPedido.setPreco(itemPedido.getProduto().getPreco());
                itemPedido.setPedido(pedido);

                total += itemPedido.getPrecoTotal();
            }
            pedido.setPrecoTotal(total);
            return repository.save(pedido);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
