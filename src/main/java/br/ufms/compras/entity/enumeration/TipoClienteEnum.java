package br.ufms.compras.entity.enumeration;

public enum TipoClienteEnum {

    PESSOAFISICA("Pessoa Fisica"),
    PESSOAJURIDICA("Pessoa Juridica");

    String descricao;

    TipoClienteEnum(String descricao){
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
