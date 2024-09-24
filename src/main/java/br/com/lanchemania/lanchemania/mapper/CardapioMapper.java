package br.com.lanchemania.lanchemania.mapper;

import br.com.lanchemania.lanchemania.model.Cardapio;
import br.com.lanchemania.lanchemania.vo.CardapioVO;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface CardapioMapper {

    Cardapio mapToEntity(CardapioVO cardapioVO);
    CardapioVO mapToVO(Cardapio cardapio);
    void updateEntity(@MappingTarget Cardapio cardapio, CardapioVO cardapioVO);
}
