package br.com.lanchemania.lanchemania.vo;

import br.com.lanchemania.lanchemania.util.Categoria;
import br.com.lanchemania.lanchemania.util.deserializer.CategoriaDeserializer;
import br.com.lanchemania.lanchemania.util.serializer.CategoriaSerializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;

@Data
public class CardapioVO {

    private Long id;
    private String nome;
    private String descricao;
    private String imagem;
    @JsonDeserialize(using = CategoriaDeserializer.class)
    @JsonSerialize(using = CategoriaSerializer.class)
    private Categoria categoria;
    private Double preco;
}
