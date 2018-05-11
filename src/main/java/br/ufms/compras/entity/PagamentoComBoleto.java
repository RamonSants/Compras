package br.ufms.compras.entity;

import br.ufms.compras.entity.enumeration.EstadoPagamentoEnum;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "tb_pagamento_com_boleto")
public class PagamentoComBoleto extends Pagamento {

    private static final long serialVersionUID = 1L;

    @JsonFormat(pattern = "dd/MM/yyyy")
    @Column(name = "pcb_data_vencimento")
    private Date dataVencimento;

    @JsonFormat(pattern = "dd/MM/yyyy")
    @Column(name = "pcb_data_pagamento")
    private Date dataPagamento;

    public PagamentoComBoleto(){

    }

    public PagamentoComBoleto(Long id, EstadoPagamentoEnum estado, Pedido pedido, Date dataVencimento, Date dataPagamento) {
        super(id, estado, pedido);
        this.dataVencimento = dataVencimento;
        this.dataPagamento = dataPagamento;
    }

    public Date getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(Date dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public Date getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(Date dataPagamento) {
        this.dataPagamento = dataPagamento;
    }
}
