package br.com.lanchemania.lanchemania.repository.custom;

import br.com.lanchemania.lanchemania.model.Cardapio;
import br.com.lanchemania.lanchemania.util.enumerate.Categoria;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CardapioRepositoryCustom {
    Page<Cardapio> listarPaginado(String nome, Categoria categoria, Pageable pageable);

}
