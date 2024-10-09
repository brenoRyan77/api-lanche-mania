package br.com.lanchemania.lanchemania.controller;

import br.com.lanchemania.lanchemania.mapper.CardapioMapper;
import br.com.lanchemania.lanchemania.model.Cardapio;
import br.com.lanchemania.lanchemania.service.CardapioService;
import br.com.lanchemania.lanchemania.util.enumerate.Categoria;
import br.com.lanchemania.lanchemania.vo.CardapioVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cardapio")
@CrossOrigin("*")
public class CardapioController {

    @Autowired
    private CardapioService cardapioService;

    @Autowired
    private CardapioMapper cardapioMapper;

    @PostMapping
    public ResponseEntity<Void> incluir(@RequestBody CardapioVO vo) {
        cardapioService.incluir(vo);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> alterar(@RequestBody CardapioVO vo, @PathVariable("id") Long id) {
        cardapioService.alterar(id, vo);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @GetMapping
    public List<CardapioVO> listar() {
        List<Cardapio> cardapios = cardapioService.listarPaginado();
        return cardapios.stream().map(cardapioMapper::mapToVO).toList();
    }

    @GetMapping("/categoria/{categoria}")
    public List<CardapioVO> listarPorCategoria(@PathVariable("categoria") Categoria categoria){
        return cardapioService.listarPorCategoria(categoria).stream().map(cardapioMapper::mapToVO).toList();
    }

    @GetMapping("/{id}")
    public CardapioVO buscar(@PathVariable("id") Long id) {
        return cardapioMapper.mapToVO(cardapioService.buscar(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable("id") Long id) {
        cardapioService.excluir(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
