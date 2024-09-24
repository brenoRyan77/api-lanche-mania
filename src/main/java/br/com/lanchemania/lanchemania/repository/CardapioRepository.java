package br.com.lanchemania.lanchemania.repository;

import br.com.lanchemania.lanchemania.model.Cardapio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardapioRepository extends JpaRepository<Cardapio, Long> {
}
