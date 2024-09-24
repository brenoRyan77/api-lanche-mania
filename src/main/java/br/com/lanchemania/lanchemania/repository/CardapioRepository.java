package br.com.lanchemania.lanchemania.repository;

import br.com.lanchemania.lanchemania.model.Cardapio;
import br.com.lanchemania.lanchemania.repository.custom.CardapioRepositoryCustom;
import br.com.lanchemania.lanchemania.util.Categoria;
import org.springframework.boot.context.properties.bind.Name;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Repository
public interface CardapioRepository extends JpaRepository<Cardapio, Long>, CardapioRepositoryCustom {
    Page<Cardapio> findByCategoria(@Param("categoria") Categoria categoria, Pageable pageable);
}
