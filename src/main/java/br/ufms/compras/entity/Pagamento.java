package br.ufms.compras.entity;

import br.ufms.compras.entity.enumeration.EstadoPagamentoEnum;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "tb_pagamento")
@Inheritance(strategy = InheritanceType.JOINED)
@SequenceGenerator(name = "seq_pagamento", sequenceName = "seq_pagamento")
public class Pagamento implements Serializable {

    @Id
    @Column(name = "pa_id")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "seq_pagamento")
    private Long id;

    @Column(name = "pa_estado")
    @Enumerated(EnumType.STRING)
    private EstadoPagamentoEnum estado;

    @JsonIgnore
    @OneToOne
    @JoinColumn(name = "pe_id")
    @MapsId
    private Pedido pedido;

    public Pagamento(){

    }

    public Pagamento(Long id, EstadoPagamentoEnum estado, Pedido pedido) {
        this.id = id;
        this.estado = estado;
        this.pedido = pedido;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public EstadoPagamentoEnum getEstado() {
        return estado;
    }

    public void setEstado(EstadoPagamentoEnum estado) {
        this.estado = estado;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pagamento pagamento = (Pagamento) o;
        return Objects.equals(id, pagamento.id);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id);
    }
}
