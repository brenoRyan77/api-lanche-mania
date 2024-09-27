package br.com.lanchemania.lanchemania.repository;

import br.com.lanchemania.lanchemania.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {

    @Query("SELECT p FROM Pedido p JOIN FETCH itens i WHERE p.id = :id")
    Optional<Pedido> findByIdLazyValues(Long id);
}
