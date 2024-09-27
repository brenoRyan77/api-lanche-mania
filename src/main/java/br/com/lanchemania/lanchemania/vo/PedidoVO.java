package br.com.lanchemania.lanchemania.vo;

import br.com.lanchemania.lanchemania.util.enumerate.StatusPedido;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class PedidoVO {

    private Long id;
    private Long numeroPedido;
    private Double total;
    private StatusPedido status;
    private ClienteVO cliente;
    private List<ItemPedidoVO> itens = new ArrayList<>();

    @Data
    public static class ItemPedidoVO {

        private Long id;
        private String observacao;
        private Integer quantidade;
        private Double subtotal;
        private CardapioVO cardapio;
    }
}
