package br.com.lanchemania.lanchemania.model;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@MappedSuperclass
@Getter
@Setter
public abstract class ModeloGenerico {

    @Column(name = "data_atualizacao", nullable = false)
    private LocalDateTime dataAtualizacao;

    @Column(name = "ativo", nullable = false)
    private boolean ativo;

    public ModeloGenerico() {
        this.dataAtualizacao = LocalDateTime.now();
        this.ativo = true;
    }
}
