package br.com.lanchemania.lanchemania.controller;

import br.com.lanchemania.lanchemania.mapper.ClienteMapper;
import br.com.lanchemania.lanchemania.service.ClienteService;
import br.com.lanchemania.lanchemania.vo.ClienteVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private ClienteMapper clienteMapper;

    @PostMapping
    public ResponseEntity<Void> manter(@RequestBody ClienteVO vo) {
        clienteService.manter(vo);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClienteVO> buscar(@PathVariable("id") Long id) {
        return ResponseEntity.ok(clienteMapper.mapToVO(clienteService.buscar(id)));
    }
}
