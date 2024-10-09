package br.com.lanchemania.lanchemania.controller;

import br.com.lanchemania.lanchemania.mapper.PedidoMapper;
import br.com.lanchemania.lanchemania.service.PedidoService;
import br.com.lanchemania.lanchemania.vo.PedidoVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pedido")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    @Autowired
    private PedidoMapper pedidoMapper;

    @PostMapping
    public ResponseEntity<Void> incluir(@RequestBody PedidoVO vo){
        pedidoService.finalizarPedido(vo);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PedidoVO> buscar(@PathVariable Long id){
        return ResponseEntity.ok(pedidoMapper.mapToVO(pedidoService.buscar(id)));
    }
}
