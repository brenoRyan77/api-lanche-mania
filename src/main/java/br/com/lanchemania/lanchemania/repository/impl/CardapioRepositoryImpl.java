package br.com.lanchemania.lanchemania.repository.impl;

import br.com.lanchemania.lanchemania.model.Cardapio;
import br.com.lanchemania.lanchemania.repository.custom.CardapioRepositoryCustom;
import br.com.lanchemania.lanchemania.util.enumerate.Categoria;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.List;

public class CardapioRepositoryImpl implements CardapioRepositoryCustom {

    @Autowired
    private EntityManager entityManager;
    @Override
    public Page<Cardapio> listarPaginado(String nome, Categoria categoria, Pageable pageable) {
        StringBuilder jpql = new StringBuilder("SELECT c FROM Cardapio c WHERE 1=1");

        if (nome != null && !nome.trim().isEmpty()) {
            jpql.append(" AND LOWER(c.nome) LIKE LOWER(:nome)");
        }

        if (categoria != null) {
            jpql.append(" AND c.categoria = :categoria");
        }

        TypedQuery<Cardapio> query = entityManager.createQuery(jpql.toString(), Cardapio.class);

        if (nome != null && !nome.trim().isEmpty()) {
            query.setParameter("nome", "%" + nome.toLowerCase() + "%");
        }

        if (categoria != null) {
            query.setParameter("categoria", categoria);
        }

        query.setFirstResult(pageable.getPageNumber() * pageable.getPageSize());
        query.setMaxResults(pageable.getPageSize());

        List<Cardapio> results = query.getResultList();

        long total = countFilteredResults(nome, categoria);

        return new PageImpl<>(results, pageable, total);
    }

    private long countFilteredResults(String nome, Categoria categoria) {
        StringBuilder countJpql = new StringBuilder("SELECT COUNT(c) FROM Cardapio c WHERE 1=1");

        if (nome != null && !nome.trim().isEmpty()) {
            countJpql.append(" AND LOWER(c.nome) LIKE LOWER(:nome)");
        }

        if (categoria != null) {
            countJpql.append(" AND c.categoria = :categoria");
        }

        TypedQuery<Long> countQuery = entityManager.createQuery(countJpql.toString(), Long.class);

        if (nome != null && !nome.trim().isEmpty()) {
            countQuery.setParameter("nome", "%" + nome.toLowerCase() + "%");
        }

        if (categoria != null) {
            countQuery.setParameter("categoria", categoria);
        }

        return countQuery.getSingleResult();
    }
}
