package br.com.lanchemania.lanchemania.mapper;

import br.com.lanchemania.lanchemania.model.Cliente;
import br.com.lanchemania.lanchemania.vo.ClienteVO;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface ClienteMapper {

    Cliente mapToEntity(ClienteVO clienteVO);
    ClienteVO mapToVO(Cliente cliente);
    void updateEntity(@MappingTarget Cliente cliente, ClienteVO clienteVO);
}
