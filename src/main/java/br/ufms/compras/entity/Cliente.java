package br.ufms.compras.entity;

import br.ufms.compras.entity.enumeration.TipoClienteEnum;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

@Entity
@Table(name = "tb_cliente")
@SequenceGenerator(name = "seq_cliente", sequenceName = "seq_cliente")
public class Cliente implements Serializable{
    
    @Id
    @Column(name = "cl_id")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "seq_cliente")
    private Long id;

    @Column(name = "cl_nome")
    private String nome;

    @Column(name = "cl_email")
    private String email;

    @Column(name = "cl_cpfCnpj")
    private String cpfCnpj;

    @Column(name = "cl_tipo")
    @Enumerated(EnumType.STRING)
    private TipoClienteEnum tipo;

    @OneToMany(mappedBy = "cliente")
    private List<Endereco> enderecos = new ArrayList<>();

    @OneToMany(mappedBy = "cliente")
    private List<Pedido> pedidos = new ArrayList<>();

    @ElementCollection
    @CollectionTable(name = "tb_telefone", joinColumns = @JoinColumn(name = "cl_id"))
    private Set<String> telefones = new HashSet<>();

    public Cliente(){
        
    }

    public Cliente(Long id, String nome, String email, String cpfCnpj, TipoClienteEnum tipo) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.cpfCnpj = cpfCnpj;
        this.tipo = tipo;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public TipoClienteEnum getTipo() {
        return tipo;
    }

    public void setTipo(TipoClienteEnum tipo) {
        this.tipo = tipo;
    }

    public String getCpfCnpj() {
        return cpfCnpj;
    }

    public void setCpfCnpj(String cpfCnpj) {
        this.cpfCnpj = cpfCnpj;
    }

    public List<Endereco> getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(List<Endereco> enderecos) {
        this.enderecos = enderecos;
    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(List<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

    public Set<String> getTelefones() {
        return telefones;
    }

    public void setTelefones(Set<String> telefones) {
        this.telefones = telefones;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cliente cliente = (Cliente) o;
        return Objects.equals(id, cliente.id);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id);
    }
}
