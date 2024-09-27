package br.com.lanchemania.lanchemania.vo;

import lombok.Data;

@Data
public class ClienteVO {

    private Long id;
    private String nome;
    private String numero;
    private EnderecoVO endereco;


    @Data
    public static class EnderecoVO {
        private Long id;
        private String logradouro;
        private String numero;
        private String complemento;
        private String bairro;
        private String cidade;
        private String estado;
        private String cep;
    }
}
