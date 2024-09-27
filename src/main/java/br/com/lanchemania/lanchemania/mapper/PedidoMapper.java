package br.com.lanchemania.lanchemania.mapper;

import br.com.lanchemania.lanchemania.model.Pedido;
import br.com.lanchemania.lanchemania.vo.PedidoVO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface PedidoMapper {

    @Mapping(target = "cliente", ignore = true)
    @Mapping(target = "itens", ignore = true)
    @Mapping(target = "status", ignore = true)
    Pedido mapToEntity(PedidoVO pedidoVO);
    PedidoVO mapToVO(Pedido pedido);
    void updateEntity(@MappingTarget Pedido pedido, PedidoVO pedidoVO);
}
