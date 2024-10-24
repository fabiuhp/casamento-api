package br.com.fabiopereira.casamento_api.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "item_pedido")
@Getter
@Setter
public class ItemPedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int quantidadeItem;

    private Double preco;

    private Double precoTotal;

    @ManyToOne
    @JoinColumn(name = "pedido_id")
    @JsonIgnoreProperties("itensPedido")
    private Pedido pedido;

    @ManyToOne
    @JoinColumn(name = "produto_id")
    private Produto produto;
}
