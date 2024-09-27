package br.com.lanchemania.lanchemania.mapper;

import br.com.lanchemania.lanchemania.model.Cliente;
import br.com.lanchemania.lanchemania.model.Endereco;
import br.com.lanchemania.lanchemania.vo.ClienteVO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface ClienteMapper {

    Cliente mapToEntity(ClienteVO clienteVO);
    ClienteVO mapToVO(Cliente cliente);

    @Mapping(target = "endereco", ignore = true)
    void updateEntity(@MappingTarget Cliente cliente, ClienteVO clienteVO);

   void updateEndereco(@MappingTarget Endereco endereco, ClienteVO.EnderecoVO enderecoVO);
}
