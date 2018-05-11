package br.ufms.compras.entity;

import br.ufms.compras.entity.enumeration.EstadoPagamentoEnum;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "tb_pagamento_com_cartao")
public class PagamentoComCartao extends Pagamento {

    private static final long serialVersionUID = 1L;

    @Column(name = "pcc_numero_de_parcelas")
    private Integer numeroDeParcelas;

    public PagamentoComCartao(){

    }

    public PagamentoComCartao(Long id, EstadoPagamentoEnum estado, Pedido pedido, Integer numeroDeParcelas) {
        super(id, estado, pedido);
        this.numeroDeParcelas = numeroDeParcelas;
    }

    public Integer getNumeroDeParcelas() {
        return numeroDeParcelas;
    }

    public void setNumeroDeParcelas(Integer numeroDeParcelas) {
        this.numeroDeParcelas = numeroDeParcelas;
    }
}
