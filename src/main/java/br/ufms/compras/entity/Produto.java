package br.ufms.compras.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "tb_produto")
@SequenceGenerator(name = "seq_produto", sequenceName = "seq_produto")
public class Produto {

    @Id
    @Column(name = "pr_id")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "seq_produto")
    private Long id;

    @Column(name = "pr_nome")
    private String nome;

    @Column(name = "pr_preco")
    private Double preco;

    @JsonIgnore
    @ManyToMany
    @JoinTable(name = "tb_produto_categoria",
            joinColumns = @JoinColumn(name = "pr_id"),
            inverseJoinColumns = @JoinColumn(name = "ca_id"))
    private List<Categoria> categorias = new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "id.produto")
    private Set<ItemPedido> itens = new HashSet<>();

    public Produto() {

    }

    public Produto(Long id, String nome, Double preco) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public List<Categoria> getCategorias() {
        return categorias;
    }

    public void setCategorias(List<Categoria> categorias) {
        this.categorias = categorias;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Produto produto = (Produto) o;
        return Objects.equals(id, produto.id);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id);
    }
}
