package br.com.lanchemania.lanchemania.service;

import br.com.lanchemania.lanchemania.mapper.CardapioMapper;
import br.com.lanchemania.lanchemania.model.Cardapio;
import br.com.lanchemania.lanchemania.repository.CardapioRepository;
import br.com.lanchemania.lanchemania.util.enumerate.Categoria;
import br.com.lanchemania.lanchemania.vo.CardapioVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class CardapioService {

    @Autowired
    private CardapioRepository cardapioRepository;

    @Autowired
    private CardapioMapper cardapioMapper;

    @Transactional
    public void incluir(CardapioVO cardapioVO) {
        cardapioRepository.save(cardapioMapper.mapToEntity(cardapioVO));
    }

    @Transactional
    public void alterar(Long id, CardapioVO cardapioVO) {
        Cardapio cardapio = buscar(id);
        cardapioMapper.updateEntity(cardapio, cardapioVO);
        cardapioRepository.save(cardapio);
    }

    public Page<Cardapio> listarPaginado(String nome, Categoria categoria, Pageable pageable) {
        return cardapioRepository.listarPaginado(nome, categoria, pageable);
    }

    public Page<Cardapio> listarPorCategoria(Categoria categoria, Pageable pageable) {
        return cardapioRepository.findByCategoria(categoria, pageable);
    }

    @Transactional
    public void excluir(Long id) {
        Optional.ofNullable(buscar(id)).ifPresent(cardapioRepository::delete);
    }

    public Cardapio buscar(Long id) {
        return cardapioRepository.findById(id).orElseThrow(() -> new RuntimeException("Cardápio não encontrado"));
    }
}
