package br.com.fabiopereira.casamento_api.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "produtos")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String nome;

    @Column(length = 500)
    private String detalhe;

    @Column(length = 255, nullable = false)
    private String linkFoto;

    @Column(nullable = false)
    private Double preco;

    @Column(nullable = false)
    private boolean disponivel;

    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;

}
