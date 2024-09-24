package br.com.lanchemania.lanchemania.vo;

import br.com.lanchemania.lanchemania.util.Categoria;
import lombok.Data;

@Data
public class CardapioVO {

    private Long id;
    private String nome;
    private String descricao;
    private String imagem;
    private Categoria categoria;
    private Double preco;
}
