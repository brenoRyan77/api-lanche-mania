package br.com.lanchemania.lanchemania.util.enumerate;

public enum StatusPedido {

    RECEBIDO("Recebido"),
    EM_PREPARACAO("Em Preparação"),
    CONCLUIDO("Concluído"),
    CANCELADO("Cancelado");

    private final String descricao;

    StatusPedido(String descricao) {
        this.descricao = descricao;
    }
}
