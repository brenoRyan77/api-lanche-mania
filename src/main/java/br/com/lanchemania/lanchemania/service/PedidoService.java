package br.com.lanchemania.lanchemania.service;

import br.com.lanchemania.lanchemania.exception.BusinessException;
import br.com.lanchemania.lanchemania.mapper.PedidoMapper;
import br.com.lanchemania.lanchemania.model.ItemPedido;
import br.com.lanchemania.lanchemania.model.Pedido;
import br.com.lanchemania.lanchemania.repository.PedidoRepository;
import br.com.lanchemania.lanchemania.util.enumerate.StatusPedido;
import br.com.lanchemania.lanchemania.vo.PedidoVO;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private PedidoMapper pedidoMapper;

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private CardapioService cardapioService;

    @Autowired
    private EntityManager entityManager;

    @Transactional
    public void finalizarPedido(PedidoVO pedidoVO) {
        Pedido novoPedido = pedidoMapper.mapToEntity(pedidoVO);
        novoPedido.setStatus(StatusPedido.RECEBIDO);
        novoPedido.setNumeroPedido(gerarNumeroPedido());
        novoPedido.setTotal(pedidoVO.getItens().stream().mapToDouble(PedidoVO.ItemPedidoVO::getSubtotal).sum());
        novoPedido.setCliente(clienteService.buscar(pedidoVO.getCliente().getId()));
        pedidoVO.getItens().forEach(item -> {
            ItemPedido itemPedido = new ItemPedido();
            itemPedido.setObservacao(item.getObservacao());
            itemPedido.setCardapio(cardapioService.buscar(item.getCardapio().getId()));
            itemPedido.setQuantidade(item.getQuantidade());
            itemPedido.setPedido(novoPedido);
            itemPedido.setSubtotal(itemPedido.getCardapio().getPreco() * item.getQuantidade());
            novoPedido.getItens().add(itemPedido);
        });
        pedidoRepository.save(novoPedido);
    }

    public Pedido buscar(Long id) {
        return pedidoRepository.findByIdLazyValues(id).orElseThrow(() -> new BusinessException("Pedido não encontrado", id));
    }

    private Long gerarNumeroPedido(){
        return (Long) entityManager.createNativeQuery("SELECT gerar_numero_pedido()")
                .getSingleResult();
    }
}
